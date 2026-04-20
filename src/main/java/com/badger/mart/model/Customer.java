package com.badger.mart.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.badger.mart.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(length = 10)
    private String mobile_No;


    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private int age;

    @CreationTimestamp
    Date date;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews = new ArrayList<>();
}
