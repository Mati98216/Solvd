package com.solvd.laba.lecture2.itcompany;

public enum ProjectSize {
    SMALL(100),
    MEDIUM(250),
    LARGE(500);

    private final int estimatedTime;


    ProjectSize(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }


}
