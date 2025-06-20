package com.bureaucracy.election.election_management_system.model.person;

import com.bureaucracy.election.election_management_system.model.election.Election;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "candidate_id")
)
public class Candidates extends Person {

    private String party;
    @ManyToOne(fetch = FetchType.LAZY)
    private Election election;


    @Override
    public String getRole() {
        return "Candidate";
    }

    @Override
    public String getFullName() {
        return "" + super;
    }
}