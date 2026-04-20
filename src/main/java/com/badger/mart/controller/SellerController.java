package com.badger.mart.controller;

import com.badger.mart.dtos.request.SellerRequest;
import com.badger.mart.dtos.response.CustomerResponse;
import com.badger.mart.dtos.response.SellerResponse;
import com.badger.mart.exception.CustomerNotFoundException;
import com.badger.mart.exception.SellerNotFoundException;
import com.badger.mart.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    private static final Logger log = LoggerFactory.getLogger(SellerController.class);
    @Autowired
    SellerService sellerService;

    @PostMapping("/")
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest){
        SellerResponse sellerResponse = sellerService.addSeller(sellerRequest);
        return new ResponseEntity(sellerResponse , HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity getCustomer(@RequestParam int id){
        log.info(String.valueOf(id));
        try{
            SellerResponse sellerResponse = sellerService.getSeller(id);
            return new ResponseEntity<>(sellerResponse , HttpStatus.FOUND);
        }catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
