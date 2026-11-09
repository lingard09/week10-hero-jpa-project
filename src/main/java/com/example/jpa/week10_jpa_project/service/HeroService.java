package com.example.jpa.week10_jpa_project.service;

import com.example.jpa.week10_jpa_project.dto.HeroRequest;
import com.example.jpa.week10_jpa_project.dto.HeroResponse;
import com.example.jpa.week10_jpa_project.entity.Hero;
import com.example.jpa.week10_jpa_project.repository.HeroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HeroService {
    private final HeroRepository repository;

    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public HeroResponse create(HeroRequest request) {
        // Q7: 새 Hero의 id는 null이므로 새 엔티티로 판단해서 persist()로 영속화하여 DB에 INSERT가 실행
        // Q7: “save()에 전달한 엔티티의 id가 있으면 기존 엔티티로 판단해서 merge()로 상태를 영속성 컨텍스트에 병합. 변경 내용이 있으면 DB에 UPDATE가 실행
        Hero saved = repository.save(new Hero(request)); // INSERT
        return HeroResponse.from(saved);
    }

    public List<HeroResponse> findAll() {
        return repository.findAll().stream().map(HeroResponse::from).toList();
    }

    public List<HeroResponse> findByRole(String role) {
        return repository.findByRole(role)
                .stream()
                .map(HeroResponse::from)
                .toList();
    }

    public List<HeroResponse> findByRoleAndCountry(String role, String country) {
        return repository.findByRoleAndCountry(role, country)
                .stream()
                .map(HeroResponse::from)
                .toList();
    }

    public List<HeroResponse> findByRoleOrderByHealthDesc(String role) {
        return repository.findByRoleOrderByHealthDesc(role)
                .stream()
                .map(HeroResponse::from)
                .toList();
    }

    public HeroResponse findById(Long id) {
        return HeroResponse.from(findEntity(id));
    }

    // Q8: Transactional은 조회부터 변경까지 하나의 트랜잭션으로 묶어 주는 역할
    // Q8: 트랜잭션 안에서 조회한 엔티티의 변경을 Hibernate가 감지해서 커밋 시 DB에 반영하므로 save()를 다시 호출하지 않아도 됨.
    @Transactional
    public HeroResponse update(Long id, HeroRequest request) {
        Hero hero = findEntity(id);
        hero.update(request);
        return HeroResponse.from(hero);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found: " + id);
        }
        repository.deleteById(id);
    }

    private Hero findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Hero not found: " + id));
    }
}

