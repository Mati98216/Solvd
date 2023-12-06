package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.interfaces.Task;

public class CustomTask implements Task {
    private String taskName;
    private String description;
    private TaskPriority priority;
    private EmployeeType assignedEmployeeType;

    public CustomTask(String taskName, String description, TaskPriority priority, EmployeeType assignedEmployeeType) {
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.assignedEmployeeType = assignedEmployeeType;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setAssignedEmployeeType(EmployeeType assignedEmployeeType) {
        this.assignedEmployeeType = assignedEmployeeType;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TaskPriority getPriority() {
        return priority;
    }

    public EmployeeType getAssignedEmployeeType() {
        return assignedEmployeeType;
    }
}
