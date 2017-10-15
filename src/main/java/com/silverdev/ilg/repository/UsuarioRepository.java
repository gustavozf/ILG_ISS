package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.model.enums.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findAllByAcesso(Acesso acesso);
}
