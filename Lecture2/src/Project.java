class Project {
    private String projectName;
    private Customer customer;
    private Application application;
    private Database database;

    public Project(String projectName, Customer customer, Application application, Database database) {
        this.projectName = projectName;
        this.customer = customer;
        this.application = application;
        this.database = database;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}