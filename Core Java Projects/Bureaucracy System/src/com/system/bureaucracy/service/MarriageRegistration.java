package com.system.bureaucracy.service;

import com.system.bureaucracy.citizen.Citizen;

import java.util.Arrays;
import java.util.List;

public class MarriageRegistration implements GovernmentService{
    private final Citizen partner1;
    private final Citizen partner2;

    public MarriageRegistration(Citizen partner1, Citizen partner2) {
        this.partner1 = partner1;
        this.partner2 = partner2;
    }

    @Override
    public void processRequest(Citizen requester) {
        System.out.println("Processing marriage registration between " +
                partner1.getName() + " and " + partner2.getName());
        verifySingleStatus(partner1);
        verifySingleStatus(partner2);
    }

    @Override
    public String getServiceName() {
        return "Marriage Registration";
    }

    @Override
    public boolean isEligible(Citizen requester) {
        return partner1.getAge() >= 18 &&
                partner2.getAge() >= 18 &&
                partner1.isMarried() &&
                partner2.isMarried();
    }

    @Override
    public double calculateFee() {
        return 75.00;
    }

    @Override
    public int getProcessingDays() {
        return 7;
    }

    @Override
    public List<String> getRequiredDocuments() {
        return Arrays.asList(
                "ID Proof for both partners",
                "Birth Certificates",
                "Single Status Affidavits"
        );
    }

    @Override
    public void sendNotification(Citizen requester) {
        System.out.println("Sending certified marriage certificate by post to " +
                requester.getAddress());
    }

    private void verifySingleStatus(Citizen c) {
        if(!c.isMarried()){
            System.out.println("Verifying marital status for " + c.getName());
        }
    }

    @Override
    public String toString() {
        return "MarriageRegistration";
    }
}