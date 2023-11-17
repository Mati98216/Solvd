package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.exceptions.TaskManagementException;
import com.solvd.laba.lecture2.interfaces.TaskManagementServiceInterface;

public class TaskManagementServiceImpl implements TaskManagementServiceInterface {
    @Override
    public void createTask(Project project, String taskName, String description) throws TaskManagementException {
        if (project == null || taskName == null || taskName.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task creation parameters.");
        }

        System.out.println("Task created for project " + project.getProjectName() +
                ": " + taskName + " - " + description);
    }

    @Override
    public void assignTask(Team team, String taskName) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task assignment parameters.");
        }

        System.out.println("Task assigned to team " + team.getTeamName() +
                ": " + taskName);
    }

    @Override
    public void completeTask(Team team, String taskName) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task completion parameters.");
        }

        System.out.println("Task completed by team " + team.getTeamName() +
                ": " + taskName);
    }
}