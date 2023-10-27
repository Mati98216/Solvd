package com.solvd.laba;

class WebApp extends Application {
    private String framework;

    public WebApp(String appName, int developmentHours, String framework) {
        super(appName, developmentHours);
        this.framework = framework;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}