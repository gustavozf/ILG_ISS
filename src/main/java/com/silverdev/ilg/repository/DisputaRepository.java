package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Disputa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisputaRepository extends JpaRepository<Disputa,Integer> {
    List<Disputa> findAllByInscricaoAndAptoOrderByIdTurmaAscMediaDesc(Integer inscricao, boolean apto);
}
