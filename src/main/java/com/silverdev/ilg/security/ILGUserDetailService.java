package com.silverdev.ilg.security;


import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class ILGUserDetailService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ILGUserDetailService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Username e/ou password Incorreto"));
        return new User(username, usuario.getPassword(), getPermissao(usuario));
    }
}
