package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Customer;
import com.lupascu.db.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Boolean isTokenValid(String token) {
        Customer customer = customerRepository.getCustomerByToken(token).orElse(new Customer("EmptyCustomer"));
        return customer.getToken() != null;
    }
}
