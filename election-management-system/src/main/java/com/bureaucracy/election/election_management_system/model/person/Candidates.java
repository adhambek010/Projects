package com.bureaucracy.election.election_management_system.model.person;

import com.bureaucracy.election.election_management_system.model.election.Election;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "candidate_id")
)
public class Candidate extends Person {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "election_id")
    private Election election;

    private String party;
}