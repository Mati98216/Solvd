package com.solvd.laba.lecture2.itcompany;

import java.util.Random;

public final class ProjectConstants {
    // Maximum project cost limit
    public static final double MAX_PROJECT_COST_LIMIT;

    // Minimum project cost limit
    public static final double MIN_PROJECT_COST_LIMIT = 1000.0;

    // Static block
    static {
        System.out.println("ProjectConstants static block executed.");

        // Initialize MAX_PROJECT_COST_LIMIT based on a condition
        if (someConditionIsMet()) {
            MAX_PROJECT_COST_LIMIT = 500000.0;
        } else {
            MAX_PROJECT_COST_LIMIT = 1000.0;
        }
    }

    // Static method to check if a project cost exceeds the limit
    public static boolean isProjectCostExceedLimit(double projectCost) {
        return projectCost > MAX_PROJECT_COST_LIMIT;
    }

    private static boolean someConditionIsMet() {
        // Simulating some condition for setting the MAX_PROJECT_COST_LIMIT
        Random random = new Random();
        return random.nextBoolean();
    }

}