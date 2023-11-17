package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.exceptions.CustomerDataLoadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerDataLoader {
    public static void loadCustomerDataFromCSV(String filePath, Customer customer) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    customer.setCustomerName(data[0]);
                    customer.setEmail(data[1]);
                    customer.setPhoneNumber(data[2]);
                } else {
                    throw new CustomerDataLoadException("Invalid data format in CSV file.");
                }
            } else {
                throw new CustomerDataLoadException("Empty CSV file.");
            }
        } catch (IOException e) {
            throw new CustomerDataLoadException("Error loading customer data from CSV: " + e.getMessage());
        }
    }
}