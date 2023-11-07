package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.itcompany.Employee;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Employee> teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new ArrayList<>();
    }

    public void addTeamMember(Employee employee) {
        teamMembers.add(employee);
    }

    public void removeTeamMember(Employee employee) {
        teamMembers.remove(employee);
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}