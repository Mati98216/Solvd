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
    protected int weeklyHours; // Dodajemy pole weeklyHours

    public Employee(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate, int weeklyHours) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
        this.assignedProjects = new ArrayList<>();
        this.yearsOfWork = yearsOfWork;
        this.hourlyRate = hourlyRate;
        this.weeklyHours = weeklyHours; // Inicjalizujemy weeklyHours
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

    public void assignToProject(Project project, int overtimeHours) {
        assignedProjects.add(project);
        updateSalary(project, project.getSize(), overtimeHours);
    }

    public void unassignFromProject(Project project, int overtimeHours) {
        assignedProjects.remove(project);
        updateSalary(project, project.getSize(), overtimeHours);
    }

    protected double evaluatePerformance() {
        // Domyślna implementacja oceny wydajności pracownika
        return 3.0; // Przeciętna wydajność
    }

    protected double calculateBaseSalary() {
        return hourlyRate * weeklyHours; // Używamy weeklyHours do obliczenia wynagrodzenia
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

    private void updateSalary(Project lastCompletedProject, ProjectSize projectSize, int overtimeHours) {
        double newSalary = calculateBaseSalary() + calculateBonusForYearsOfWork();
        if (lastCompletedProject != null && lastCompletedProject.getDueDate() != null && lastCompletedProject.getCompletionDate() != null) {
            newSalary += calculateProjectCompletionBonus(projectSize);
        }
        setSalary(newSalary);
    }

    @Override
    public String toString() {
        return "Employee: " + employeeName + ", Salary: " + salary;
    }
}

