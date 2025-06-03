package com.bureaucracy.election.election_management_system.model.election;

import com.bureaucracy.election.election_management_system.model.person.BaseEntity;
import com.bureaucracy.election.election_management_system.model.person.Candidates;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "vote_id")
)
public class Votes extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidates candidates;
    @ManyToOne(fetch = FetchType.LAZY)
    private Election election;
    @OneToOne(fetch = FetchType.LAZY)
    private Votes votes;
}
