package com.solvd.laba.lecture2.itcompany;

import java.util.Objects;

public class ProjectManager extends Employee {
    public ProjectManager(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate, int weeklyHours) {
        super(employeeName, employeeId, salary, yearsOfWork, hourlyRate, weeklyHours);
    }

    @Override
    protected double evaluatePerformance() {
        // Implementacja oceny wydajności kierownika projektu
        // Przykład: ocena na podstawie terminów dostarczania projektów
        int projectsDeliveredOnTime = 8; // Przykład: liczba projektów dostarczonych na czas
        if (projectsDeliveredOnTime > 10) {
            return 5.0; // Doskonała wydajność
        } else if (projectsDeliveredOnTime > 5) {
            return 4.0; // Dobra wydajność
        } else {
            return 3.0; // Przeciętna wydajność
        }
    }

    @Override
    public String toString() {
        return "Project Manager: " + employeeName + ", Salary: " + salary;
    }
}