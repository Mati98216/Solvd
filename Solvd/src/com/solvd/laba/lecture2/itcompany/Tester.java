package com.solvd.laba.lecture2.itcompany;

import java.util.Objects;

public class Tester extends Employee {
    public Tester(String employeeName, int employeeId,int yearsOfWork, double hourlyRate, int weeklyHours) {
        super(employeeName, employeeId, yearsOfWork, hourlyRate, weeklyHours);
    }
    public void updateSalaryForProject(Project project, ProjectSize projectSize) {
        updateSalary(project, projectSize);
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