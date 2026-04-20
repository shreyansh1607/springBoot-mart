package com.badger.mart.transformer;

import com.badger.mart.dtos.request.CustomerRequest;
import com.badger.mart.dtos.response.CustomerResponse;
import com.badger.mart.model.Customer;
import lombok.experimental.UtilityClass;


public class CustomerTransformer {
    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .mobile_No(customerRequest.getMobile_No())
                .gender(customerRequest.getGender())
                .age(customerRequest.getAge())
                .build();
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobile_No(customer.getMobile_No())
                .gender(customer.getGender())
                .age(customer.getAge())
                .date(customer.getDate())
                .build();
    }

}
