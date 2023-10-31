package com.solvd.laba.itcompany;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {
    private List<Project> assignedProjects;

    public Developer(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId, salary);
        assignedProjects = new ArrayList<>();
    }

    public void assignToProject(Project project) {
        assignedProjects.add(project);
    }

    public void unassignFromProject(Project project) {
        assignedProjects.remove(project);
    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }
}