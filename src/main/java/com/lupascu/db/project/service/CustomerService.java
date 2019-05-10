package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.TokenNotValidException;

public interface CustomerService {
    Boolean isTokenInDatabase(String token) throws TokenNotValidException;
}
