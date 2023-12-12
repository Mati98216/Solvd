package com.solvd.laba.task2.exceptions;

public class EmployeeDataException extends RuntimeException {
    public EmployeeDataException() {
        super("Updated name is null or empty.");
    }
}
/*public class InvalidPromoCodeException extends Exception {
    public InvalidPromoCodeException() {
        super("Invalid promo code! Please try again!");
    }
}*/