package com.badger.mart.dtos.request;

import com.badger.mart.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {
    private String name;
    private String email;
    private String mobile_No;
    private Gender gender;
    private int age;
}
