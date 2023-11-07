package com.solvd.laba.lecture2.itcompany;

import java.util.Objects;

public class Tester extends Employee {
    public Tester(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate, int weeklyHours) {
        super(employeeName, employeeId, salary, yearsOfWork, hourlyRate, weeklyHours);
    }

    @Override
    protected double evaluatePerformance() {
        // Implementacja oceny wydajności testera
        // Przykład: ocena na podstawie liczby znalezionych błędów w oprogramowaniu
        int numberOfBugsFound = 50; // Przykład: liczba znalezionych błędów
        if (numberOfBugsFound > 100) {
            return 5.0; // Doskonała wydajność
        } else if (numberOfBugsFound > 50) {
            return 4.0; // Dobra wydajność
        } else {
            return 3.0; // Przeciętna wydajność
        }
    }

    @Override
    public String toString() {
        return "Tester: " + employeeName + ", Salary: " + salary;
    }
}