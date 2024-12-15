package daw1.emprestimo_de_ferramentas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;
import daw1.emprestimo_de_ferramentas.services.front.AddFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.DeleteFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.GetFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.ListAllFerramentasService;
import daw1.emprestimo_de_ferramentas.services.front.UpdateFerramentaService;

@Controller
@RequestMapping("/")
public class ViewController {


    @Autowired
    private ListAllFerramentasService listAllFerramentasService;

    @Autowired
    private DeleteFerramentaService deleteFerramentaService;

    @Autowired
    private AddFerramentaService addFerramentaService;

    @Autowired
    private GetFerramentaService getFerramentaService;

    @Autowired
    private UpdateFerramentaService updateFerramentaService;

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
        return "/ferramentas";
    }
    
    @GetMapping("ferramentas/remover/{id}")
    public String ferramentasRemover(@PathVariable Integer id) {
        this.deleteFerramentaService.execute(id);
        return "redirect:/ferramentas";
    }

    @GetMapping("ferramentas/adicionar")
    public String ferramentasNova() {
        return "/novaFerramenta";
    }

    @PostMapping("ferramentas/add")
    public String addFerramenta(RedirectAttributes redirectAttributes, String nome) {
        if (nome.trim().equals("")) {
            redirectAttributes.addFlashAttribute("error_message", "O nome da ferramenta deve estar preenchido");
            return "redirect:/ferramentas/adicionar";
        }
        
        FerramentaEntity ferramenta = new FerramentaEntity();
        ferramenta.setNome(nome);
        this.addFerramentaService.execute(ferramenta);

        return "redirect:/ferramentas";
    }

    @GetMapping("ferramentas/editar/{id}")
    public String editarFerramenta(Model model, @PathVariable Integer id) {
        var result = this.getFerramentaService.execute(id);
        model.addAttribute("ferramentas", result);
        return "/editarFerramenta";
    }

    @PostMapping("ferramentas/update")
    public String updateFerramenta(RedirectAttributes redirectAttributes, Integer idFerramenta, String nome) {
        
        if (nome.trim().equals("")) {
            redirectAttributes.addFlashAttribute("error_message", "O nome da ferramenta deve estar preenchido");
            return "redirect:/ferramentas/editar/" + idFerramenta;
        }

        FerramentaEntity ferramenta = new FerramentaEntity();
        ferramenta.setIdFerramenta(idFerramenta);
        ferramenta.setNome(nome);
        
        var result = this.updateFerramentaService.execute(ferramenta);

        return "redirect:/ferramentas";
    }

    //------------------- EMPRESTIMOS -------------------
    @GetMapping("emprestimos")
    public String emprestimos() {
        return "/emprestimos";
    }
}
