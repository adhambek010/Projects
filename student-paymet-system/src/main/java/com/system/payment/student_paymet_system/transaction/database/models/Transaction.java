package com.system.payment.student_paymet_system.transaction.models;

import com.system.payment.student_paymet_system.student.models.BaseEntity;
import com.system.payment.student_paymet_system.student.models.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(
        name = "identifier",
        column = @Column(name = "transaction_id")
)
public class Transaction extends BaseEntity {
    private long amount;
    private LocalDate date;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
