package com.solvd.laba.lecture2.itcompany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private String description;
    private ProjectSize size;
    private int requirements;
    private double estimatedCost;
    private Customer customer;
    private LocalDate dueDate;
    private LocalDate completionDate;
    private List<Developer> developers;
    private List<ProjectManager> projectManagers;
    private List<Tester> testers;




    public Project(String projectName, String description, ProjectSize size, int requirements, Customer customer) {
        this.projectName = projectName;
        this.description = description;
        this.size = size;
        this.requirements = requirements;
        this.customer = customer;
        this.dueDate = null;
        this.completionDate = null;

        developers = new ArrayList<>();
        projectManagers = new ArrayList<>();
        testers = new ArrayList<>();

        calculateEstimatedCost();
        allocateResources();

        if (!customer.hasPreviousProjects()) {
            applyDiscount();
        }
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectSize getSize() {
        return size;
    }

    public void setSize(ProjectSize size) {
        this.size = size;
    }

    public int getRequirements() {
        return requirements;
    }

    public void setRequirements(int requirements) {
        this.requirements = requirements;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void calculateEstimatedCost() {
        estimatedCost = size.getEstimatedTime() * size.getHourlyRate() * requirements;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public List<ProjectManager> getProjectManagers() {
        return projectManagers;
    }

    public List<Tester> getTesters() {
        return testers;
    }


    private void applyDiscount() {
        estimatedCost -= 1000;
    }
    public boolean isCompleted() {
        return completionDate != null;
    }

    public boolean isOverdue() {
        return dueDate != null && completionDate != null && dueDate.isBefore(completionDate);
    }
}
