package com.xmbapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Aerodrome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date created_at = new java.sql.Date(System.currentTimeMillis());


    @OneToMany(mappedBy = "aerodrome")
    private List<Runway> runways;

    public Aerodrome() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerodrome aerodrome = (Aerodrome) o;
        return Objects.equals(id, aerodrome.id) && Objects.equals(name, aerodrome.name) && Objects.equals(city, aerodrome.city) && Objects.equals(description, aerodrome.description) && Objects.equals(created_at, aerodrome.created_at) && Objects.equals(runways, aerodrome.runways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, description, created_at, runways);
    }
}
