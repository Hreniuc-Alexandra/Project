package com.lupascu.db.project.api;

import com.lupascu.db.project.exceptions.CredentialException;
import com.lupascu.db.project.exceptions.PurchaseException;
import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.payload.ApiResponse;
import com.lupascu.db.project.payload.PurchaseDTO;
import com.lupascu.db.project.service.CustomerService;
import com.lupascu.db.project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController extends DBProjectController {
    private static final String API_NAME="/orders";

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(OrdersController.API_NAME)
    public ResponseEntity postPurchase(@RequestBody PurchaseDTO purchaseDTO) throws PurchaseException, CredentialException, TokenNotValidException {
        return new ResponseEntity<>(new ApiResponse<>(null,purchaseService.processPurchase(purchaseDTO)), HttpStatus.OK);
    }

    @GetMapping(OrdersController.API_NAME)
    public ResponseEntity getPurchasesForCustomer(@RequestParam(name="token") String token) throws PurchaseException, TokenNotValidException {
        customerService.isTokenInDatabase(token);
        return new ResponseEntity<>(new ApiResponse<>(null,purchaseService.getPurchasesPerCustomer(token)), HttpStatus.OK);
    }
}
