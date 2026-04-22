package com.badger.mart.dtos.response;

import com.badger.mart.enums.Category;
import com.badger.mart.model.Seller;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {
    private int id;
    private String name;
    private int price;
    private Category category;
    private SellerResponse seller;
}
