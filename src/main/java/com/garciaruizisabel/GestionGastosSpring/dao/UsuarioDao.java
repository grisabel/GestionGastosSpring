package com.garciaruizisabel.GestionGastosSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.garciaruizisabel.GestionGastosSpring.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    //Este método debe llamarse así, pues es parte de la seguridad de Spring
    Usuario findByUsername(String username);
}
