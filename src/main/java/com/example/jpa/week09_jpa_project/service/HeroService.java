package com.example.jpa.week09_jpa_project.service;

import com.example.jpa.week09_jpa_project.dto.HeroRequest;
import com.example.jpa.week09_jpa_project.dto.HeroResponse;
import com.example.jpa.week09_jpa_project.entity.Hero;
import com.example.jpa.week09_jpa_project.repository.HeroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HeroService {
    private final HeroRepository repository;

    public HeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public HeroResponse create(HeroRequest request) {
        Hero saved = repository.save(new Hero(request)); // INSERT
        return HeroResponse.from(saved);
    }

    public List<HeroResponse> findAll() {
        return repository.findAll().stream().map(HeroResponse::from).toList();
    }

    public HeroResponse findById(Long id) {
        return HeroResponse.from(findEntity(id));
    }

    public HeroResponse update(Long id, HeroRequest request) {
        Hero hero = findEntity(id);
        hero.update(request);
        return HeroResponse.from(repository.save(hero));
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

