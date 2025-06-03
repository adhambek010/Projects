package com.bureaucracy.election.election_management_system.model.election;

import com.bureaucracy.election.election_management_system.model.person.BaseEntity;
import com.bureaucracy.election.election_management_system.model.person.Candidates;
import com.bureaucracy.election.election_management_system.model.person.Voters;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "election_id")
)
public class Election extends BaseEntity {
    private String name;
    private String description;
    private String location;
    private LocalDate date;
    private String status;
    private String candidateLimit;
    private String voterLimit;

    @OneToMany(mappedBy = "election", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Candidates> candidates;
    @OneToMany(mappedBy = "election", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Votes> votes;
    @OneToMany(mappedBy = "election", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voters> voters;

}
