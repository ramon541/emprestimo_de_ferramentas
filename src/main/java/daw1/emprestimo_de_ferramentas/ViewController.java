package daw1.emprestimo_de_ferramentas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import daw1.emprestimo_de_ferramentas.services.front.ListAllFerramentasService;

@Controller
@RequestMapping("/")
public class ViewController {


    @Autowired
    private ListAllFerramentasService listAllFerramentasService;

    //------------------- LOGIN -------------------
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
            return "redirect:/home";
        }

        redirectAttributes.addFlashAttribute("error_message", "Usuário ou senha inválidos");
        return "redirect:/login";
    }


    //------------------- HOME -------------------
    @GetMapping("home")
    public String home() {
        return "/home";
    }

    //------------------- FERRAMENTAS -------------------
    @GetMapping("ferramentas")
    public String ferramentas(Model model) {
        var result = this.listAllFerramentasService.execute();
        model.addAttribute("ferramentas", result);
        System.out.println(result);
        return "/ferramentas";
    }

    //------------------- EMPRESTIMOS -------------------
    @GetMapping("emprestimos")
    public String emprestimos() {
        return "/emprestimos";
    }
}
