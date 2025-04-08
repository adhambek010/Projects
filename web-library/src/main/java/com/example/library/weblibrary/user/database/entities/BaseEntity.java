package com.example.library.weblibrary.user.database.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @jakarta.persistence.Id
    private String identifier = UUID.randomUUID().toString();

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

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
