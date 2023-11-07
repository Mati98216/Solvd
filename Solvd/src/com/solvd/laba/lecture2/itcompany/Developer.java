package com.solvd.laba.lecture2.itcompany;


public class Developer extends Employee {
    public Developer(String employeeName, int employeeId, double salary, int yearsOfWork, double hourlyRate, int weeklyHours) {
        super(employeeName, employeeId, salary, yearsOfWork, hourlyRate, weeklyHours);
    }

    @Override
    protected double evaluatePerformance() {
        // Implementacja oceny wydajności developera
        // Przykład: ocena na podstawie liczby napisanych linii kodu
        int linesOfCode = 1000; // Przykład: liczba napisanych linii kodu
        if (linesOfCode > 1000) {
            return 5.0; // Doskonała wydajność
        } else if (linesOfCode > 500) {
            return 4.0; // Dobra wydajność
        } else {
            return 3.0; // Przeciętna wydajność
        }
    }

    @Override
    public String toString() {
        return "Developer: " + employeeName + ", Salary: " + salary;
    }
}