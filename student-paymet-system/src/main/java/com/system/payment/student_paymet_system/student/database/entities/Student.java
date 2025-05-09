package com.system.payment.student_paymet_system.student.models;

import com.system.payment.student_paymet_system.transaction.models.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "student_id")
)
public class Student extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private  byte course;
    private int groupNumber;
    private String fieldOfStudy;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private List<Transaction> transactions;
}
