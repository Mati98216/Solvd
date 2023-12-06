package com.solvd.laba.task2.interfaces;

import com.solvd.laba.task2.itcompany.Employee;
import com.solvd.laba.task2.itcompany.Project;

import java.util.List;

public interface EmployeeActionsInterface {
    List<Employee> searchEmployees(String searchTerm);
}
