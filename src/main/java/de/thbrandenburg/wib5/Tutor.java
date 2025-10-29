package de.thbrandenburg.wib5;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tutor {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String subject;
    public Tutor(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public Tutor() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
