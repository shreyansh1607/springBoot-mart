package com.badger.mart.transformer;

import com.badger.mart.dtos.request.ProductRequest;
import com.badger.mart.dtos.response.ProductResponse;
import com.badger.mart.model.Product;

import java.util.ArrayList;

public class ProductTransformer {

    public static Product ProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .reviews(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .id(product.getId())
                .price(product.getPrice())
                .category(product.getCategory())
                .seller(SellerTransformer.SellerToSellerResponse(product.getSeller()))
                .build();
    }
}
