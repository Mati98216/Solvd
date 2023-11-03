package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String employeeName;
    protected int employeeId;
    protected double salary;
    protected List<Project> assignedProjects;

    public Employee(String employeeName, int employeeId, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
        assignedProjects = new ArrayList<>();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public void assignToProject(Project project) {
        assignedProjects.add(project);
        updateSalary(project);
    }

    public void unassignFromProject(Project project) {
        assignedProjects.remove(project);
        updateSalary(project);
    }

    private void updateSalary(Project lastCompletedProject) {
        double newSalary = getBaseSalary();
        for (Project project : assignedProjects) {
            newSalary += calculateAdditionalSalary(project);
        }

        if (lastCompletedProject != null) {
            if (lastCompletedProject.getCustomer().hasPreviousProjects() && lastCompletedProject.getCompletionDate() != null) {
                if (lastCompletedProject.getDueDate() != null && lastCompletedProject.getDueDate().isBefore(lastCompletedProject.getCompletionDate())) {
                } else {

                    newSalary += 1000;
                }
            }
        }

        setSalary(newSalary);
    }

    protected abstract double calculateAdditionalSalary(Project project);

    protected double getBaseSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee: " + employeeName;
    }
}