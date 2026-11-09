package com.example.jpa.week10_jpa_project.entity;

import com.example.jpa.week10_jpa_project.dto.HeroRequest;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // 이 클래스를 JPA가 관리할 엔티티로 지정
@Table(name = "heroes") // Hero를 DB의 heroes 테이블과 연결
@EntityListeners(AuditingEntityListener.class)
public class Hero {
    @Id // id 필드가 각 행을 구분하는 기본키임을 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MariaDB의 AUTO_INCREMENT처럼 DB가 생성한 기본키 값을 사용
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

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}