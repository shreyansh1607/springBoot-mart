package com.badger.mart.dtos.request;

import com.badger.mart.enums.Category;
import com.badger.mart.model.Seller;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {
    private String name;
    private int price;
    private Category category;
}
