package com.eventoapp.abertura_de_chamados.controller;
import com.eventoapp.abertura_de_chamados.dto.ComentarioDTO;
import com.eventoapp.abertura_de_chamados.entity.Comentario;
import com.eventoapp.abertura_de_chamados.service.ComentarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(
            ComentarioService service
    ) {
        this.service = service;
    }

    @PostMapping("/chamado/{id}")
    public Comentario adicionar(
            @PathVariable Long id,
            @RequestBody ComentarioDTO dto
    ) {
        return service.adicionar(id, dto);
    }

}