package com.bookstore.demo.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String msg){
        super(msg);
    }
}
