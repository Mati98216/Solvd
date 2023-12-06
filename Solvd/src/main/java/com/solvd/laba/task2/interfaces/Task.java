package com.solvd.laba.task2.interfaces;

import com.solvd.laba.task2.itcompany.TaskPriority;

public interface Task {
    String getTaskName();
    String getDescription();
    TaskPriority getPriority();
}
