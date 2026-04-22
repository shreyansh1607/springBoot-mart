package com.badger.mart.controller;

import com.badger.mart.dtos.request.ProductRequest;
import com.badger.mart.dtos.response.ProductResponse;
import com.badger.mart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest , @RequestParam int id){
        ProductResponse productResponse = productService.addProduct(productRequest , id);
        return new ResponseEntity(productResponse , HttpStatus.CREATED);
    }
}
