package com.solvd.laba.lecture2.interfaces;

import com.solvd.laba.lecture2.itcompany.*;

public interface TaskManagementServiceInterface {
    void createTask(Project project, String taskName, String description) throws Exception;
    void assignTask(Team team, String taskName) throws Exception;
    void completeTask(Team team, String taskName) throws Exception;
}