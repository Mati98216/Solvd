package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.TaskManagementException;
import com.solvd.laba.task2.interfaces.Task;
import com.solvd.laba.task2.interfaces.TaskManagementServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.task2.app.Main.logger;

public class TaskManagementServiceImpl implements TaskManagementServiceInterface {
    @Override
    public void createTask(Project project, String taskName, String description, TaskPriority priority, EmployeeType employeeType) throws TaskManagementException {
        if (project == null || taskName == null || taskName.trim().isEmpty() || description == null || description.trim().isEmpty() || priority == null || employeeType == null) {
            throw new TaskManagementException("Invalid task creation parameters.");
        }

        logger.info("Task created for project {}: {} - {} (Priority: {}) for employee type: {}", project.getProjectName(), taskName, description, priority.getDescription(), employeeType.getDescription());
    }

    @Override
    public void assignTask(Team team, String taskName, TaskPriority taskPriority) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty() || taskPriority == null) {
            throw new TaskManagementException("Invalid task assignment parameters.");
        }

        team.getTeamMembers().stream()
                .filter(employee -> employee.getAssignedTasks().size() < 5)
                .map(employee -> {
                    EmployeeType employeeType = getEmployeeTypeBasedOnRole(employee);
                    if (employeeType != null) {
                        try {
                            employee.createTask(taskName, "Task Description", taskPriority, employeeType);
                            logger.info("Task assigned to {} {}: {}", employeeType.getDescription(), employee.getEmployeeName(), taskName);
                        } catch (TaskManagementException e) {
                            logger.error("Failed to assign task to {} {}: {}", employeeType.getDescription(), employee.getEmployeeName(), e.getMessage());
                        }
                    }
                    return employee;
                })
                .findFirst(); // you may perform further operations or actions here
    }

    @Override
    public void completeTask(Team team, String taskName) throws TaskManagementException {
        if (team == null || team.getTeamMembers().isEmpty() || taskName == null || taskName.trim().isEmpty()) {
            throw new TaskManagementException("Invalid task completion parameters.");
        }

        logger.info("Task completed by team {}: {}", team.getTeamName(), taskName);
    }

    private EmployeeType getEmployeeTypeBasedOnRole(Employee employee) {
        if (employee instanceof Developer) {
            return EmployeeType.DEVELOPER;
        } else if (employee instanceof Tester) {
            return EmployeeType.TESTER;
        } else if (employee instanceof ProjectManager) {
            return EmployeeType.PROJECT_MANAGER;
        }
        return null;
    }

}