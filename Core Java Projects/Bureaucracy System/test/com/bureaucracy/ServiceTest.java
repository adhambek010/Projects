package com.bureaucracy;

import com.system.bureaucracy.citizen.Citizen;
import com.system.bureaucracy.service.DrivingLicenseApplication;
import com.system.bureaucracy.service.GovernmentService;
import com.system.bureaucracy.service.MarriageRegistration;
import com.system.bureaucracy.service.PassportApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {


    private Citizen createTestCitizen(boolean married) {
        return new Citizen("John Doe", 25, married, "Lumumy 16", "+48986574841", "Male");
    }

    @Test
    void marriageRegistrationIsEligibleTest() {
        Citizen partner1 = createTestCitizen(false);
        Citizen partner2 = createTestCitizen(false);
        GovernmentService service = new MarriageRegistration(partner1, partner2);
        assertFalse(service.isEligible(partner1));
    }

    @Test
    void passportApplicationCalculateFeeTest() {
        GovernmentService standard = new PassportApplication(false);
        GovernmentService expedited = new PassportApplication(true);

        assertEquals(100.00, standard.calculateFee());
        assertEquals(200.00, expedited.calculateFee());
    }

    @Test
    void passportApplicationIsEligibleTest() {
        Citizen citizen = createTestCitizen(false);
        GovernmentService service = new PassportApplication(false);
        assertTrue(service.isEligible(citizen));
    }

    @Test
    void drivingLicenseGetRequiredDocumentsTest() {
        Citizen citizen = createTestCitizen(false);
        GovernmentService learner = new DrivingLicenseApplication(citizen, "Learner");
        GovernmentService commercial = new DrivingLicenseApplication(citizen, "Commercial");

        assertEquals(2, learner.getRequiredDocuments().size());
        assertEquals(5, commercial.getRequiredDocuments().size());
    }

    @Test
    void drivingLicenseIsEligibleTest() {
        Citizen citizen1 = new Citizen("Anna", 16, false, "Niska 55", "+48976325647", "Female");
        Citizen citizen2 = new Citizen("Andrey", 21, false, "Narutowicha 48", "+48684592361", "Male");

        GovernmentService learner = new DrivingLicenseApplication(citizen1, "Learner");
        GovernmentService commercial = new DrivingLicenseApplication(citizen2, "Commercial");

        assertTrue(learner.isEligible(citizen2));
        assertFalse(commercial.isEligible(citizen1));
    }
}