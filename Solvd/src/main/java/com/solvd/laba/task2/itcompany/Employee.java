package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.EmployeeDataException;
import com.solvd.laba.task2.exceptions.SalaryUpdateException;
import com.solvd.laba.task2.exceptions.TaskManagementException;
import com.solvd.laba.task2.interfaces.EmployeeActionsInterface;
import com.solvd.laba.task2.interfaces.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.solvd.laba.task2.app.Main.logger;


public abstract class Employee implements EmployeeActionsInterface {
    protected String employeeName;
    protected int employeeId;
    protected int age;
    protected double salary;
    protected List<Project> assignedProjects;
    protected int yearsOfWork;
    protected double hourlyRate;
    protected int weeklyHours;
    private List<Task> assignedTasks;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Employee(String employeeName, int employeeId, int yearsOfWork, double hourlyRate, int weeklyHours, int age) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.assignedProjects = new ArrayList<>();
        this.yearsOfWork = yearsOfWork;
        this.hourlyRate = hourlyRate;
        this.weeklyHours = weeklyHours;
        this.age=age;
        assignedTasks = new ArrayList<>();
        calculateSalary(null, null);
    }
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }
    public void updateEmployeeName(Function<String, String> nameUpdater) {
        try {
            String updatedName = nameUpdater.apply(getEmployeeName());
            if (updatedName == null || updatedName.trim().isEmpty()) {
            }
            setEmployeeName(updatedName);
        } catch (EmployeeDataException e) {

           logger.error("Error while updating employee name: " + e.getMessage());

        }
    }
    public void displayEmployeeInfo(Consumer<Employee> infoConsumer) {
        infoConsumer.accept(this);
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }
    public interface AgeChecker<T extends Employee> {
        boolean checkAge(T employee, int age);
    } public void executeAgeCheck(AgeChecker<Employee> ageChecker,int age) {
        boolean isOlderThanGivenAge = ageChecker.checkAge(this, age);
        logger.info("Is employee older than " + age + " years? " + isOlderThanGivenAge);
    }
    public int getYearsOfWork() {
        return yearsOfWork;
    }
    public interface SalaryChecker<T extends Employee> {
        boolean checkSalary(T employee, double threshold);
    }
    public interface HoursUpdater<T extends Employee> {
        void updateHoursWorked(T employee, int newHours);
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public void executeSalaryChecker(SalaryChecker<Employee> salaryChecker) {
        boolean isSalaryHigh = salaryChecker.checkSalary(this, 50000.0);
        logger.info("Is salary higher than $50000? " + isSalaryHigh);

    }
    public void executeupdateHours(HoursUpdater<Employee> hoursUpdater,int newHoursWorked) {
        hoursUpdater.updateHoursWorked(this, newHoursWorked);
        logger.info("Updated weekly hours to: " + newHoursWorked);

    }
    public boolean hasMoreExperience(BiPredicate<Integer, Integer> experiencePredicate, int currentYears, int targetYears) {
        return experiencePredicate.test(currentYears, targetYears);
    }
    public void createTask(String taskName, String description, TaskPriority priority, EmployeeType employeeType) throws TaskManagementException {
        if (employeeType == null) {
            throw new TaskManagementException("Invalid employee type.");
        }


        Task newTask = new CustomTask(taskName, description, priority, employeeType);


        if (getAssignedTasks().size() >= 5) {
            throw new TaskManagementException("Employee has reached the limit of assigned tasks.");
        }

        assignTask(newTask);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }


    protected abstract double evaluatePerformance(int value);


    protected double calculateBaseSalary() {
        return hourlyRate * weeklyHours; // We use weeklyHours to calculate wages
    }

    protected double calculateBonusForYearsOfWork() {
        double maxBonus = 20000.0;
        double bonusPerYear = 100.0;
        double yearsBonus = yearsOfWork * bonusPerYear;
        return Math.min(yearsBonus, maxBonus);
    }

    protected double calculateProjectCompletionBonus(ProjectSize projectSize) {
        double bonus = 0.0;
        switch (projectSize) {
            case SMALL:
                bonus = 1000.0;
                break;
            case MEDIUM:
                bonus = 1500.0;
                break;
            case LARGE:
                bonus = 2000.0;
                break;
            default:
                break;
        }
        return bonus;
    }

    protected void calculateSalary(Project lastCompletedProject, ProjectSize projectSize) throws SalaryUpdateException {
        try {
            double newSalary = calculateBaseSalary() + calculateBonusForYearsOfWork();
            if (lastCompletedProject != null && lastCompletedProject.getDueDate() != null && lastCompletedProject.getCompletionDate() != null) {
                newSalary += calculateProjectCompletionBonus(projectSize);
            }
            setSalary(newSalary);
        } catch (Exception e) {
            throw new SalaryUpdateException("Error updating salary: " + e.getMessage());
        }
    }
    @Override
    public List<Employee> searchEmployees(String searchTerm) {
        List<Employee> searchResults = new ArrayList<>();


        Pattern pattern = Pattern.compile(".*" + Pattern.quote(searchTerm) + ".*", Pattern.CASE_INSENSITIVE);


        Matcher matcher = pattern.matcher(employeeName);


        if (matcher.matches()) {
            searchResults.add(this);
        }

        return searchResults;
    }

    @Override
    public String toString() {
        return "Employee: " + employeeName + ", Salary: " + salary;
    }

}

