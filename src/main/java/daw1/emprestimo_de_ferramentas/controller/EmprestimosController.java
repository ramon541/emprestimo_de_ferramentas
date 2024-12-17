package daw1.emprestimo_de_ferramentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;
import daw1.emprestimo_de_ferramentas.services.UsuarioService;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/emprestimos")
public class EmprestimosController {
    
    // private final Emprestimo usuarioService;

    // @Autowired
    // public UsuariosController(UsuarioService usuarioService) {
    //     this.usuarioService = usuarioService;
    // }

    // //----------------------- Pegar usuarios -----------------------
    // @GetMapping("/get")
    // public List<UsuarioEntity> getAllUsuarios() {
    //     return this.usuarioService.getUsuarios();
    // }

    // //----------------------- Novo usuario -----------------------
    // @PostMapping("/new")
    // public ResponseEntity<Object> createUsuario(@RequestBody UsuarioEntity usuario) {
    //     return usuarioService.newUsuario(usuario);

    // }

    // //----------------------- Atualizar usuario -----------------------
    // @PutMapping("/update/{id}")
    // public ResponseEntity<Object> updateUsuarioById(@PathVariable Integer id, @RequestBody UsuarioEntity updatedUsuario) {
    //     return this.usuarioService.updateUsuario(id, updatedUsuario);
    // }

    // //----------------------- Deletar usuario -----------------------
    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<Object> deleteUsuarioById(@PathVariable Integer id) {
    //     return this.usuarioService.deleteUsuario(id);
    // }

    // //----------------------- Pegar usuario -----------------------
    // @GetMapping("/get/{id}")
    // public ResponseEntity<Object> getUsuarioById(@PathVariable Integer id) {
    //     return this.usuarioService.getUsuarioById(id);
    // }
}
