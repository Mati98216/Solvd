package com.solvd.laba.lecture2.interfaces;

import com.solvd.laba.lecture2.itcompany.*;

public interface TaskManagementServiceInterface {
    void createTask(Project project, String taskName, String description);
    void assignTask(Team team, String taskName);
    void completeTask(Team team, String taskName);
}
