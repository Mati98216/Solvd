package com.solvd.laba.lecture2.app;


import com.solvd.laba.lecture2.interfaces.TaskManagementServiceInterface;
import com.solvd.laba.lecture2.itcompany.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        logger.info("Application started.");
        ITCompany company = new ITCompany("My IT Company", 2000, 1000000.0);

        Customer customer = new Customer();
        String csvFilePath = "src/main/java/com/solvd/laba/lecture2/resources/customer_data";
        CustomerDataLoader.loadCustomerDataFromCSV(csvFilePath, customer);
        // Create and add projects to the company
        Project project = new Project("Project Name", "Project Description", ProjectSize.MEDIUM, customer, LocalDate.now(),LocalDate.of(2023,12,31));
        company.addProject(project);

        // Create and add employees to the company
        Developer developer1 = new Developer("Dev 1", 1, 3, 25.0, 40);
        Developer developer2 = new Developer("Dev 2", 2, 5, 28.0, 40);
        Developer developer3 = new Developer("Dev 3", 3, 5, 28.0, 40);
        ProjectManager projectManager = new ProjectManager("Project Manager", 3, 8, 35.0, 40);
        Tester tester = new Tester("Tester", 4,2, 20.0, 40);

        company.addEmployee(developer1);
        company.addEmployee(developer2);
        company.addEmployee(developer3);
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
        logger.info("Project Cost: " + projectCost);

        // Display project information
        logger.info("Project Information:");
        logger.info(project.toString());

        // Search for employees based on a search term (e.g., "Dev")
        String searchTerm = "Dev";
        List<Employee> searchResults = new ArrayList<>();

        for (Employee employee : company.getEmployees()) {
            searchResults.addAll(employee.searchEmployees(searchTerm));
        }
        // Display search results
        logger.info("Search Results for '" + searchTerm + "':");
        for (Employee result : searchResults) {
            logger.info(result.toString());
        }
        Service service1 = new Service("Service 1", 50.0, "Description 1");
        Service service2 = new Service("Service 2", 75.0, "Description 2");

        customer.subscribeToService(service1, 6); //Subscription to the service for 6 months
        double monthlyCost1 = customer.calculateMonthlyServiceCost();
        // Monthly Service Cost for Customer
        logger.info("Monthly Service Cost for Customer 1: $" + monthlyCost1);
        logger.info(customer.toString());

        team.removeTeamMember(developer1);
        logger.info("\nUpdated Team Members:");
        for (Employee employee : team.getTeamMembers()) {
            logger.info(employee.toString());
        }
        logger.info("Evaluate Performance for Developer 1: " + developer1.evaluatePerformance(646));
        logger.info("Evaluate Performance for Developer 2: " + developer2.evaluatePerformance(300));
        logger.info("Evaluate Performance for Project Manager: " + projectManager.evaluatePerformance(11));
        logger.info("Evaluate Performance for Tester: " + tester.evaluatePerformance(57));


        TaskManagementServiceInterface taskManagementService = new TaskManagementServiceImpl();
        taskManagementService.createTask(project, "Task 1", "Implement feature X");
        taskManagementService.assignTask(team, "Task 1");
        taskManagementService.completeTask(team, "Task 1");
        // Log task management actions
        logger.info("Current projects: " + Project.getProjectCounter());

        // Log other relevant information
        logger.info("Application completed.");
    }
}