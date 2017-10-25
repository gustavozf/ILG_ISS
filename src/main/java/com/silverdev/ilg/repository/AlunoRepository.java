package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
    List<Aluno> findByCpf(String cpf);
    Aluno getOneByCpf(String cpf);
}
