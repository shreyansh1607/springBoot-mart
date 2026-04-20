package com.badger.mart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    private int id;

    @Column
    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    private int rating;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;
}
