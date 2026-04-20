package com.badger.mart.service;

import com.badger.mart.exception.CustomerNotFoundException;
import com.badger.mart.model.Customer;
import com.badger.mart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        customerRepository.save(customer);
        return customerRepository.findById(customer.getId()).orElse(new Customer());
    }

    public Customer getCustomer(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid id");
        }
        Customer customer = optionalCustomer.get();
        return customer;
    }
}
