package com.example.jpa.week10_jpa_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week10JpaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week10JpaProjectApplication.class, args);
    }

}
