package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected String employeeName;
    protected int employeeId;
    protected double salary;
    protected List<Project> assignedProjects;
    protected int yearsOfWork;
    protected double hourlyRate;

    public Employee(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
        this.assignedProjects = new ArrayList<>();
        this.yearsOfWork = yearsOfWork;
        this.hourlyRate = hourlyRate;
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
        updateSalary(project, project.getSize()); // Przekaż rozmiar projektu
    }

    public void unassignFromProject(Project project) {
        assignedProjects.remove(project);
        updateSalary(project, project.getSize()); // Przekaż rozmiar projektu
    }

    private void updateSalary(Project lastCompletedProject, ProjectSize projectSize) {
        double newSalary = getBaseSalary() + calculateBonusForYearsOfWork();
        for (Project project : assignedProjects) {
            newSalary += calculateAdditionalSalary(project);
        }

        if (lastCompletedProject != null && lastCompletedProject.getDueDate() != null && lastCompletedProject.getCompletionDate() != null) {
            newSalary += calculateProjectCompletionBonus(projectSize);
        }

        setSalary(newSalary);
    }
    protected abstract double calculateAdditionalSalary(Project project);

    protected double getBaseSalary() {
        return salary;
    }

    protected double calculateBonusForYearsOfWork() {
        // Maksymalny próg premii za lata pracy
        double maxBonus = 20000.0;

        // Stawka premii za rok pracy
        double bonusPerYear = 1000.0;

        // Oblicz premię za lata pracy, ale nie więcej niż maksymalny próg
        double yearsBonus = yearsOfWork * bonusPerYear;
        return Math.min(yearsBonus, maxBonus);
    }


    protected double calculateProjectCompletionBonus(ProjectSize projectSize) {
        // Premia za ukończenie projektu przed czasem, zależna od wielkości projektu
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

    @Override
    public String toString() {
        return "Employee: " + employeeName;
    }
}