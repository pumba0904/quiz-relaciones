package com.example.demo.repositorios;

import com.example.demo.entidades.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}