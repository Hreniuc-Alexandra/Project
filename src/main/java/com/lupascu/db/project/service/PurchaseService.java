package com.lupascu.db.project.service;

import com.lupascu.db.project.exceptions.CredentialException;
import com.lupascu.db.project.exceptions.PurchaseException;
import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.model.Purchase;
import com.lupascu.db.project.payload.ApiResponse;
import com.lupascu.db.project.payload.PurchaseDTO;

import java.util.List;

public interface PurchaseService {
    public List<Purchase> getPurchasesPerCustomer(String token) throws TokenNotValidException, PurchaseException;

    ApiResponse processPurchase(PurchaseDTO postPurchaseDTO) throws CredentialException, TokenNotValidException, PurchaseException;
}
