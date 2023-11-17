package com.solvd.laba.lecture2.itcompany;


import java.util.Objects;

public class Developer extends Employee  {
    public Developer(String employeeName, int employeeId, int yearsOfWork, double hourlyRate, int weeklyHours) {
        super(employeeName, employeeId, yearsOfWork, hourlyRate, weeklyHours);
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