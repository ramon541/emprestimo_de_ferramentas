package daw1.emprestimo_de_ferramentas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ferramentas")
public class FerramentasController {
    
    @GetMapping("")
    public String ferramentas() {
        return "/ferramentas";
    }
}
