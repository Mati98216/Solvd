package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.TeamManagementException;
import com.solvd.laba.task2.interfaces.Task;
import com.solvd.laba.task2.interfaces.TeamOperationsInterface;
import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.function.Predicate;
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
    public Optional<SimpleEntry<Employee, Task>> findTeamMemberWithMatchingTask(Predicate<Task> taskPredicate) {
        return teamMembers.stream()
                .flatMap(employee -> employee.getAssignedTasks().stream()
                        .filter(taskPredicate)
                        .map(task -> new SimpleEntry<>(employee, task)))
                .findAny();
    }
    public List<Task> getAllTasksInTeam() {
        return teamMembers.stream()
                .flatMap(employee -> employee.getAssignedTasks().stream())
                .collect(Collectors.toList());
    }
}
