package com.garciaruizisabel.GestionGastosSpring.service;

import java.util.List;
import com.garciaruizisabel.GestionGastosSpring.domain.Person;

public interface IPersonService {
    
    public List<Person> listar();
    
    public void guardar(Person person);
    
    public void eliminar(Person person);
    
    public Person buscarPersona(Person person);
}
