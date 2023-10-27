public class ITCompany {
    private String companyName;
    private double hourlyRate;

    public ITCompany(String companyName, double hourlyRate) {
        this.companyName = companyName;
        this.hourlyRate = hourlyRate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double estimateCost(int hours) {
        return hourlyRate * hours;
    }
}
