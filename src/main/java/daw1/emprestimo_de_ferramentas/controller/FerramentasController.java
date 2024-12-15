package daw1.emprestimo_de_ferramentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;
import daw1.emprestimo_de_ferramentas.repository.FerramentaRepository;
import daw1.emprestimo_de_ferramentas.services.FerramentaService;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/ferramentas")
public class FerramentasController {
    
    private final FerramentaService ferramentaService;

    @Autowired
    public FerramentasController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createFerramenta(@RequestBody FerramentaEntity ferramenta) {
        return ferramentaService.newFerramenta(ferramenta);

    }

}
