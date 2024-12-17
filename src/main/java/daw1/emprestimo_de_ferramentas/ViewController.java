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
import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;
import daw1.emprestimo_de_ferramentas.services.front.AddFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.AddUsuarioService;
import daw1.emprestimo_de_ferramentas.services.front.DeleteFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.DeleteUsuarioService;
import daw1.emprestimo_de_ferramentas.services.front.GetFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.GetUsuarioService;
import daw1.emprestimo_de_ferramentas.services.front.ListAllFerramentasService;
import daw1.emprestimo_de_ferramentas.services.front.ListAllUsuariosService;
import daw1.emprestimo_de_ferramentas.services.front.LoginUsuarioService;
import daw1.emprestimo_de_ferramentas.services.front.UpdateFerramentaService;
import daw1.emprestimo_de_ferramentas.services.front.UpdateUsuarioService;

@Controller
@RequestMapping("/")
public class ViewController {


    //------------------- FERRAMENTAS -------------------
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

    //------------------- USUÁRIOS -------------------
    @Autowired
    private ListAllUsuariosService listAllUsuariosService;
    
    @Autowired
    private DeleteUsuarioService deleteUsuarioService;
    
    @Autowired
    private AddUsuarioService addUsuarioService;
    
    @Autowired
    private GetUsuarioService getUsuarioService;
    
    @Autowired
    private UpdateUsuarioService updateUsuarioService;
    
    @Autowired
    private LoginUsuarioService loginUsuarioService;

    //------------------- LOGIN -------------------
    @GetMapping("/")
    public String redirect() {
        return "redirect:/login";
    }
    

    @GetMapping("/login")
    public String login() {
        return "usuarios/login";
    }

    @PostMapping("/signIn")
    public String signIn(RedirectAttributes redirectAttributes, String username, String password) {
        if (username.trim().equals("") || password.trim().equals("")) {
            redirectAttributes.addFlashAttribute("error_message", "Os campos devem ser preenchidos");
            return "redirect:/login";
        }
        
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setLogin(username);
        usuario.setSenha(password);
        
        var result = this.loginUsuarioService.execute(usuario);
        
        if (result == null) {
            redirectAttributes.addFlashAttribute("error_message", "Usuário ou senha incorretos");
            return "redirect:/login";
        }

        return "redirect:/home";
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
        return "/ferramentas/ferramentas";
    }
    
    @GetMapping("ferramentas/remover/{id}")
    public String ferramentasRemover(@PathVariable Integer id) {
        this.deleteFerramentaService.execute(id);
        return "redirect:/ferramentas";
    }

    @GetMapping("ferramentas/adicionar")
    public String ferramentasNova() {
        return "/ferramentas/novaFerramenta";
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
        return "/ferramentas/editarFerramenta";
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
        return "/emprestimos/emprestimos";
    }
    
    //------------------- USUÁRIOS -------------------
    @GetMapping("usuarios")
    public String usuarios(Model model) {
        var result = this.listAllUsuariosService.execute();
        model.addAttribute("usuarios", result);
        return "/usuarios/usuarios";
    }

    @GetMapping("usuarios/remover/{id}")
    public String usuariosRemover(@PathVariable Integer id) {
        this.deleteUsuarioService.execute(id);
        return "redirect:/usuarios";
    }

    @GetMapping("usuarios/adicionar")
    public String usuarioNovo() {
        return "/usuarios/novoUsuario";
    }

    @PostMapping("usuarios/add")
    public String addUsuario(RedirectAttributes redirectAttributes, String nome, String login, String senha, Integer isAdmin) {
        if (nome.trim().equals("") || login.trim().equals("") || senha.trim().equals("")) {
            redirectAttributes.addFlashAttribute("error_message", "Todos os campos devem estar preenchidos");
            return "redirect:/usuarios/adicionar";
        }
        
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setIsAdmin(isAdmin);
        this.addUsuarioService.execute(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("usuarios/editar/{id}")
    public String editarUsuario(Model model, @PathVariable Integer id) {
        var result = this.getUsuarioService.execute(id);
        model.addAttribute("usuarios", result);
        return "/usuarios/editarUsuario";
    }

    @PostMapping("usuarios/update")
    public String updateUsuario(RedirectAttributes redirectAttributes, Integer idUsuario, String nome, String login, String senha, Integer isAdmin) {
        
        if (nome.trim().equals("") || login.trim().equals("") || senha.trim().equals("")) {
            redirectAttributes.addFlashAttribute("error_message", "Todos os campos devem estar preenchidos!");
            return "redirect:/usuarios/editar/" + idUsuario;
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(idUsuario);
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setIsAdmin(isAdmin);
        
        var result = this.updateUsuarioService.execute(usuario);

        return "redirect:/usuarios";
    }
}
