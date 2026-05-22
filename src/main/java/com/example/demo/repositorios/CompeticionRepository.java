package com.example.demo.repositorios;

import com.example.demo.entidades.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}
