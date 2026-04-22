package com.badger.mart.service;

import com.badger.mart.dtos.request.ProductRequest;
import com.badger.mart.dtos.response.ProductResponse;
import com.badger.mart.exception.ProductNotFoundException;
import com.badger.mart.model.Product;
import com.badger.mart.model.Seller;
import com.badger.mart.repository.ProductRepository;
import com.badger.mart.repository.SellerRepository;
import com.badger.mart.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(ProductRequest productRequest, int id) {
        Product product = ProductTransformer.ProductRequestToProduct(productRequest);

        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isEmpty()) throw new ProductNotFoundException("Product not Found");

        Seller seller = optionalSeller.get();
        seller.getProducts().add(product);
        product.setSeller(seller);

        Seller savedSeller = sellerRepository.save(seller);

        int size = savedSeller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size-1);
        return ProductTransformer.productToProductResponse(savedProduct);

    }
}
