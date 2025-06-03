package com.bureaucracy.election.election_management_system.model.person;

import com.bureaucracy.election.election_management_system.model.election.Election;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@AttributeOverride(
        name = "identifier",
        column = @Column(name = "voter_id")
)
public class Voters extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    private Election election;

    @Override
    public String getRole() {
        return "Voter";
    }

    @Override
    public String getFullName() {
        return super.getFirstName() + " " + super.getLastName();
    }


}
