package com.example.jpa.week09_jpa_project.dto;

import com.example.jpa.week09_jpa_project.entity.Hero;

public record HeroResponse(Long id, String name, String role, Integer health, String country, String team) {
    public static HeroResponse from(Hero hero) {
        return new HeroResponse(hero.getId(), hero.getName(), hero.getRole(),
                hero.getHealth(), hero.getCountry(), hero.getTeam());
    }
}