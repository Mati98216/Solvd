package com.solvd.laba;

class MobileApp extends Application {
    private String platform;

    public MobileApp(String appName, int developmentHours, String platform) {
        super(appName, developmentHours);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}