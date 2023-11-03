package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Developer extends Employee {
    public Developer(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId, salary);
    }

    @Override
    protected double calculateAdditionalSalary(Project project) {
        return project.getEstimatedCost() * 0.05;
    }

    // Override toString() method from Object class
    @Override
    public String toString() {
        return "Developer: " + employeeName;
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