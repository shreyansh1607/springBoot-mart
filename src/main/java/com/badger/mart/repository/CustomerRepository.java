package com.badger.mart.repository;

import com.badger.mart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {
}
