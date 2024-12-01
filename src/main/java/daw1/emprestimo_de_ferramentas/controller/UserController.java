package daw1.emprestimo_de_ferramentas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserController {
    
    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }
    

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}
