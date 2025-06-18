package com.system.bureaucracy.service;

import com.system.bureaucracy.citizen.Citizen;

import java.util.List;

public interface GovernmentService {
    void processRequest(Citizen requester);

    String getServiceName();

    boolean isEligible(Citizen requester);

    double calculateFee();

    int getProcessingDays();

    List<String> getRequiredDocuments();

    default void sendNotification(Citizen requester) {
        System.out.println("Sending SMS notification to " + requester.getPhone());
    }
}