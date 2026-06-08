package com.eventoapp.abertura_de_chamados.entity;

import com.eventoapp.abertura_de_chamados.unums.Prioridade;
import com.eventoapp.abertura_de_chamados.unums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="chamados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Chamado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusChamado status;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;

    @ManyToOne
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;

    public void setPrioridade(Prioridade prioridade) {
    }
}
