package com.solvd.laba.task2.interfaces;

import com.solvd.laba.task2.itcompany.*;

public interface TaskManagementServiceInterface {
    void createTask(Project project, String taskName, String description, TaskPriority taskPriority, EmployeeType type) throws Exception;
    void assignTask(Team team, String taskName, TaskPriority taskPriority) throws Exception;
    void completeTask(Team team, String taskName) throws Exception;
}