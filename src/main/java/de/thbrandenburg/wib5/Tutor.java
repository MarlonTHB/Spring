package de.thbrandenburg.wib5;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Tutor {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ElementCollection
    List<String> subjects;

    public Tutor() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
