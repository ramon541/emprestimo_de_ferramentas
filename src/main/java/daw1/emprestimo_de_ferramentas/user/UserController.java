package daw1.emprestimo_de_ferramentas.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}
