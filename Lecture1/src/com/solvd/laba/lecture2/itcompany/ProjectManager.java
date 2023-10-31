package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Employee {
    private List<Project> managedProjects;

    public ProjectManager(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId, salary);
        managedProjects = new ArrayList<>();
    }

    public void assignProject(Project project) {
        managedProjects.add(project);
    }

    public void unassignProject(Project project) {
        managedProjects.remove(project);
    }

    public List<Project> getManagedProjects() {
        return managedProjects;
    }
}