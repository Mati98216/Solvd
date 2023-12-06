package com.solvd.laba.task2.interfaces;

import com.solvd.laba.task2.exceptions.ServiceSubscriptionException;
import com.solvd.laba.task2.itcompany.Service;

public interface CustomerServicesInterface {
    void subscribeToService(Service service, int durationInMonths) throws ServiceSubscriptionException;
    double calculateMonthlyServiceCost();
}
