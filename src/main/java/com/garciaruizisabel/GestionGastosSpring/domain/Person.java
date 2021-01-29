package com.garciaruizisabel.GestionGastosSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author grisa
 */
@Data
@Entity
@Table(name="person") //Esto es conveniente para que no haya problemas
         //con algunos SO, ya que en las BBDD las tablas empiezan 
         //minúscula,y clas clases con mayúscula
public class Person implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id //Se debe indicar cuál es la clave primaria con esta anotación
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Indicamos la forma de generar esta llave primaria
    private Long id;
    
    @NotEmpty
    private String name;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String password;
}
