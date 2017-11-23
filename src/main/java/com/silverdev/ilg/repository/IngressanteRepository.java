package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Aluno;
import com.silverdev.ilg.model.Ingressante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressanteRepository extends JpaRepository<Ingressante,Integer> {
    List<Ingressante> findByCpf(String cpf);
    //List<Ingressante> findByInscricao_id(Integer inscricao_id);
    Ingressante findById(Integer id);
}
