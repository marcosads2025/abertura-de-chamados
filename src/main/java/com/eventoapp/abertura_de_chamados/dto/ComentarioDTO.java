package com.eventoapp.abertura_de_chamados.dto;

import lombok.Data;

@Data
public class ComentarioDTO {

    private String texto;
    private Long usuarioId;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
