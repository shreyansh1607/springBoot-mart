package com.badger.mart.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }
}
