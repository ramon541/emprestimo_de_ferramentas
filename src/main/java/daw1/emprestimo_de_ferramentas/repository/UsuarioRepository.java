package daw1.emprestimo_de_ferramentas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("SELECT u FROM UsuarioEntity u WHERE u.login = ?1 AND u.senha = ?2")
    Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha);
}
