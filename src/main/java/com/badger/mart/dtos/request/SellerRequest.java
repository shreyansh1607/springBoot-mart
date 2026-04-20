package com.badger.mart.dtos.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SellerRequest {
    private String name;
    private String pan;
    private  String email;
}
