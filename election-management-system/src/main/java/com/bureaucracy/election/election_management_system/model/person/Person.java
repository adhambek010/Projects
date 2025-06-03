package com.bureaucracy.election.election_management_system.model.person;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person extends BaseEntity {
    @Size(min = 2, max = 45, message = "First name must be 2-45 characters")
    private String firstName;

    @Size(min = 2, max = 45, message = "Last name must be 2-45 characters")
    private String lastName;

    @Pattern(regexp = "^[+]?[0-9\\s\\-]{10,15}$", message = "Invalid phone number")
    private String phoneNumber;


    public abstract String getRole();

    public abstract String getFullName();

}
