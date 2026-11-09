package com.example.jpa.week10_jpa_project.repository;

import com.example.jpa.week10_jpa_project.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long>  { // Hero 객체와 PK의 타입인 Long
    // JpaRepository에서 기본 제공하는 CRUD 메서드를 5개 이상 찾아 메서드명과 역할
}
