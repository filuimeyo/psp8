package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Manufactorer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Watch> watches;

    // Конструкторы, геттеры и сеттеры

    public Manufacturer() {
        // Пустой конструктор (обязателен для Hibernate)
    }

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Геттеры и сеттеры

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Watch> getWatches() {
        return watches;
    }

    public void setWatches(Set<Watch> watches) {
        this.watches = watches;
    }
}
