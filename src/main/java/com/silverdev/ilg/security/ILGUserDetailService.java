package com.silverdev.ilg.security;


import com.silverdev.ilg.model.Usuario;
import com.silverdev.ilg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    private Collections<? extends GrantedAuthority> getPermissao(Usuario usuario){
        Set<SimpleGrantedAuthority> authority = new HashSet<>();
        authority.add(new SimpleGrantedAuthority(usuario.getRole().toString().topUpperCase()));
        return authority;
    }
}
