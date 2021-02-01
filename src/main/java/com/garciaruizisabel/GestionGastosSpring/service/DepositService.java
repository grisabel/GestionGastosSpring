
package com.garciaruizisabel.GestionGastosSpring.service;

import com.garciaruizisabel.GestionGastosSpring.dao.DepositDao;
import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepositService implements IDepositService{

    @Autowired
    private DepositDao depositDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Deposit> listar() {
        return (List<Deposit>) depositDao.findAll();
    }
/*
    @Override
    @Transactional(readOnly = true)
    public List<Deposit> listar(Date año) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
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
