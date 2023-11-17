package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.exceptions.TeamManagementException;
import com.solvd.laba.lecture2.interfaces.TeamOperationsInterface;

import java.util.ArrayList;
import java.util.List;

public class Team implements TeamOperationsInterface {
    private String teamName;
    private List<Employee> teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new ArrayList<>();
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
