public class Main {
    public static void main(String[] args) {

        ITCompany company = new ITCompany("XYZ Technologies", 75.0);
        Customer customer = new Customer("John Doe");
        MobileApp mobileApp = new MobileApp("MobileApp1", 400, "iOS");
        WebApp webApp = new WebApp("WebApp1", 300, "React");
        Database database = new Database("MyDatabase");
        Project project = new Project("ProjectA", customer, mobileApp, database);

        System.out.println("Project Name: " + project.getProjectName());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Application Name: " + mobileApp.getAppName());
        System.out.println("Database Name: " + database.getDbName());
        System.out.println("Estimated Cost: $" + company.estimateCost(mobileApp.getDevelopmentHours()));
    }
}