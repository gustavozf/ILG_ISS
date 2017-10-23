package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    List<Turma> findByAtivo(boolean ativo);
    List<Turma> findByDisponivel(boolean disponivel);
}
