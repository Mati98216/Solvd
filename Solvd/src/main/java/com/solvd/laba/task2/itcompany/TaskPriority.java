package com.solvd.laba.task2.itcompany;

public enum TaskPriority {
    HIGH(3, "High"),
    MEDIUM(2, "Medium"),
    LOW(1, "Low");

    private final int priority;
    private final String description;

    TaskPriority(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }


}
