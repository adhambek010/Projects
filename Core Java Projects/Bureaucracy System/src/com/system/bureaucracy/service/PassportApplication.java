package com.system.bureaucracy.service;


import com.system.bureaucracy.citizen.Citizen;

import java.util.Arrays;
import java.util.List;

public class PassportApplication implements GovernmentService{

    private boolean expedited;

    public PassportApplication(boolean expedited) {
        this.expedited = expedited;
    }

    @Override
    public void processRequest(Citizen requester) {
        System.out.println("Processing passport application for " + requester.getName());
        verifyIdentity(requester);
        collectBiometrics(requester);
        System.out.println("Passport photo taken");
    }

    @Override
    public String getServiceName() {
        return "Passport Application" + (expedited ? " (Expedited)" : "");
    }

    @Override
    public boolean isEligible(Citizen requester) {
        return requester.getAge() >= 16 &&
                !requester.hasPassportRestrictions();
    }

    @Override
    public double calculateFee() {
        return expedited ? 200.00 : 100.00;
    }

    @Override
    public int getProcessingDays() {
        return expedited ? 7 : 21;
    }

    @Override
    public List<String> getRequiredDocuments() {
        return Arrays.asList(
                "Birth Certificate",
                "National ID",
                "Passport Photo",
                "Proof of Address"
        );
    }

    @Override
    public void sendNotification(Citizen requester) {
        System.out.println("Sending notification with tracking number to " + requester.getPhone());
    }

    private void verifyIdentity(Citizen c) {
        System.out.println("Verifying identity documents for " + c.getName());
    }

    private void collectBiometrics(Citizen c) {
        System.out.println("Collecting fingerprints and digital signature");
    }

    @Override
    public String toString() {
        return "PassportApplication";
    }
}