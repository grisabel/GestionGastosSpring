package com.garciaruizisabel.GestionGastosSpring.web;


import com.garciaruizisabel.GestionGastosSpring.service.IDepositService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@Slf4j
public class StartController {
    
    @Autowired
    private IDepositService iDepositService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var deposits = iDepositService.listar();
        
        model.addAttribute("deposits",deposits);
        
        return "management";
    }
  
    
}
