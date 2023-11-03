package com.solvd.laba.lecture2.itcompany;

import java.util.ArrayList;
import java.util.List;

public class Tester extends Employee {
    private List<Project> testedProjects;

    public Tester(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId, salary);
        testedProjects = new ArrayList<>();
    }

    public void testProject(Project project) {
        testedProjects.add(project);
    }

    public void untestProject(Project project) {
        testedProjects.remove(project);
    }

    public List<Project> getTestedProjects() {
        return testedProjects;
    }
}