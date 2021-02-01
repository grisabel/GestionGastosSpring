package com.garciaruizisabel.GestionGastosSpring.dao;


import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;


//En la interfaz de CrudRepository se debe poner primero el tipo de objeto y segundo el tipo de la PK

public interface DepositDao extends JpaRepository<Deposit, Long>{
    
}
