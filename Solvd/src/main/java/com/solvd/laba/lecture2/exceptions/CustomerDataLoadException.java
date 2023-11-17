package com.solvd.laba.lecture2.exceptions;

public class CustomerDataLoadException extends RuntimeException {
    public CustomerDataLoadException(String message) {
        super(message);
    }
}