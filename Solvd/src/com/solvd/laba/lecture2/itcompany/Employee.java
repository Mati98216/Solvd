package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.interfaces.EmployeeActionsInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements EmployeeActionsInterface {
    protected String employeeName;
    protected int employeeId;
    protected double salary;
    protected List<Project> assignedProjects;
    protected int yearsOfWork;
    protected double hourlyRate;
    protected int weeklyHours;

    public Employee(String employeeName, int employeeId, int yearsOfWork, double hourlyRate, int weeklyHours) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.assignedProjects = new ArrayList<>();
        this.yearsOfWork = yearsOfWork;
        this.hourlyRate = hourlyRate;
        this.weeklyHours = weeklyHours;
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


    protected abstract double evaluatePerformance(int value);


    protected double calculateBaseSalary() {
        return hourlyRate * weeklyHours; // We use weeklyHours to calculate wages
    }

    protected double calculateBonusForYearsOfWork() {
        double maxBonus = 20000.0;
        double bonusPerYear = 100.0;
        double yearsBonus = yearsOfWork * bonusPerYear;
        return Math.min(yearsBonus, maxBonus);
    }

    protected double calculateProjectCompletionBonus(ProjectSize projectSize) {
        double bonus = 0.0;
        switch (projectSize) {
            case SMALL:
                bonus = 1000.0;
                break;
            case MEDIUM:
                bonus = 1500.0;
                break;
            case LARGE:
                bonus = 2000.0;
                break;
            default:
                break;
        }
        return bonus;
    }

    protected  void updateSalary(Project lastCompletedProject, ProjectSize projectSize) {
        double newSalary = calculateBaseSalary() + calculateBonusForYearsOfWork();
        if (lastCompletedProject != null && lastCompletedProject.getDueDate() != null && lastCompletedProject.getCompletionDate() != null) {
            newSalary += calculateProjectCompletionBonus(projectSize);
        }
        setSalary(newSalary);
    }
    @Override
    public List<Employee> searchEmployees(String searchTerm) {
        List<Employee> searchResults = new ArrayList<>();

        if (employeeName.toLowerCase().contains(searchTerm.toLowerCase())) {
            searchResults.add(this);
        }

        return searchResults;
    }

    @Override
    public String toString() {
        return "Employee: " + employeeName + ", Salary: " + salary;
    }

}

