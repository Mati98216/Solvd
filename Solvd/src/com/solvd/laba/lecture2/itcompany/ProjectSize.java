package com.solvd.laba.lecture2.itcompany;

public enum ProjectSize {
    SMALL(100, 10),    // Estimated time in hours, hourly rate
    MEDIUM(250, 8),
    LARGE(500, 6);

    private int estimatedTime;
    private double hourlyRate;

    ProjectSize(int estimatedTime, double hourlyRate) {
        this.estimatedTime = estimatedTime;
        this.hourlyRate = hourlyRate;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
