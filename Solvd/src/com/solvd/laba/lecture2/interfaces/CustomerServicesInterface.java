package com.solvd.laba.lecture2.interfaces;

import com.solvd.laba.lecture2.itcompany.Service;

public interface CustomerServicesInterface {
    void subscribeToService(Service service, int durationInMonths);
    double calculateMonthlyServiceCost();
}
