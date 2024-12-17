package daw1.emprestimo_de_ferramentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {}
