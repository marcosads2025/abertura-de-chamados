package com.eventoapp.abertura_de_chamados.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "comentarios")

public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private LocalDateTime dataComentatio;

    @ManyToOne
    @JoinColumn(name = "chamado_id")
    private Chamado chamado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataComentatio() {
        return dataComentatio;
    }

    public void setDataComentatio(LocalDateTime dataComentatio) {
        this.dataComentatio = dataComentatio;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
}
