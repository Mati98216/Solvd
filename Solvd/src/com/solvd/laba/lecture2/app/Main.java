package com.solvd.laba.lecture2.app;


import com.solvd.laba.lecture2.itcompany.*;

import java.time.LocalDate;
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
    }
}