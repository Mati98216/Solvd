package com.solvd.laba.task2.itcompany;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ITCompany {
    private final String name;
    private final int yearFounded;
    private double revenue;
    private Map<String,Project> projects;
    private CustomLinkedList<Employee> employees;
    private Team assignedTeam;

    public ITCompany(String name, int yearFounded, double revenue) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.revenue = revenue;
        this.projects = new HashMap<>();
        this.employees = new CustomLinkedList<>();
    }

    public void addProject(Project project) {
        projects.put(project.getProjectName(),project);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void assignTeam(Team team) {
        this.assignedTeam = team;
    }

    public double calculateTotalEmployeeSalariesUsingLambda() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    public void calculateAndDisplayTeamSalaries(Project project) {
        Team assignedTeam = project.getAssignedTeam();

        if (assignedTeam == null) {
            System.out.println("No team assigned to the project.");
            return;
        }

        Set<Employee> teamMembers = assignedTeam.getTeamMembers();

        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            employee.calculateSalary(project,project.getSize());
            System.out.println(employee.toString());
        }
    }

    public CustomLinkedList<Employee> getEmployees() {
        return employees;
    }

    public double calculateTotalProjectCost(Team team) {
        double totalProjectCost = 0.0;

        for (Project project : projects.values()) {
            totalProjectCost += project.calculateProjectCost(team);
        }

        return totalProjectCost;
    }
    public String getName() {
        return name;
    }



    public int getYearFounded() {
        return yearFounded;
    }



    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}