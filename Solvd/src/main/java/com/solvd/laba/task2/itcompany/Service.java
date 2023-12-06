package com.solvd.laba.task2.itcompany;

public class Service {
    private String serviceName;
    private double pricePerMonth;
    private String description;

    public Service(String serviceName, double pricePerMonth, String description) {
        this.serviceName = serviceName;
        this.pricePerMonth = pricePerMonth;
        this.description = description;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double price) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}