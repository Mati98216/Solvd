package com.solvd.laba;

public class Main {
    public static void main(String[] args) {
        ITCompany company = new ITCompany("TechSolutions Inc.", 2000, 5000000);
        Service service = new Service("Website Development", 5000, "Custom website development");
        Customer customer = new Customer("John Doe", "johndoe@example.com", "+1-555-123-4567");
        Project project = new Project("E-commerce Website", "Online store development", 10000);
        Employee employee = new Employee("Alice", 101, 60000);
        Team team = new Team("Development Team");
        team.addTeamMember(employee);

        ProjectManager projectManager = new ProjectManager("Bob", 102, 80000);
        projectManager.assignProject(project);

        Developer developer = new Developer("Charlie", 103, 70000);
        developer.assignToProject(project);

        Tester tester = new Tester("David", 104, 65000);
        tester.testProject(project);


        System.out.println("Company Name: " + company.getName());
        System.out.println("Service Name: " + service.getServiceName());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Project Name: " + project.getProjectName());


    }
}
