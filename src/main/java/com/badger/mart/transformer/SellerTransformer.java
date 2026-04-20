package com.badger.mart.transformer;

import com.badger.mart.dtos.request.SellerRequest;
import com.badger.mart.dtos.response.SellerResponse;
import com.badger.mart.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .email(sellerRequest.getEmail())
                .pan(sellerRequest.getPan())
                .build();
    }

    public static SellerResponse SellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .id(seller.getId())
                .name(seller.getName())
                .email(seller.getEmail())
                .pan(seller.getPan())
                .build();
    }
}
