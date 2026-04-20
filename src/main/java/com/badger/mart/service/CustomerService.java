package com.badger.mart.service;

import com.badger.mart.dtos.request.CustomerRequest;
import com.badger.mart.dtos.response.CustomerResponse;
import com.badger.mart.exception.CustomerNotFoundException;
import com.badger.mart.model.Customer;
import com.badger.mart.repository.CustomerRepository;
import com.badger.mart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);
        Customer newCustomer = customerRepository.save(customer);
        return CustomerTransformer.CustomerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomer(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid id");
        }
        return CustomerTransformer.CustomerToCustomerResponse(optionalCustomer.get());
    }
}
