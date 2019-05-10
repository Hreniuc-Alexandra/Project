package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.model.Customer;
import com.lupascu.db.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Boolean isTokenInDatabase(String token) throws TokenNotValidException {
        Customer customer = customerRepository.getCustomerByToken(token).orElseThrow(() -> new TokenNotValidException("This token does not exist"));
        return customer.getToken() != null;
    }
}
