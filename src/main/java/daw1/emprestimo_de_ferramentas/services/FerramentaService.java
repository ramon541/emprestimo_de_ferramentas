package daw1.emprestimo_de_ferramentas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    
    public List<FerramentaEntity> getFerramentas() {
        return this.ferramentaRepository.findAll(Sort.by(Sort.Direction.ASC, "idFerramenta"));
    }

    public ResponseEntity<Object> updateFerramenta(Integer id, FerramentaEntity updatedFerramenta) {
        Optional<FerramentaEntity> ferramentaOptional = ferramentaRepository.findById(id);

        if (!ferramentaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        FerramentaEntity existingFerramenta = ferramentaOptional.get();

        existingFerramenta.setNome(updatedFerramenta.getNome());

        ferramentaRepository.save(existingFerramenta);

        return ResponseEntity.ok(existingFerramenta);
    }

    public ResponseEntity<Object> deleteFerramenta(Integer id) {
        Optional<FerramentaEntity> ferramentaOptional = ferramentaRepository.findById(id);
        
        if (!ferramentaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ferramentaRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> getFerremantaById(Integer id) {
        Optional<FerramentaEntity> ferramentaOptional = ferramentaRepository.findById(id);
        
        if (!ferramentaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        FerramentaEntity ferramenta = ferramentaOptional.get();

        return ResponseEntity.ok(ferramenta);
    }
}
