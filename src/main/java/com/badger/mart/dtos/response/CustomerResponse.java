package com.badger.mart.dtos.response;

import com.badger.mart.enums.Gender;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private int id;
    private String name;
    private String email;
    private String mobile_No;
    private Gender gender;
    private int age;
    private Date date;
}
