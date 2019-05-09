package com.lupascu.db.project.api;

import com.lupascu.db.project.service.CustomerService;
import com.lupascu.db.project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController extends DBProjectController {
    private static final String API_NAME="/orders";

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private CustomerService customerService;

    //post purchase, with Customer info + purchase info

    @GetMapping(OrdersController.API_NAME)
    public ResponseEntity getPurchasesForCustomer(@RequestParam(name="token") String token)
    {
        if(customerService.isTokenValid(token)){
            return new ResponseEntity<>(purchaseService.getPurchasesPerCustomer(token), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Unauthorized",HttpStatus.UNAUTHORIZED);
    }
}
