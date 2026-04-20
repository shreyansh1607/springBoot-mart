package com.badger.mart.dtos.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SellerResponse {
    private int id;
    private String name;
    private String pan;
    private  String email;
}
