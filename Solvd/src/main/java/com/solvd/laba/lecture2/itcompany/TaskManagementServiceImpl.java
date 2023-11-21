package com.solvd.laba.lecture2.itcompany;

import com.solvd.laba.lecture2.exceptions.TaskManagementException;
import com.solvd.laba.lecture2.interfaces.TaskManagementServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.laba.lecture2.app.Main.logger;

public class TaskManagementServiceImpl implements TaskManagementServiceInterface {
    @Override
    public void createTask(Project project, String taskName, String description) throws TaskManagementException {
        if (project == null || taskName == null || taskName.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task creation parameters.");
        }

        logger.info("Task created for project {}: {} - {}", project.getProjectName(), taskName, description);
    }

    @Override
    public void assignTask(Team team, String taskName) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task assignment parameters.");
        }

        logger.info("Task assigned to team {}: {}", team.getTeamName(), taskName);
    }

    @Override
    public void completeTask(Team team, String taskName) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task completion parameters.");
        }

        logger.info("Task completed by team {}: {}", team.getTeamName(), taskName);
    }
}