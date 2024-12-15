package daw1.emprestimo_de_ferramentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;

public interface FerramentaRepository extends JpaRepository<FerramentaEntity, Integer> {}
