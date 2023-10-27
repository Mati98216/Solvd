class Application {
    private String appName;
    private int developmentHours;

    public Application(String appName, int developmentHours) {
        this.appName = appName;
        this.developmentHours = developmentHours;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getDevelopmentHours() {
        return developmentHours;
    }

    public void setDevelopmentHours(int developmentHours) {
        this.developmentHours = developmentHours;
    }
}