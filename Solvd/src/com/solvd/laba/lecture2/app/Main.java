package com.solvd.laba.lecture2.app;

import com.solvd.laba.lecture2.itcompany.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("Customer 1", "customer@example.com", "123-456-7890");
        customer.setHasPreviousProjects(false);
        customer.setCompany("ABC Corp");

        // Create a project
        Project project = new Project("Sample Project", "Sample description", ProjectSize.MEDIUM, 100, customer);
        project.setDueDate(LocalDate.of(2023, 11, 15));
        project.setCompletionDate(LocalDate.of(2023, 11, 02));

        // Create employees
        Developer developer1 = new Developer("Dev 1", 1001, 70000);
        Developer developer2 =  new Developer("Dev 2", 1002, 75000);
        ProjectManager manager = new ProjectManager("PM 1", 2001, 90000);
        Tester tester = new Tester("Tester 1", 3001, 65000);

        // Assign employees to the project
        developer1.assignToProject(project);
        developer2.assignToProject(project);
        manager.assignToProject(project);
        tester.assignToProject(project);

        // Calculate and display employee salaries
        displayEmployeeSalary(developer1);
        displayEmployeeSalary(developer2);
        displayEmployeeSalary(manager);
        displayEmployeeSalary(tester);

        // Display employee information using the overridden toString() method
        System.out.println(developer1);
        System.out.println(developer2);
        System.out.println(manager);
        System.out.println(tester);

        // Additional functionality
        displayAssignedProjects(developer1);
        displayProjectStatus(project);
    }

    public static void displayEmployeeSalary(Employee employee) {
        System.out.println(employee.getEmployeeName() + "'s salary: $" + employee.getSalary());
    }

    public static void displayAssignedProjects(Employee employee) {
        System.out.println(employee.getEmployeeName() + " is assigned to the following projects:");
        for (Project project : employee.getAssignedProjects()) {
            System.out.println("- " + project.getProjectName());
        }
    }

    public static void displayProjectStatus(Project project) {
        System.out.println("Project status for " + project.getProjectName() + ":");
        System.out.println("Completed: " + project.isCompleted());
        System.out.println("Overdue: " + project.isOverdue());
    }
}