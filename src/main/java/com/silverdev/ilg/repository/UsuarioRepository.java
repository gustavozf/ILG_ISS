package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByUsername(String username);
}
