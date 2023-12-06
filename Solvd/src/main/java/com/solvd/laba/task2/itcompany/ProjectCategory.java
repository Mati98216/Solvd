package com.solvd.laba.task2.itcompany;

public enum ProjectCategory {
    WEB_APPLICATION(1500),
    MOBILE_APP(1000);

    private final int cost;;

    ProjectCategory(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }


}