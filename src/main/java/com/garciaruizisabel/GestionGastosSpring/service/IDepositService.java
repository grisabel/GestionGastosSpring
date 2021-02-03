package com.garciaruizisabel.GestionGastosSpring.service;

import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;

import java.util.List;


public interface IDepositService {
    
    public void guardar(Deposit deposit);
    
    public void eliminar(Deposit deposit);
    
    public Deposit buscarDeposit(Deposit deposit);
}
