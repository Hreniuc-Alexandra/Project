package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Purchase;
import com.lupascu.db.project.repository.CustomerRepository;
import com.lupascu.db.project.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> getPurchasesPerCustomer(String token) {
        Long customerId = customerRepository.getCustomerIdFromToken(token);
        return purchaseRepository.getPurchasesPerCustomer(customerId);
    }
}
