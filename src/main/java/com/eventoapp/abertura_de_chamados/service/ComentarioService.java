package com.eventoapp.abertura_de_chamados.service;

import com.eventoapp.abertura_de_chamados.dto.ComentarioDTO;
import com.eventoapp.abertura_de_chamados.entity.Comentario;
import com.eventoapp.abertura_de_chamados.entity.Chamado;
import com.eventoapp.abertura_de_chamados.entity.Usuario;
import com.eventoapp.abertura_de_chamados.repository.ChamadoRepository;
import com.eventoapp.abertura_de_chamados.repository.ComentarioRepository;
import com.eventoapp.abertura_de_chamados.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor // O Lombok cria o construtor com os atributos 'final' automaticamente
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final ChamadoRepository chamadoRepository;

    public Comentario adicionar(Long chamadoId, ComentarioDTO dto) {

        // 1. Buscar o Chamado correto pelo chamadoId
        Chamado chamado = chamadoRepository.findById(chamadoId)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado com o ID: " + chamadoId));

        // 2. Buscar o Usuário (Assumindo que o ID vem no DTO. Se não vier, precisa ajustar)
        // Se o ComentarioDTO não tiver getUsuarioId(), você precisará passar o usuarioId como parâmetro do método.
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        // 3. Montar e salvar o comentário
        Comentario comentario = new Comentario();
        comentario.setTexto(dto.getTexto());
        comentario.setUsuario(usuario);
        comentario.setChamado(chamado); // Agora a variável 'chamado' existe
        comentario.setDataComentario(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }
}