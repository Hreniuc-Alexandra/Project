package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.model.Customer;
import com.lupascu.db.project.payload.ApiResponse;
import com.lupascu.db.project.repository.CustomerRepository;
import com.lupascu.db.project.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Boolean isTokenInDatabase(String token) throws TokenNotValidException {
        Customer customer = customerRepository.getCustomerByToken(token).orElseThrow(() -> new TokenNotValidException("This token does not exist"));
        return customer.getToken() != null;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseEntity deleteCustomer(String token) throws TokenNotValidException {
        try {
            Long customer_id = customerRepository.getCustomerIdFromToken(token).orElseThrow(() -> new TokenNotValidException("Invalid token"));
            purchaseRepository.preparePurchaseForCustomerDeletion(customer_id);
            customerRepository.deleteCustomerByToken(token);
            return new ResponseEntity<>(new ApiResponse<>(null, "Customer deleted successfully."), HttpStatus.OK);
        } catch (Exception e) {
            throw new TokenNotValidException(e.getMessage());
        }

    }
}
