package com.example.jpa.week10_jpa_project.dto;

import com.example.jpa.week10_jpa_project.entity.Hero;

import java.time.LocalDateTime;

public record HeroResponse(
        Long id,
        String name,
        String role,
        Integer health,
        String country,
        String team,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
    public static HeroResponse from(Hero hero) {
        return new HeroResponse(
                hero.getId(), hero.getName(), hero.getRole(),
                hero.getHealth(), hero.getCountry(), hero.getTeam(),
                hero.getCreatedAt(), hero.getUpdatedAt());
    }
}