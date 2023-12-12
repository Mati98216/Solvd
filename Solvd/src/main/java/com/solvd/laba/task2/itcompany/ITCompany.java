package com.solvd.laba.task2.itcompany;

import java.util.*;
import java.util.function.Predicate;

import static com.solvd.laba.task2.app.Main.logger;

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
            logger.info("No team assigned to the project.");
            return;
        }

        Set<Employee> teamMembers = assignedTeam.getTeamMembers();

        logger.info("Team Members:");
        teamMembers.stream()
                .forEach(employee -> {
                    employee.calculateSalary(project, project.getSize());
                    logger.info(employee.toString());
                });
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
    public void searchEmployeesByAge(Predicate<Employee> agePredicate, int age) {
        employees.stream()
                .filter(agePredicate)
                .forEach(emp -> logger.info(emp.getEmployeeName() + " is older than " + age + " years."));
    }
    public void searchEmployeesByType(ITCompany company, String searchTerm, Class<? extends Employee> employeeType) {
        CustomLinkedList<Employee> employees = company.getEmployees();

        employees.stream()
                .filter(employeeType::isInstance)
                .map(employeeType::cast)
                .forEach(employee -> {
                    List<Employee> searchResults = employee.searchEmployees(searchTerm);
                    for (Employee result : searchResults) {
                        logger.info(result.toString());
                    }
                });
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