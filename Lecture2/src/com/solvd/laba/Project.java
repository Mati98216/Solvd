package com.solvd.laba;

public class Project {
    private String projectName;
    private String description;
    private double cost;

    public Project(String projectName, String description, double cost) {
        this.projectName = projectName;
        this.description = description;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}