package com.system.payment.student_paymet_system.student.models;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @jakarta.persistence.Id
    private String identifier = UUID.randomUUID().toString();

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Objects.equals(getIdentifier(), ((BaseEntity) obj).getIdentifier());
    }
    @Override
    public String toString() {
        return getIdentifier();
    }
}