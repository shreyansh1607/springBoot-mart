package com.badger.mart.service;

import com.badger.mart.dtos.request.SellerRequest;
import com.badger.mart.dtos.response.CustomerResponse;
import com.badger.mart.dtos.response.SellerResponse;
import com.badger.mart.exception.CustomerNotFoundException;
import com.badger.mart.exception.SellerNotFoundException;
import com.badger.mart.model.Customer;
import com.badger.mart.model.Seller;
import com.badger.mart.repository.SellerRepository;
import com.badger.mart.transformer.CustomerTransformer;
import com.badger.mart.transformer.SellerTransformer;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Slf4j
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest){
        Seller seller = SellerTransformer.SellerRequestToSeller(sellerRequest);
        Seller newSeller = sellerRepository.save(seller);
        return SellerTransformer.SellerToSellerResponse(newSeller);
    }

    public SellerResponse getSeller(int id) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if(optionalSeller.isEmpty()){
            throw new SellerNotFoundException("Invalid id for seller");
        }
        log.info(String.valueOf(optionalSeller));
        return SellerTransformer.SellerToSellerResponse(optionalSeller.get());
    }
}
