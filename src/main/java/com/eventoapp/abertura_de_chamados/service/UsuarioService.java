package com.eventoapp.abertura_de_chamados.service;

import com.eventoapp.abertura_de_chamados.dto.UsuarioRequestDTO;
import com.eventoapp.abertura_de_chamados.entity.Usuario;
import com.eventoapp.abertura_de_chamados.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        return repository.save(usuario);
    }

    public List<UsuarioRequestDTO> listar() {
        var collect = repository.findAll().stream()
                .map(UsuarioRequestDTO::new) // Chama o construtor que criamos no DTO
                .collect(Collectors.toList());
        return collect;
    }
}