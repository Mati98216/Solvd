package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.exceptions.TeamManagementException;
import com.solvd.laba.lecture2.interfaces.TeamOperationsInterface;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Team implements TeamOperationsInterface {
    private String teamName;
    private Set<Employee> teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new LinkedHashSet<>();
    }
    @Override
    public void addTeamMember(Employee employee) {
        teamMembers.add(employee);
    }
    @Override
    public void removeTeamMember(Employee employee) {
        if (employee == null || !teamMembers.contains(employee)) {
            throw new TeamManagementException("Invalid team member removal parameters.");
        }

        teamMembers.remove(employee);
    }

    public Set<Employee> getTeamMembers() {
        return teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
