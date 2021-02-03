package com.garciaruizisabel.GestionGastosSpring.web;


import com.garciaruizisabel.GestionGastosSpring.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;
import com.garciaruizisabel.GestionGastosSpring.domain.Usuario;
import com.garciaruizisabel.GestionGastosSpring.service.IDepositService;




@Controller
@Slf4j
public class StartController {
    
    @Autowired
    private IDepositService iDepositService;

        
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String inicio(Model model, Usuario usuario){
   
       var deposits = usuarioService.listarIngresos();
        
        model.addAttribute("deposits",deposits);
        
        return "management";
    }
    
    @GetMapping("/eliminar")
    public String añadirGasto(Deposit deposit){
        iDepositService.eliminar(deposit);
        return "redirect:/";
    }
  
    
}
