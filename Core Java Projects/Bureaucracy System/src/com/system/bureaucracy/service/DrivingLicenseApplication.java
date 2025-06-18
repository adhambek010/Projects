
package com.system.bureaucracy.service;

import com.system.bureaucracy.citizen.Citizen;

import java.util.ArrayList;
import java.util.List;

public class DrivingLicenseApplication implements GovernmentService {
    private final Citizen citizen;
    private final String licenseType;

    public DrivingLicenseApplication(Citizen citizen, String licenseType) {
        this.citizen = citizen;
        this.licenseType = licenseType;
    }

    @Override
    public void processRequest(Citizen requester) {
        System.out.println("Processing " + licenseType + " license for " + requester.getName());
        if(licenseType.equals("Learner")) {
            issueTheoryCertificate(requester);
        } else {
            conductPracticalTest(requester);
        }
    }

    @Override
    public String getServiceName() {
        return "Driving License (" + licenseType + ")";
    }

    @Override
    public boolean isEligible(Citizen requester) {
        return switch (licenseType) {
            case "Learner" -> requester.getAge() >= 16;
            case "Regular" -> requester.getAge() >= 18 &&
                    requester.hasLearnerLicense();
            case "Commercial" -> requester.getAge() >= 21 &&
                    requester.passedMedicalExam();
            default -> false;
        };
    }

    @Override
    public double calculateFee() {
        return switch(licenseType) {
            case "Learner" -> 50.00;
            case "Regular" -> 100.00;
            case "Commercial" -> 250.00;
            default -> 0.00;
        };
    }

    @Override
    public int getProcessingDays() {
        return switch(licenseType) {
            case "Learner" -> 1;
            case "Regular", "Commercial" -> 5;
            default -> 0;
        };
    }

    @Override
    public List<String> getRequiredDocuments() {
        List<String> docs = new ArrayList<>();
        docs.add("ID Proof");
        docs.add("Address Proof");

        if(!licenseType.equals("Learner")) {
            docs.add("Learner License");
            docs.add("Theory Test Certificate");
        }

        if(licenseType.equals("Commercial")) {
            docs.add("Medical Certificate");
        }

        return docs;
    }

    private void issueTheoryCertificate(Citizen c) {
        System.out.println("Issuing theory test certificate");
    }

    private void conductPracticalTest(Citizen c) {
        System.out.println("Conducting practical driving test");
    }

    @Override
    public String toString() {
        return "DrivingLicenseApplication{" +
                "licenseType='" + licenseType + '\'' +
                '}';
    }
}
