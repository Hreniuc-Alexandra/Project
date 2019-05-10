package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.TokenNotValidException;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Boolean isTokenInDatabase(String token) throws TokenNotValidException;

    ResponseEntity deleteCustomer(String token) throws TokenNotValidException;
}
