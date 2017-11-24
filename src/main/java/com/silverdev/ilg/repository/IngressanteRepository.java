package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.Ingressante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressanteRepository extends JpaRepository<Ingressante,Integer> {
    List<Ingressante> findByCpf(String cpf);
    List<Ingressante> findAllByInscricao(Integer inscricao);
    Ingressante findById(Integer id);
    List<Ingressante> findAllByInscricaoOrderByTurmaAscMediaAsc(Integer inscricao);
}
