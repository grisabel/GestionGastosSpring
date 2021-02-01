package com.garciaruizisabel.GestionGastosSpring.service;

import com.garciaruizisabel.GestionGastosSpring.dao.PersonDao;
import com.garciaruizisabel.GestionGastosSpring.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//ES MUY IMPORTANTE QUE TODOS LOS MÉTODOS QUE VAYAN A MODIFICAR ALGUNA TABLA DE LA BBDD,(Se realice un commit)
//SE MARQUE COMO TRANSACIONAL, DE ESTA MANERA SI ALGO NO HA IDO BIEN, SE REALIZA UN ROLLBACK

@Service
public class PersonService implements IPersonService{

    @Autowired
    private PersonDao personDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Person> listar() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Person person) {
        personDao.save(person);
    }
    
    @Override
    @Transactional
    public void eliminar(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person buscarPersona(Person person) {
        //Esto es que si no encuentra la persona, devuelva null
        return  personDao.findById(person.getId_person()).orElse(null);

    }
    
}
