package com.example.jpa.week09_jpa_project.repository;

import com.example.jpa.week09_jpa_project.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long>  {
}
