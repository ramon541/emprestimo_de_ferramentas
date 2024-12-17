package daw1.emprestimo_de_ferramentas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;
import daw1.emprestimo_de_ferramentas.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<Object> newUsuario(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
    
    public List<UsuarioEntity> getUsuarios() {
        return this.usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "idUsuario"));
    }

    public ResponseEntity<Object> updateUsuario(Integer id, UsuarioEntity updatedUsuario) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        UsuarioEntity existingUsuario = usuarioOptional.get();

        existingUsuario.setNome(updatedUsuario.getNome());

        usuarioRepository.save(existingUsuario);

        return ResponseEntity.ok(existingUsuario);
    }

    public ResponseEntity<Object> deleteUsuario(Integer id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);
        
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> getUsuarioById(Integer id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(id);
        
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        UsuarioEntity usuario = usuarioOptional.get();

        return ResponseEntity.ok(usuario);
    }
}
