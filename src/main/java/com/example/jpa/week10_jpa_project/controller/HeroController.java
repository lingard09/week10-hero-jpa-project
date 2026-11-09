package com.example.jpa.week10_jpa_project.controller;

import com.example.jpa.week10_jpa_project.dto.HeroRequest;
import com.example.jpa.week10_jpa_project.dto.HeroResponse;
import com.example.jpa.week10_jpa_project.service.HeroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    private final HeroService service;

    public HeroController(HeroService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<HeroResponse> create(@Valid @RequestBody HeroRequest request) {
        HeroResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/heroes/" + created.id())).body(created);
    }

    @GetMapping
    public List<HeroResponse> findAll() { return service.findAll(); }

    @GetMapping("/search/role")
    public List<HeroResponse> findByRole(@RequestParam String role) {
        return service.findByRole(role);
    }

    @GetMapping("/search/role-country")
    public List<HeroResponse> findByRoleAndCountry(
            @RequestParam String role,
            @RequestParam String country) {
        return service.findByRoleAndCountry(role, country);
    }

    @GetMapping("/search/role-health")
    public List<HeroResponse> findByRoleOrderByHealthDesc(@RequestParam String role) {
        return service.findByRoleOrderByHealthDesc(role);
    }

    @GetMapping("/{id}")
    public HeroResponse findById(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public HeroResponse update(@PathVariable Long id, @Valid @RequestBody HeroRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
