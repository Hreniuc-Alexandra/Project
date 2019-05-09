package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Purchase;

import java.util.List;

public interface PurchaseService {
    public List<Purchase> getPurchasesPerCustomer(String token);
}
