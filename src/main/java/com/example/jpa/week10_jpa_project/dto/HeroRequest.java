package com.example.jpa.week10_jpa_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record HeroRequest(
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Size(max = 50) String role,
        @NotNull @PositiveOrZero Integer health,
        @NotBlank @Size(max = 100) String country,

        @NotBlank @Size(max = 100) String team
) {
}
