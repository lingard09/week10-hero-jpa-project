package com.example.jpa.week09_jpa_project.entity;

import com.example.jpa.week09_jpa_project.dto.HeroRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String role;

    @Column(nullable = false)
    private Integer health;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String team;

    protected Hero() {
    } // JPA uses the no-args constructor.

    public Hero(HeroRequest request) {
        this.name = request.name();
        this.role = request.role();
        this.health = request.health();
        this.country = request.country();
        this.team = request.team();
    }

    public void update(HeroRequest request) {
        this.name = request.name();
        this.role = request.role();
        this.health = request.health();
        this.country = request.country();
        this.team = request.team();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Integer getHealth() {
        return health;
    }

    public String getCountry() {
        return country;
    }

    public String getTeam() {
        return team;
    }

}