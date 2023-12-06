package com.solvd.laba.task2.itcompany;

public enum PaymentStatus {
    PAID("Paid"),
    PENDING("Pending"),
    OVERDUE("Overdue");


    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printDescription() {
        System.out.println("Payment status: " + description);
    }
}
