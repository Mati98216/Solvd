package com.solvd.laba.lecture2.app;


import com.solvd.laba.lecture2.interfaces.TaskManagementServiceInterface;
import com.solvd.laba.lecture2.itcompany.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ITCompany company = new ITCompany("My IT Company", 2000, 1000000.0);

        Customer customer = new Customer("Customer Name", "customer@email.com", "123-456-789");
        // Create and add projects to the company
        Project project = new Project("Project Name", "Project Description", ProjectSize.MEDIUM, customer);
        company.addProject(project);

        // Create and add employees to the company
        Developer developer1 = new Developer("Dev 1", 1, 3, 25.0, 40);
        Developer developer2 = new Developer("Dev 2", 2, 5, 28.0, 40);
        ProjectManager projectManager = new ProjectManager("Project Manager", 3, 8, 35.0, 40);
        Tester tester = new Tester("Tester", 4,2, 20.0, 40);

        company.addEmployee(developer1);
        company.addEmployee(developer2);
        company.addEmployee(projectManager);
        company.addEmployee(tester);


        // Create a team and add employees to it
        Team team = new Team("Development Team");
        team.addTeamMember(developer1);
        team.addTeamMember(developer2);
        team.addTeamMember(tester);
        team.addTeamMember(projectManager);
        // Assign the team to the project
        project.assignToTeam(team);
        project.assignedTeam(team);
        // Calculate employee salaries and display information for the assigned team
        company.calculateAndDisplayTeamSalaries(project);
        // Calculate the project cost
        double projectCost = company.calculateTotalProjectCost(team);
        System.out.println("Project Cost: " + projectCost);

        // Display project information
        System.out.println("Project Information:");
        System.out.println(project);

        // Search for employees based on a search term (e.g., "Dev")
        String searchTerm = "Dev";
        List<Employee> searchResults = new ArrayList<>();

        for (Employee employee : company.getEmployees()) {
            searchResults.addAll(employee.searchEmployees(searchTerm));
        }
        // Display search results
        System.out.println("Search Results for '" + searchTerm + "':");
        for (Employee result : searchResults) {
            System.out.println(result.toString());
        }
        Service service1 = new Service("Service 1", 50.0, "Description 1");
        Service service2 = new Service("Service 2", 75.0, "Description 2");

        customer.subscribeToService(service1, 6); // Subskrypcja usługi na 6 miesięcy
        double monthlyCost1 = customer.calculateMonthlyServiceCost();
        // Oblicz miesięczny koszt usług dla klientów
        System.out.println("\nMonthly Service Cost for Customer 1: $" + monthlyCost1);
        System.out.println(customer.toString());

        team.removeTeamMember(developer1);
        System.out.println("\nUpdated Team Members:");
        for (Employee employee : team.getTeamMembers()) {
            System.out.println(employee.toString());
        }
        System.out.println("Evaluate Performance for Developer 1: " + developer1.evaluatePerformance(646));
        System.out.println("Evaluate Performance for Developer 1: " + developer2.evaluatePerformance(300));
        System.out.println("Evaluate Performance for Developer 1: " + projectManager.evaluatePerformance(11));
        System.out.println("Evaluate Performance for Developer 1: " + tester.evaluatePerformance(57));

        TaskManagementServiceInterface taskManagementService = new TaskManagementServiceImpl();
        taskManagementService.createTask(project, "Task 1", "Implement feature X");
        taskManagementService.assignTask(team, "Task 1");
        taskManagementService.completeTask(team, "Task 1");
        System.out.println("Current projects: "+ Project.getProjectCounter());
    }
}