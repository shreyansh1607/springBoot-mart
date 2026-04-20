package com.badger.mart.model;


import com.badger.mart.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    private int id;

    @Column
    private int value;

    @Column
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    List<Product> products = new ArrayList<>();
}
