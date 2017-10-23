package com.silverdev.ilg.repository;

import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findByUsername(String username);
    Usuario getOneByCpf(String cpf);
    List<Usuario> findAllByAcesso(Role acesso);
    List<Usuario> findByAtivo(boolean ativo);
    List<Usuario> findAllByAtivoAndAcesso(boolean ativo, Role acesso);
}
