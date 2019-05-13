package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.CredentialException;
import com.lupascu.db.project.exceptions.PurchaseException;
import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.model.Customer;
import com.lupascu.db.project.model.Purchase;
import com.lupascu.db.project.payload.ApiResponse;
import com.lupascu.db.project.payload.PurchaseDTO;
import com.lupascu.db.project.repository.CustomerRepository;
import com.lupascu.db.project.repository.DishRepository;
import com.lupascu.db.project.repository.OrderItemRepository;
import com.lupascu.db.project.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Purchase> getPurchasesPerCustomer(String token) throws TokenNotValidException, PurchaseException {
        Long customerId = customerRepository.getCustomerIdFromToken(token).orElseThrow(() -> new TokenNotValidException("Token not valid."));
        return purchaseRepository.getPurchasesPerCustomer(customerId).orElseThrow(() -> new PurchaseException("Customer has no purchases"));
    }

    @Override
    public ApiResponse processPurchase(PurchaseDTO purchaseDTO) throws CredentialException, TokenNotValidException, PurchaseException {
        if (purchaseDTO.getOrders().isEmpty()) throw new PurchaseException("You have to order something.");
        if (hasCredentials(purchaseDTO) && hasToken(purchaseDTO) && isFirstPurchase(purchaseDTO)) {
            //prima cumparare(email si token unice nu sunt in db)
            return processFirstPurchase(purchaseDTO);
        } else if (hasToken(purchaseDTO) && !hasCredentials(purchaseDTO)) {
            //cumparari ulterioare, token in db, restul DTO gol
            return processPurchaseByToken(purchaseDTO);
        } else if (!hasToken(purchaseDTO) && hasCredentials(purchaseDTO)) {
            //cumparare fara token => fara inserare customer in db
            return processPurchaseWithoutToken(purchaseDTO);
        } else throw new PurchaseException("Invalid Credentials");
    }

    private Boolean isFirstPurchase(PurchaseDTO purchaseDTO) {
        return !customerRepository.getCustomerByEmail(purchaseDTO.getEmail()).isPresent() && !customerRepository.getCustomerByToken(purchaseDTO.getToken()).isPresent();
    }

    public Boolean hasCredentials(PurchaseDTO purchaseDTO) {
        return purchaseDTO.getEmail() != null && purchaseDTO.getFirstName() != null && purchaseDTO.getLastName() != null;
    }

    public Boolean hasToken(PurchaseDTO purchaseDTO) {
        return purchaseDTO.getToken() != null;
    }

    @Transactional
    public ApiResponse processPurchaseWithoutToken(PurchaseDTO purchaseDTO) throws PurchaseException {
        try {
            Long purchaseId = purchaseRepository.getLastId() + 1L;
            purchaseRepository.insertPurchase(null,purchaseDTO.getExtraFees());
            purchaseDTO.getOrders().forEach(orderItemDTO -> orderItemRepository.insertOrder(orderItemDTO.getQuantity(), orderItemDTO.getDishId(), purchaseId));
            return new ApiResponse<>(null,"Order added successfully.");
        } catch (Exception e) {
            throw new PurchaseException(e.getMessage());
        }
    }

    @Transactional
    public ApiResponse processFirstPurchase(PurchaseDTO purchaseDTO) throws PurchaseException {
        try {
            Long customer = customerRepository.getLastId() + 1L;
            customerRepository.insertUser(purchaseDTO.getEmail(), purchaseDTO.getFirstName(), purchaseDTO.getLastName(), purchaseDTO.getToken());
            Long purchaseId = purchaseRepository.getLastId() + 1L;
            purchaseRepository.insertPurchase(customer,purchaseDTO.getExtraFees());
            purchaseDTO.getOrders().forEach(orderItemDTO -> orderItemRepository.insertOrder(orderItemDTO.getQuantity(), orderItemDTO.getDishId(), purchaseId));
            return new ApiResponse<>(null,"Order added successfully and customer added to database.");
        } catch (Exception e) {
            throw new PurchaseException(e.getMessage());
        }
    }

    @Transactional
    public ApiResponse processPurchaseByToken(PurchaseDTO purchaseDTO) throws  PurchaseException {
        try {
            Customer customer = customerRepository.getCustomerByToken(purchaseDTO.getToken()).orElseThrow(() -> new TokenNotValidException("Invalid token"));
            Long purchaseId = purchaseRepository.getLastId() + 1L;
            purchaseRepository.insertPurchase(customer.getId(),purchaseDTO.getExtraFees());
            purchaseDTO.getOrders().forEach(orderItemDTO -> orderItemRepository.insertOrder(orderItemDTO.getQuantity(), orderItemDTO.getDishId(), purchaseId));
            return new ApiResponse<>(null,"Order added successfully.");
        } catch (Exception e) {
            throw new PurchaseException(e.getMessage());
        }
    }


}


