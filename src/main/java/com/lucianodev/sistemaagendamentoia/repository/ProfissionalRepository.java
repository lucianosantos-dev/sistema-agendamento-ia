package com.lucianodev.sistemaagendamentoia.repository;

import com.lucianodev.sistemaagendamentoia.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, UUID>{
    boolean existsByNome(String nome);
}
