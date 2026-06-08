package com.eventoapp.abertura_de_chamados.dto;

import com.eventoapp.abertura_de_chamados.unums.Prioridade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoRequestDTO {

    private String titulo;

    private String descricao;

    private Prioridade prioridade;

    private Long usuarioId;
}