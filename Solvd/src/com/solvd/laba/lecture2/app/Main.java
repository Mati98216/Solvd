package com.solvd.laba.lecture2.app;


import com.solvd.laba.lecture2.itcompany.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating an IT company
        ITCompany company = new ITCompany("My IT Company", 2000, 1000000.0);

        // Creating a client
        Customer customer = new Customer("Customer Name", "customer@email.com", "123-456-789");

        // Creating a project
        Project project = new Project("Project Name", "Project Description", ProjectSize.MEDIUM, customer);

        // Team building
        Team team = new Team("Development Team");

        // Adding employees to the team
        Developer developer1 = new Developer("Dev 1", 1, 3, 25.0, 40);
        Developer developer2 = new Developer("Dev 2", 2, 5, 28.0, 40);
        ProjectManager projectManager = new ProjectManager("Project Manager", 3, 8, 35.0, 40);
        Tester tester = new Tester("Tester", 4,2, 20.0, 40);

        team.addTeamMember(developer1);
        team.addTeamMember(developer2);
        team.addTeamMember(projectManager);
        team.addTeamMember(tester);

        // Assign a team to the project
        project.assignTeam(team);

        // Set project deadlines
        project.setDueDate(LocalDate.of(2023, 12, 31));
        project.setCompletionDate(LocalDate.of(2023, 12, 15));

        // Calculate employee salaries and display information about employees on the team
        List<Employee> teamMembers = team.getTeamMembers();
        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            if (employee instanceof Developer) {
                ((Developer) employee).updateSalaryForProject(project, project.getSize());
            } else if (employee instanceof ProjectManager) {
                ((ProjectManager) employee).updateSalaryForProject(project, project.getSize());
            } else if (employee instanceof Tester) {
                ((Tester) employee).updateSalaryForProject(project, project.getSize());
            }
            System.out.println(employee.toString() + ", Salary: " + employee.getSalary());
        }
        // Calculate the cost of the project
        double projectCost = project.calculateProjectCost(team);
        System.out.println("Project Cost: " + projectCost);

        // Display project information
        System.out.println("Project Name: " + project.getProjectName());
        System.out.println("Project Description: " + project.getDescription());
        System.out.println("Project Size: " + project.getSize());
        System.out.println("Customer: " + project.getCustomer().getCustomerName());
        System.out.println("Due Date: " + project.getDueDate());
        System.out.println("Completion Date: " + project.getCompletionDate());


    }
}