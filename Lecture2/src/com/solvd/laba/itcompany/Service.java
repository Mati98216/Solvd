package com.solvd.laba.itcompany;

public class Service {
    private String serviceName;
    private double price;
    private String description;

    public Service(String serviceName, double price, String description) {
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}