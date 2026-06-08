package com.eventoapp.abertura_de_chamados.controller;

import com.eventoapp.abertura_de_chamados.dto.ChamadoRequestDTO;
import com.eventoapp.abertura_de_chamados.entity.Chamado;
import com.eventoapp.abertura_de_chamados.service.ChamadoCriar;
import com.eventoapp.abertura_de_chamados.service.ChamadoCriar;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private final ChamadoCriar chamadoService;

    public ChamadoController(
            ChamadoCriar chamadoService
    ) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    public Chamado criar(
            @Valid @RequestBody ChamadoRequestDTO dto
    ) {
        return chamadoService.criar(dto);
    }

    @GetMapping
    public List<Chamado> listar() {
        return chamadoService.listar();
    }

    @GetMapping("/{id}")
    public Chamado buscarPorId(
            @PathVariable Long id
    ) {
        return chamadoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(
            @PathVariable Long id
    ) {
        chamadoService.excluir(id);
    }

}