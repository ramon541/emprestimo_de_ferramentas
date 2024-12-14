package daw1.emprestimo_de_ferramentas.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "FERRAMENTAS")
@Data
public class FerramentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "IDFERRAMENTA")
    private  UUID idFerramenta;
    
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
}
