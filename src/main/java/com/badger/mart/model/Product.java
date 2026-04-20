package com.badger.mart.model;

import com.badger.mart.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review> reviews = new ArrayList<>();

    @ManyToMany
    List<OrderEntity> orders = new ArrayList<>();
}
