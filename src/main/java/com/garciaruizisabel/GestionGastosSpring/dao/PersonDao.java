package com.garciaruizisabel.GestionGastosSpring.dao;


import com.garciaruizisabel.GestionGastosSpring.domain.Person;
import org.springframework.data.repository.CrudRepository;


//En la interfaz de CrudRepository se debe poner primero el tipo de objeto y segundo el tipo de la PK

public interface PersonDao extends CrudRepository<Person, Long>{
    
}
