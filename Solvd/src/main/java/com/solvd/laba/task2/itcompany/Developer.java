package com.solvd.laba.task2.itcompany;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.laba.task2.app.Main.logger;

public class Developer extends Employee  {
    public Developer(String employeeName, int employeeId, int yearsOfWork, double hourlyRate, int weeklyHours, int age) {
        super(employeeName, employeeId, yearsOfWork, hourlyRate, weeklyHours, age);
    }
    @Override
    public List<Employee> searchEmployees(String searchTerm) {
        List<Employee> searchResults = super.searchEmployees(searchTerm);

        for (Employee employee : searchResults) {
            if (employee instanceof Developer) {
                logger.info("Similar name found for Developer: " + employee.getEmployeeName());
            }
        }

        return searchResults;
    }



    @Override
    public double evaluatePerformance(int linesOfCode) {
        // Implementation of developer performance evaluation
        //  based on the number of lines of code written
        if (linesOfCode > 1000) {
            return 5.0;
        } else if (linesOfCode > 500) {
            return 4.0;
        } else {
            return 3.0;
        }
    }

    @Override
    public String toString() {
        return "Developer: " + employeeName + ", Salary: " + salary;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Developer developer = (Developer) obj;
        return employeeId == developer.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}