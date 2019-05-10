package com.lupascu.db.project.api;

import com.lupascu.db.project.exceptions.TokenNotValidException;
import com.lupascu.db.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController extends DBProjectController {

    private static final String API_NAME="/customers";

    @Autowired
    private CustomerService customerService;

    @DeleteMapping(CustomerController.API_NAME)
    public ResponseEntity deleteCustomer(@RequestParam("token") String token) throws TokenNotValidException {
        return customerService.deleteCustomer(token);
    }

}
