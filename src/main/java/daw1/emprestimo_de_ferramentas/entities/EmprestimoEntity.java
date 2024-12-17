package daw1.emprestimo_de_ferramentas.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "EMPRESTIMOS")
@Data
public class EmprestimoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprestimo;

    @ManyToOne()
    @JoinColumn(name = "FK_IDUSUARIO", insertable = false, updatable = false)
    private UsuarioEntity usuario;

    @Column(name = "FK_IDUSUARIO")
    private Integer FkIdUsuario;

    @ManyToOne()
    @JoinColumn(name = "FK_IDFERRAMENTA", insertable = false, updatable = false)
    private FerramentaEntity ferramenta;

    @Column(name = "FK_IDFERRAMENTA")
    private Integer FkIdFerramenta;

    private LocalDateTime dtDevolucao;

    private Integer isDevolvido;
}
