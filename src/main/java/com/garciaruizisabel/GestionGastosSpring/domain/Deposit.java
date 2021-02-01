package com.garciaruizisabel.GestionGastosSpring.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="deposit")
public class Deposit implements Serializable{
    public static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_deposit;
    
    @NotEmpty
    private String capacity;
    
    @NotEmpty
    private Float deposit;
    
    @NotEmpty
    private Date date;
   
    @NotEmpty
    private String comment;
}
