package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.ServiceSubscriptionException;
import com.solvd.laba.task2.interfaces.CustomerServicesInterface;

import java.time.LocalDate;


import static com.solvd.laba.task2.app.Main.logger;

public class Customer implements CustomerServicesInterface {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String company;
    private Service service;
    private int serviceDurationInMonths;
    private boolean hasPreviousProjects;
    private LocalDate paymentDueDate;
    private PaymentStatus paymentStatus;

    public Customer(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasPreviousProjects = false;
        this.service = null;
        this.serviceDurationInMonths = 0;
        this.paymentDueDate = null;
        this.paymentStatus = PaymentStatus.PENDING;
    }
    public Customer() {
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
    public void subscribeToService(Service service, int durationInMonths) throws ServiceSubscriptionException {
        if (service == null || durationInMonths <= 0) {
            throw new ServiceSubscriptionException("Invalid service subscription parameters.");
        }

        this.service = service;
        this.serviceDurationInMonths = durationInMonths;


        paymentDueDate = LocalDate.now().plusMonths(1);


        paymentDueDate = paymentDueDate.plusMonths(durationInMonths);


        for (int i = 0; i < durationInMonths; i++) {

            paymentDueDate = paymentDueDate.minusMonths(1);


            logger.info("Payment due in month " + (i + 1) + ": " + paymentDueDate);
        }
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
        String paymentInfo = generatePaymentInfo();
        return "Customer Information:\n" +
                "Name: " + getCustomerName() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Monthly Service Cost: $" + calculateMonthlyServiceCost() +
                paymentInfo;
    }
    public void setPaymentStatus(boolean isPaid) {
        LocalDate currentDate = LocalDate.now();

        if (!isPaid && paymentDueDate != null && currentDate.isAfter(paymentDueDate)) {
            paymentStatus = PaymentStatus.OVERDUE;
        } else if (isPaid) {
            paymentStatus = PaymentStatus.PAID;
        } else {
            paymentStatus = PaymentStatus.PENDING;
        }
    }
    private String generatePaymentInfo() {
        String paymentDescription;
        if (paymentDueDate != null) {
            paymentDescription = "\nPayment Due Date: " + paymentDueDate +
                    "\nPayment Status: " + paymentStatus.getDescription();
        } else {
            paymentDescription = "";
        }
        return paymentDescription;
    }

    public void checkPaymentStatusAndNextDue(boolean isPaid) {
        LocalDate currentDate = LocalDate.now();


        if (paymentDueDate != null && currentDate.isEqual(paymentDueDate)) {
            isPaid = true;
        }

        setPaymentStatus(isPaid);
        PaymentStatus currentPaymentStatus = paymentStatus;

        String paymentInfo = "";
        if (paymentDueDate != null) {
            paymentInfo = "\nPayment Due Date: " + paymentDueDate +
                    "\nPayment Status: " + currentPaymentStatus.getDescription();
        }

        LocalDate nextPaymentDate = paymentDueDate != null ? paymentDueDate.plusMonths(1) : null;

        String nextPaymentInfo = "";
        if (nextPaymentDate != null) {
            nextPaymentInfo = "\nNext Payment Due Date: " + nextPaymentDate;
        }

        logger.info("Payment Made: " + (currentPaymentStatus == PaymentStatus.PAID ? "Yes" : "No"));
        logger.info("Payment Information: " + paymentInfo);
        logger.info("Next Payment Information: " + nextPaymentInfo);
    }
}