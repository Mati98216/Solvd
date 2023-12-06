package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.TeamManagementException;
import com.solvd.laba.task2.interfaces.Task;
import com.solvd.laba.task2.interfaces.TeamOperationsInterface;

import java.util.*;
import java.util.stream.Collectors;

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
    public List<Task> getTasksByPriority() {
        List<Task> allTasks = getAllTasksInTeam();

        return allTasks.stream()
                .sorted(Comparator.comparingInt(task -> -task.getPriority().getPriority()))
                .collect(Collectors.toList());
    }
    public List<Task> getAllTasksInTeam() {
        List<Task> allTasks = new ArrayList<>();
        for (Employee employee : teamMembers) {
            allTasks.addAll(employee.getAssignedTasks());
        }
        return allTasks;
    }
}
