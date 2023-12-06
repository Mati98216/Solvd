package com.solvd.laba.task2.interfaces;

import com.solvd.laba.task2.itcompany.Team;

public interface ProjectOperationsInterface {
    double calculateProjectCost(Team team);
    void assignToTeam(Team team);
    Team getAssignedTeam();
}
