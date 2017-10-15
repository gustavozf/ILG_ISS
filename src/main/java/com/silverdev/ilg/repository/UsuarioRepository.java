package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findAllByAcesso(Role acesso);
}
