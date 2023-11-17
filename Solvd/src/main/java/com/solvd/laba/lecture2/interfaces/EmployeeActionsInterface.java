package com.solvd.laba.lecture2.interfaces;

import com.solvd.laba.lecture2.itcompany.Employee;
import com.solvd.laba.lecture2.itcompany.Project;

import java.util.List;

public interface EmployeeActionsInterface {
    List<Employee> searchEmployees(String searchTerm);
}
