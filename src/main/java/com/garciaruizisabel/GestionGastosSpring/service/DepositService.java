
package com.garciaruizisabel.GestionGastosSpring.service;

import com.garciaruizisabel.GestionGastosSpring.dao.DepositDao;
import com.garciaruizisabel.GestionGastosSpring.dao.UsuarioDao;
import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;
import com.garciaruizisabel.GestionGastosSpring.domain.Usuario;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DepositService implements IDepositService{

    @Autowired
    private DepositDao depositDao;
  

    @Override
    @Transactional()
    public void guardar(Deposit deposit) {
        depositDao.save(deposit);
    }

    @Override
    @Transactional()
    public void eliminar(Deposit deposit) {
        depositDao.delete(deposit);
    }

    @Override
    @Transactional(readOnly = true)
    public Deposit buscarDeposit(Deposit deposit) {
       return  depositDao.findById(deposit.getId_deposit()).orElse(null);
    }
    
    
}
