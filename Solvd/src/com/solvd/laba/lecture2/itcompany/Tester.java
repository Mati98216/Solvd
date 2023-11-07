package com.solvd.laba.lecture2.itcompany;

import java.util.Objects;

public class Tester extends Employee {
    public Tester(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate) {
        super(employeeName, employeeId, salary, yearsOfWork, hourlyRate);
    }

    @Override
    protected double calculateAdditionalSalary(Project project) {
        return project.getEstimatedCost() * 0.04;
    }

    @Override
    public String toString() {
        return "Tester: " + employeeName;
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