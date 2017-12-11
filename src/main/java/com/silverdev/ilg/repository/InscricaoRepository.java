package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
    List<Inscricao> findAll();
    List<Inscricao> findAllByInscricaoAtiva(boolean ativo);
}
