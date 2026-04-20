package com.badger.mart.controller;

import com.badger.mart.exception.CustomerNotFoundException;
import com.badger.mart.model.Customer;
import com.badger.mart.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        log.info(String.valueOf(customer));
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity(addedCustomer , HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity getCustomer(@RequestParam int id){
        try{
            Customer customer = customerService.getCustomer(id);
            return new ResponseEntity<>(customer , HttpStatus.FOUND);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
