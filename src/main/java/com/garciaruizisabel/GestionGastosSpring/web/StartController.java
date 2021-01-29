package com.garciaruizisabel.GestionGastosSpring.web;

import com.garciaruizisabel.GestionGastosSpring.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@Slf4j
public class StartController {
    
    @Autowired
    private IPersonService iPersonService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = iPersonService.listar();
        
        model.addAttribute("personas",personas);
        
        return "management";
    }
  
    
}
