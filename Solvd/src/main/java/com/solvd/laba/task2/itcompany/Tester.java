package com.solvd.laba.task2.itcompany;

import java.util.List;
import java.util.Objects;

import static com.solvd.laba.task2.app.Main.logger;

public class Tester extends Employee {
    public Tester(String employeeName, int employeeId,int yearsOfWork, double hourlyRate, int weeklyHours, int age) {
        super(employeeName, employeeId, yearsOfWork, hourlyRate, weeklyHours, age);
    }
    @Override
    public double evaluatePerformance(int numberOfBugsFound) {
        // Implementation of tester performance evaluation
        // Evaluation based on the number of software bugs found

        if (numberOfBugsFound > 100) {
            return 5.0;
        } else if (numberOfBugsFound > 50) {
            return 4.0;
        } else {
            return 3.0;
        }
    }

    @Override
    public List<Employee> searchEmployees(String searchTerm) {
        List<Employee> searchResults = super.searchEmployees(searchTerm);

        for (Employee employee : searchResults) {
            if (employee instanceof Tester) {
                logger.info("Similar name found for Tester: " + employee.getEmployeeName());
            }
        }

        return searchResults;
    }
    @Override
    public String toString() {
        return "Tester: " + employeeName + ", Salary: " + salary;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tester tester = (Tester) obj;
        return employeeId == tester.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}