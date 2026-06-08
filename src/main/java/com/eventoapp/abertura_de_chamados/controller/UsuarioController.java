package com.eventoapp.abertura_de_chamados.controller;

import com.eventoapp.abertura_de_chamados.dto.UsuarioRequestDTO;
import com.eventoapp.abertura_de_chamados.entity.Usuario;
import com.eventoapp.abertura_de_chamados.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // 1. É ESTA LINHA QUE ESTAVA FALTANDO! Ela declara e injeta o UsuarioService.
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioRequestDTO dto) {
        // 2. Corrigido aqui também: usando usuarioService em vez de chamadoService
        Usuario usuarioCriado = usuarioService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRequestDTO>> listar() {
        // Agora o usuarioService já existe lá em cima e não ficará mais vermelho!
        List<UsuarioRequestDTO> listaDeUsuarios = usuarioService.listar();

        return ResponseEntity.ok(listaDeUsuarios);
    }
}