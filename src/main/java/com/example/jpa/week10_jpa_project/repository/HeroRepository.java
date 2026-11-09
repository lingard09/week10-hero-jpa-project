package com.example.jpa.week10_jpa_project.repository;

import com.example.jpa.week10_jpa_project.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long>  { // Hero는 이 Repository가 관리하는 엔티티 타입, Long은 그 엔티티의 기본키 타입
    // JpaRepository에서 기본 제공하는 CRUD 메서드
        // save(entity) - 새 엔티티를 저장하거나 기존 엔티티의 상태를 병합
        // findById(id) - 기본키로 엔티티 하나 조회
            // findById()가 Optional<Hero>를 반환하는 이유 - 해당 ID의 영웅이 없을 수도 있기 때문. 조회 성공 시 영웅을 담고, 없으면 빈 Optional을 반환.
        // findAll() - 전체 엔티티 조회
        // existsById(id) - 해당 기본키의 데이터가 존재하는지 확인
        // count() -  전체 엔티티 개수 조회
        // deleteById(id) - 해당 기본키의 엔티티 삭제

    // 기본 메서드와 직접 선언하는 Query Method의 차이 - 기본 CRUD 메서드는 JpaRepository를 상속하면 바로 사용 가능. 반면 findByRole(String role) 같은 Query Method는 엔티티 필드에 맞춰 개발자가 메서드를 선언하면 Spring Data JPA가 이름을 해석해 쿼리를 생성.
}
