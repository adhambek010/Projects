package com.system.bureaucracy.main;

import com.system.bureaucracy.citizen.Citizen;
import com.system.bureaucracy.service.DrivingLicenseApplication;
import com.system.bureaucracy.service.GovernmentService;
import com.system.bureaucracy.service.MarriageRegistration;
import com.system.bureaucracy.service.PassportApplication;

import java.util.Scanner;

public class GovernmentServicePortal {
    private final Scanner scanner;

    public GovernmentServicePortal(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            GovernmentServicePortal portal = new GovernmentServicePortal(sc);
            portal.startService();
        }
    }

    public void startService() {
        while (true) {
            System.out.println("\nAvailable Services:");
            System.out.println("1. Passport Application");
            System.out.println("2. Marriage Registration");
            System.out.println("3. Driving License Application");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please enter a value");
                continue;
            }

            int activationCode;
            try {
                activationCode = Character.getNumericValue(input.charAt(0));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (activationCode == 4) {
                System.out.println("Exiting system...");
                return;
            }

            Citizen citizen = collectUserData();
            if (citizen == null) continue;

            switch (activationCode) {
                case 1 -> passportApplication(citizen);
                case 2 -> marriageRegistration(citizen);
                case 3 -> drivingLicenceApplication(citizen);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private Citizen collectUserData() {
        try {
            System.out.println("\n=== Citizen Information ===");

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter your address: ");
            String address = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter your gender: ");
            String gender = scanner.nextLine();

            System.out.print("Are you married? (yes/no): ");
            boolean married = scanner.nextLine().equalsIgnoreCase("yes");

            return new Citizen(name, age, married, address, phone, gender);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format. Please enter numbers only.");
            return null;
        }
    }

    private void passportApplication(Citizen citizen) {
        System.out.print("Do you want expedited application? (yes/no): ");
        boolean isExpedited = scanner.nextLine().equalsIgnoreCase("yes");

        GovernmentService service = new PassportApplication(isExpedited);
        processService(service, citizen);
    }

    private void marriageRegistration(Citizen citizen1) {
        System.out.println("\n=== Partner Information ===");
        Citizen citizen2 = collectUserData();
        if (citizen2 == null) return;

        GovernmentService service = new MarriageRegistration(citizen1, citizen2);
        processService(service, citizen1);  // Process with primary citizen
    }

    private void drivingLicenceApplication(Citizen citizen) {
        System.out.print("Enter license type (Learner/Regular/Commercial): ");
        String licenseType = scanner.nextLine();

        GovernmentService service = new DrivingLicenseApplication(citizen, licenseType);
        processService(service, citizen);
    }

    private void processService(GovernmentService service, Citizen citizen) {
        System.out.println("\n=== Processing " + service.getServiceName() + " ===");
        System.out.println("Required documents:");
        service.getRequiredDocuments().forEach(doc -> System.out.println("- " + doc));

        System.out.println("Estimated fee: $" + service.calculateFee());
        System.out.println("Processing time: " + service.getProcessingDays() + " days");

        if (service.isEligible(citizen)) {
            service.processRequest(citizen);
            service.sendNotification(citizen);
            System.out.println("\nService completed successfully!");
        } else {
            System.out.println("\nSorry, you are not eligible for this service.");
        }
    }
}