package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.interfaces.TaskManagementServiceInterface;

public class TaskManagementServiceImpl implements TaskManagementServiceInterface {
    @Override
    public void createTask(Project project, String taskName, String description) {
        System.out.println("Task created for project " + project.getProjectName() +
                ": " + taskName + " - " + description);
    }

    @Override
    public void assignTask(Team team, String taskName) {
        System.out.println("Task assigned to team " + team.getTeamName() +
                ": " + taskName);
    }

    @Override
    public void completeTask(Team team, String taskName) {
        System.out.println("Task completed by team " + team.getTeamName() +
                ": " + taskName);
    }
}