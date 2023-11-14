package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.interfaces.CustomerServicesInterface;

public class Customer implements CustomerServicesInterface {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String company;
    private Service service;
    private int serviceDurationInMonths;
    private boolean hasPreviousProjects;

    public Customer(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasPreviousProjects = false;
        this.service = null;
        this.serviceDurationInMonths = 0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean hasPreviousProjects() {
        return hasPreviousProjects;
    }

    public Service getService() {
        return service;
    }

    public int getServiceDurationInMonths() {
        return serviceDurationInMonths;
    }

    public void setHasPreviousProjects(boolean hasPreviousProjects) {
        this.hasPreviousProjects = hasPreviousProjects;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void subscribeToService(Service service, int durationInMonths) {
        this.service = service;
        this.serviceDurationInMonths = durationInMonths;
    }

    @Override
    public double calculateMonthlyServiceCost() {
        if (service != null) {
            double pricePerMonth = service.getPricePerMonth();
            return pricePerMonth * serviceDurationInMonths;
        }
        return 0.0;
    }
    @Override
    public String toString() {
        return "Customer Information:\n" +
                "Name: " + getCustomerName() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Monthly Service Cost: $" + calculateMonthlyServiceCost();
    }
}