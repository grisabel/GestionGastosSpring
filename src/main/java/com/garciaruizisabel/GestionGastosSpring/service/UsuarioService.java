package com.garciaruizisabel.GestionGastosSpring.service;

import com.garciaruizisabel.GestionGastosSpring.dao.UsuarioDao;
import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.garciaruizisabel.GestionGastosSpring.domain.Usuario;
import com.garciaruizisabel.GestionGastosSpring.domain.Rol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")//Esto significa que este Bean lo va a uitlizar Spring Security, Muy importante que sea ese nombre para que loo reconozca, sino es así, debemos añadir más configuración
@Slf4j
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        System.out.print(usuario);
        if(usuario == null){
           throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }  
        
        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }

    
    public List<Deposit> listarIngresos() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioDao.findByUsername(auth.getName());
        
        return usuario.getDeposits();
    }
    
    
     public String nombreUsuario(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   
        return auth.getName();
    }
}
