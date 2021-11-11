package com.xmbapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Runway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private Long width;
    private Long length;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "aerodrome_id")
    private Aerodrome aerodrome;

    public Runway() {
    }

    public Runway(Long id, String designation, Long width, Long length) {
        this.id = id;
        this.designation = designation;
        this.width = width;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Aerodrome getAerodrome() {
        return aerodrome;
    }

    public void setAerodrome(Aerodrome aerodrome) {
        this.aerodrome = aerodrome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runway runway = (Runway) o;
        return Objects.equals(id, runway.id) && Objects.equals(designation, runway.designation) && Objects.equals(width, runway.width) && Objects.equals(length, runway.length) && Objects.equals(aerodrome, runway.aerodrome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, width, length, aerodrome);
    }
}