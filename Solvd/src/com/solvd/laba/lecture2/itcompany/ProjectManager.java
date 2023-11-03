package com.solvd.laba.lecture2.itcompany;

import java.util.Objects;

public class ProjectManager extends Employee {
    public ProjectManager(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId, salary);
    }

    @Override
    protected double calculateAdditionalSalary(Project project) {
        return project.getEstimatedCost() * 0.1;
    }

    @Override
    public String toString() {
        return "Project Manager: " + employeeName;
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