package daw1.emprestimo_de_ferramentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    //----------------------- Nova ferramenta -----------------------
    @GetMapping("/get")
    public List<FerramentaEntity> getAllFerramentas() {
        return this.ferramentaService.getFerramentas();
    }

    //----------------------- Nova ferramenta -----------------------
    @PostMapping("/new")
    public ResponseEntity<Object> createFerramenta(@RequestBody FerramentaEntity ferramenta) {
        return ferramentaService.newFerramenta(ferramenta);

    }

    //----------------------- Atualizar ferramenta -----------------------
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateFerramentaById(@PathVariable Integer id, @RequestBody FerramentaEntity updatedFerramenta) {
        return this.ferramentaService.updateFerramenta(id, updatedFerramenta);
    }

    //----------------------- Deletar ferramenta -----------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteFerramentaById(@PathVariable Integer id) {
        return this.ferramentaService.deleteFerramenta(id);
    }

    //----------------------- Pegar ferramenta -----------------------
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getFerramentaById(@PathVariable Integer id) {
        return this.ferramentaService.getFerremantaById(id);
    }
}
