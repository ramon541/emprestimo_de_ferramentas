package daw1.emprestimo_de_ferramentas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;
import daw1.emprestimo_de_ferramentas.repository.FerramentaRepository;

@Service
public class FerramentaService {

    private final FerramentaRepository ferramentaRepository;

    @Autowired
    public FerramentaService(FerramentaRepository ferramentaRepository) {
        this.ferramentaRepository = ferramentaRepository;
    }

    public ResponseEntity<Object> newFerramenta(FerramentaEntity ferramenta) {
        ferramentaRepository.save(ferramenta);

        return new ResponseEntity<>(ferramenta, HttpStatus.CREATED);
    }
    
    
}
