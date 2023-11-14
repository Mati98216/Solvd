package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;

public final class ITCompany {
    private final String name;
    private final int yearFounded;
    private  double revenue;
    private List<Project> projects;
    private List<Employee> employees;
    private Team assignedTeam;


    public ITCompany(String name, int yearFounded, double revenue) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.revenue = revenue;
        this.projects = new ArrayList<>();
        this.employees = new ArrayList<>();
    }
    public void addProject(Project project) {
        projects.add(project);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void assignTeam(Team team) {
        this.assignedTeam = team;
    }

    public double calculateTotalEmployeeSalaries() {
        double totalSalaries = 0.0;
        for (Employee employee : employees) {
            totalSalaries += employee.getSalary();
        }
        return totalSalaries;
    }
    public void calculateAndDisplayTeamSalaries(Project project) {
        Team assignedTeam = project.getAssignedTeam();

        if (assignedTeam == null) {
            System.out.println("No team assigned to the project.");
            return;
        }

        List<Employee> teamMembers = assignedTeam.getTeamMembers();

        System.out.println("Team Members:");
        for (Employee employee : teamMembers) {
            if (employee instanceof Developer) {
                ((Developer) employee).updateSalaryForProject(project, project.getSize());
            } else if (employee instanceof ProjectManager) {
                ((ProjectManager) employee).updateSalaryForProject(project, project.getSize());
            } else if (employee instanceof Tester) {
                ((Tester) employee).updateSalaryForProject(project, project.getSize());
            }
            System.out.println(employee.toString());
        }
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculateTotalProjectCost(Team team) {
        double totalProjectCost = 0.0;

        for (Project project : projects) {
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