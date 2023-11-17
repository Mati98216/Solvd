package com.solvd.laba.lecture2.interfaces;

import com.solvd.laba.lecture2.itcompany.Team;

public interface ProjectOperationsInterface {
 /*   boolean isCompleted();
    boolean isOverdue();*/
    double calculateProjectCost(Team team);
    void assignToTeam(Team team);
    Team getAssignedTeam();
}
