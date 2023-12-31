package com.solvd.laba.task2.itcompany;

import com.solvd.laba.task2.exceptions.ProjectAssignmentException;
import com.solvd.laba.task2.interfaces.ProjectOperationsInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static com.solvd.laba.task2.app.Main.logger;

public class Project  implements ProjectOperationsInterface {
    private String projectName;
    private String description;
    private  ProjectCategory projectCategory;
    private ProjectSize size;
    private double estimatedCost;
    private Customer customer;
    private LocalDate dueDate;
    private LocalDate completionDate;
    private List<Developer> developers;
    private List<ProjectManager> projectManagers;
    private List<Tester> testers;
    private Team assignedTeam;
    private static int projectCounter;

    static {
        projectCounter = 0;
    }



    public Project(String projectName, String description, ProjectSize size, ProjectCategory category, Customer customer, LocalDate dueDate, LocalDate completionDate) {
        this.projectName = projectName;
        this.description = description;
        this.size = size;
        this.projectCategory=category;
        this.customer = customer;
        this.dueDate = dueDate;
        this.completionDate = completionDate;
        this.assignedTeam = null;

        developers = new ArrayList<>();
        projectManagers = new ArrayList<>();
        testers = new ArrayList<>();

        if (!customer.hasPreviousProjects()) {
            applyDiscount();
        }
        projectCounter++;
    }
    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    public void assignedTeam(Team team) {
        this.assignedTeam = team;
    }
    @Override
    public Team getAssignedTeam() {
        return assignedTeam;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectSize getSize() {
        return size;
    }

    public void setSize(ProjectSize size) {
        this.size = size;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public List<ProjectManager> getProjectManagers() {
        return projectManagers;
    }

    public List<Tester> getTesters() {
        return testers;
    }



    private void applyDiscount() {
        estimatedCost -= 1000;
    }

    public final  double calculateMonthlyServiceCost() {
        if (customer.getService() != null) {
            double pricePerMonth = customer.getService().getPricePerMonth();
            int serviceDurationInMonths = customer.getServiceDurationInMonths();
            return pricePerMonth * serviceDurationInMonths;
        }
        return 0.0;
    }
    public void performActionOnDescription(Consumer<String> descriptionAction) {
        descriptionAction.accept(description);
    }
    @Override
    public double calculateProjectCost(Team team) {
        double teamSalaries = team.getTeamMembers().stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double minCost = teamSalaries * 1.5;
        double discount = customer.hasPreviousProjects() ? 0 : 1000;
        double monthlyServiceCost = calculateMonthlyServiceCost();
        double projectCategoryCost = projectCategory != null ? projectCategory.getCost() : 0;

        return minCost + discount + monthlyServiceCost + projectCategoryCost;
    }

    public void assignToTeam(Team team) {

            if (team == null || team.getTeamMembers().isEmpty()) {
                throw new ProjectAssignmentException("Cannot assign an empty or null team to the project.");
            }

            for (Employee employee : team.getTeamMembers()) {
                if (employee instanceof Developer) {
                    developers.add((Developer) employee);
                } else if (employee instanceof ProjectManager) {
                    projectManagers.add((ProjectManager) employee);
                } else if (employee instanceof Tester) {
                    testers.add((Tester) employee);
                }
            }
    }
    public void incrementProjectSize(UnaryOperator<ProjectSize> sizeIncrementer) {
        ProjectSize currentSize = this.getSize();
        ProjectSize updatedSize = sizeIncrementer.apply(currentSize);
        this.setSize(updatedSize);
        logger.info(this.toString());
    }

    public static int getProjectCounter() {
        return projectCounter;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project Name: ").append(projectName).append("\n");
        builder.append("Project Description: ").append(description).append("\n");
        builder.append("Project Size: ").append(size).append("\n");
        builder.append("Customer: ").append(customer.getCustomerName()).append("\n");
        builder.append("Due Date: ").append(dueDate).append("\n");
        builder.append("Completion Date: ").append(completionDate).append("\n");

        return builder.toString();
    }
}
