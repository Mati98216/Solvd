package com.solvd.laba.task2.itcompany;

public enum EmployeeType {
    DEVELOPER("Developer"),
    PROJECT_MANAGER("Project Manager"),
    TESTER("Tester");

    private final String description;

    EmployeeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printDescription() {
        System.out.println("Employee type: " + description);
    }
}

