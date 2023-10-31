package com.solvd.laba.itcompany;

public class ITCompany {
    private String name;
    private int yearFounded;
    private double revenue;

    public ITCompany(String name, int yearFounded, double revenue) {
        this.name = name;
        this.yearFounded = yearFounded;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}