package com.solvd.laba.task2.app;


import com.solvd.laba.task2.interfaces.Task;
import com.solvd.laba.task2.interfaces.TaskManagementServiceInterface;
import com.solvd.laba.task2.itcompany.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        logger.info("Application started.");
        ITCompany company = new ITCompany("My IT Company", 2000, 1000000.0);

        Customer customer = new Customer();
        String csvFilePath = "src/main/resources/customer_data";
        CustomerDataLoader.loadCustomerDataFromCSV(csvFilePath, customer);
        // Create and add projects to the company
        Project project = new Project("Project Name", "Project Description", ProjectSize.MEDIUM,ProjectCategory.MOBILE_APP, customer, LocalDate.now(),LocalDate.of(2023,12,31));
        company.addProject(project);
        project.performActionOnDescription(description -> {
            String modifiedDescription = "New Project Description";
            project.setDescription(modifiedDescription);
            logger.info("Modified Description: " + modifiedDescription);
        });
        // Create and add employees to the company
        Developer developer1 = new Developer("Dev 1", 1, 7, 25.0, 40,30);
        Developer developer2 = new Developer("Dev 2", 2, 5, 28.0, 40,36);
        Developer developer3 = new Developer("Dev 3", 3, 5, 28.0, 40,37);
        ProjectManager projectManager = new ProjectManager("Project Manager", 3, 8, 35.0, 40,46);
        Tester tester = new Tester("Tester", 4,2, 20.0, 40,22);

        company.addEmployee(developer1);
        company.addEmployee(developer2);
        company.addEmployee(developer3);
        company.addEmployee(projectManager);
        company.addEmployee(tester);
        //Update Employee Name
        developer1.updateEmployeeName(name -> "New Name");
        BiConsumer<String, Integer> dataUpdater = (name, id) -> {
            developer1.setEmployeeName(name);
            developer1.setEmployeeId(id);
        };
        //Custom Lambda
        developer1.executeSalaryChecker(
                (emp, threshold) -> emp.getSalary() > threshold

        );
        developer1.executeupdateHours(
                (emp, newHours) -> {
                    emp.setWeeklyHours(newHours);
                },
                45
        );
        developer1.executeAgeCheck(
                (emp, age) -> emp.getAge() >= age,
                26
        );
        // Create a team and add employees to it
        Team team = new Team("Development Team");
        team.addTeamMember(developer1);
        team.addTeamMember(developer2);
        team.addTeamMember(tester);
        team.addTeamMember(projectManager);
        // Assign the team to the project
        project.assignToTeam(team);
        project.assignedTeam(team);
        // Calculate employee salaries and display information for the assigned team
        company.calculateAndDisplayTeamSalaries(project);
        // Calculate the project cost
        double projectCost = company.calculateTotalProjectCost(team);
        logger.info("Project Cost: " + projectCost);

        // Display project information
        logger.info("Project Information:");
        logger.info(project.toString());

        // Search for employees based on a search term (e.g., "Dev")
        String searchTerm = "Dev";
        List<Employee> searchResults = new ArrayList<>();

        for (Employee employee : company.getEmployees()) {
            searchResults.addAll(employee.searchEmployees(searchTerm));
        }
        // Display search results
        logger.info("Search Results for '" + searchTerm + "':");
        for (Employee result : searchResults) {
            logger.info(result.toString());
        }
        // Dev
        company.searchEmployeesByType(company, "Dev", Developer.class);

        // Tester
        company.searchEmployeesByType(company, "Tester", Tester.class);

        // ProjectManager
        company.searchEmployeesByType(company, "Project Manager", ProjectManager.class);
        // Search by Age
        Predicate<Employee> isOlderThan35 = emp -> emp.getAge() > 35;
        company.searchEmployeesByAge(isOlderThan35,35);
        // Updating project Size
        project.incrementProjectSize(size -> ProjectSize.LARGE);
        Service service1 = new Service("Service 1", 50.0, "Description 1");
        Service service2 = new Service("Service 2", 75.0, "Description 2");

        customer.subscribeToService(service1, 6); //Subscription to the service for 6 months
        double monthlyCost1 = customer.calculateMonthlyServiceCost();
        customer.checkPaymentStatusAndNextDue(true);
        // Monthly Service Cost for Customer
        logger.info("Monthly Service Cost for Customer 1: $" + monthlyCost1);
        logger.info(customer.toString());

        team.removeTeamMember(developer1);
        logger.info("\nUpdated Team Members:");
        for (Employee employee : team.getTeamMembers()) {
            logger.info(employee.toString());
        }
        logger.info("Evaluate Performance for Developer 1: " + developer1.evaluatePerformance(646));
        logger.info("Evaluate Performance for Developer 2: " + developer2.evaluatePerformance(300));
        logger.info("Evaluate Performance for Project Manager: " + projectManager.evaluatePerformance(11));
        logger.info("Evaluate Performance for Tester: " + tester.evaluatePerformance(57));

        BiPredicate<Integer, Integer> experiencePredicate = (currentYears, targetYears) -> currentYears > targetYears;
        boolean hasMoreExperience = developer1.hasMoreExperience(experiencePredicate, developer1.getYearsOfWork(), 5);
        logger.info("Has more than 5 years of experience? " + hasMoreExperience);
        developer1.displayEmployeeInfo(employee -> logger.info("Employee info: " + employee.toString()));

        TaskManagementServiceInterface taskManagementService = new TaskManagementServiceImpl();
        taskManagementService.createTask(project, "Task 1", "Implement feature X",TaskPriority.HIGH,EmployeeType.DEVELOPER);
        taskManagementService.createTask(project, "Task 2", "Implement feature Y",TaskPriority.LOW,EmployeeType.DEVELOPER);
        taskManagementService.createTask(project, "Task 3", "Implement feature Z",TaskPriority.MEDIUM,EmployeeType.DEVELOPER);
        taskManagementService.assignTask(team, "Task 1",TaskPriority.LOW);
        taskManagementService.assignTask(team, "Task 2",TaskPriority.HIGH);
        taskManagementService.assignTask(team, "Task 3",TaskPriority.MEDIUM);
        taskManagementService.completeTask(team, "Task 1");
        // Log task management actions
        logger.info("Current projects: " + Project.getProjectCounter());
        List<Task> tasksByPriority = team.getTasksByPriority();
        logger.info("Task are sorted by priority:");
        for (Task task : tasksByPriority) {
            logger.info(task.getTaskName() + " - " + task.getPriority().getDescription());
        }
        Predicate<Task> highPriorityPredicate = task -> task.getPriority() == TaskPriority.HIGH;

        // Call the method to find any team member with a task that matches the condition
        Optional<AbstractMap.SimpleEntry<Employee, Task>> matchingTaskInfo = team.findTeamMemberWithMatchingTask(highPriorityPredicate);

        // Check if there is a match and access the task and employee information
        matchingTaskInfo.ifPresent(entry -> {
            Employee employee = entry.getKey();
            Task task = entry.getValue();

            logger.info("Found a matching task with HIGH priority:");
            logger.info("Employee: " + employee.getEmployeeName());
            logger.info("Task: " + task.getDescription());
        });
        //Total employee salaries
        double totalSalaries = company.calculateTotalEmployeeSalariesUsingLambda();
        logger.info("Total employee salaries: " + totalSalaries);
        // Log other relevant information
        logger.info("Application completed.");

    }
}