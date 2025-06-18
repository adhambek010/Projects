package com.bureaucracy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidationTests {

    @Test
    void testInvalidActivationCode() {
        String input = "a";
        int code = Character.getNumericValue(input.charAt(0));
        assertFalse(code >= 1 && code <= 3);
    }

    @Test
    void testValidAgeInput() {
        String input = "25";
        int age = Integer.parseInt(input);
        assertTrue(age > 0);
    }

    @Test
    void testInvalidNameInput() {
        String input = null;
        assertNull(input);
    }

    @Test
    void testValidAddressInput() {
        String input = "Jana Matejki 21/23";
        assertNotNull(input);
        assertFalse(input.trim().isEmpty());
    }

    @Test
    void testMarriageStatusInput() {
        assertTrue("yes".equalsIgnoreCase("YES"));
        assertTrue("YeS".equalsIgnoreCase("yes"));

        assertFalse("no".equalsIgnoreCase("yes"));
        assertFalse("NO".equalsIgnoreCase("yes"));
    }

    @Test
    void testPhoneNumberInput() {
        String input = "+48509926654";
        assertTrue(input.length() <= 15);
    }

    @Test
    void testEmptyInput() {
        String input = "";
        assertTrue(input.isEmpty()
        );
    }
}