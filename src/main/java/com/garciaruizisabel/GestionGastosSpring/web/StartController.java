package com.garciaruizisabel.GestionGastosSpring.web;

import com.garciaruizisabel.GestionGastosSpring.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.garciaruizisabel.GestionGastosSpring.domain.Deposit;
import com.garciaruizisabel.GestionGastosSpring.service.IDepositService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StartController {

    @Autowired
    private IDepositService iDepositService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {

        var nombre = usuarioService.nombreUsuario();
        model.addAttribute("nombre", nombre);
        model.addAttribute("deposit", new Deposit());
    

        return "management";
    }

    @GetMapping("/gastosAnuales")
    public String gastosAnuales(Model model) {

        var deposits = usuarioService.listarIngresos();
        model.addAttribute("deposits", deposits);

        var nombre = usuarioService.nombreUsuario();
        model.addAttribute("nombre", nombre);

        return "gastosAnuales";
    }

    @GetMapping("/eliminar")
    public String añadirGasto(Deposit deposit) {
        iDepositService.eliminar(deposit);
        return "redirect:/";
    }

    @PostMapping("/guardarIngreso")
    public String guardar(Deposit deposit, Model model) {
       model.addAttribute(deposit);
        iDepositService.guardar(deposit);
        return "redirect:/";
    }

}
