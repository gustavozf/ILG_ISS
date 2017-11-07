package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByAtivo(boolean ativo);

}
