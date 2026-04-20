package com.badger.mart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Seller {

    @Id
    private int id;

    @Column
    private String name;

    @Column(length = 10 ,unique = true)
    private String pan;


    @Column
    public String email;

    @OneToMany(mappedBy = "seller")
    List<Product> products = new ArrayList<>();
}
