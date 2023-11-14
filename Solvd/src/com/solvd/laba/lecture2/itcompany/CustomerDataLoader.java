package com.solvd.laba.lecture2.itcompany;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerDataLoader {
    public static void loadCustomerDataFromCSV(String filePath, Customer customer) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    customer.setCustomerName(data[0]);
                    customer.setEmail(data[1]);
                    customer.setPhoneNumber(data[2]);
                } else {
                    System.err.println("Invalid data format in CSV file.");
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
