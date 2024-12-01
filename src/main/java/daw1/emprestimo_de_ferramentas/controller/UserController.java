package daw1.emprestimo_de_ferramentas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @PostMapping("/signIn")
    public String signIn(RedirectAttributes redirectAttributes, String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Entrou");
            return "redirect:/home/";
        }

        redirectAttributes.addFlashAttribute("error_message", "Usuário ou senha inválidos");
        return "redirect:/login";
    }
}
