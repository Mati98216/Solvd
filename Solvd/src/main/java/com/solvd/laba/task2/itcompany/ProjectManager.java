package com.solvd.laba.task2.itcompany;

import java.util.Objects;

public class ProjectManager extends Employee {
    public ProjectManager(String employeeName, int employeeId, int yearsOfWork, double hourlyRate, int weeklyHours, int age) {
        super(employeeName, employeeId, yearsOfWork, hourlyRate, weeklyHours, age);
    }

    @Override
    public double evaluatePerformance(int projectsDeliveredOnTime) {
        // Implementation of project manager performance evaluation
        // Evaluation based on project delivery dates
        if (projectsDeliveredOnTime > 10) {
            return 5.0;
        } else if (projectsDeliveredOnTime > 5) {
            return 4.0;
        } else {
            return 3.0;
        }
    }

    @Override
    public String toString() {
        return "Project Manager: " + employeeName + ", Salary: " + salary;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProjectManager manager = (ProjectManager) obj;
        return employeeId == manager.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}