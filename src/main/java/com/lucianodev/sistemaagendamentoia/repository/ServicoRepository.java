package com.lucianodev.sistemaagendamentoia.repository;

import com.lucianodev.sistemaagendamentoia.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, UUID>{
    boolean existsByNome(String nome);
}
