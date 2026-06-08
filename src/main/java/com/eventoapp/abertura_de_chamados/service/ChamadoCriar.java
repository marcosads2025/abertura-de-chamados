// PACOTE DA CLASSE
package com.eventoapp.abertura_de_chamados.service;

// IMPORTS NECESSÁRIOS

import com.eventoapp.abertura_de_chamados.dto.ChamadoRequestDTO;
import com.eventoapp.abertura_de_chamados.entity.Chamado;
import com.eventoapp.abertura_de_chamados.entity.Usuario;
import com.eventoapp.abertura_de_chamados.exception.RegraDeNegocioException;
import com.eventoapp.abertura_de_chamados.repository.ChamadoRepository;
import com.eventoapp.abertura_de_chamados.repository.UsuarioRepository;
import com.eventoapp.abertura_de_chamados.unums.StatusChamado;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service // CORREÇÃO: indica ao Spring que esta é uma classe de serviço
public class ChamadoCriar {

    // CORREÇÃO: repositórios declarados como atributos da classe
    private final UsuarioRepository usuarioRepository;
    private final ChamadoRepository chamadoRepository;

    // CORREÇÃO: construtor para injeção de dependência
    public ChamadoCriar(
            UsuarioRepository usuarioRepository,
            ChamadoRepository chamadoRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.chamadoRepository = chamadoRepository;
    }

    // CORREÇÃO: método agora está dentro de uma classe
    @Transactional
    public Chamado criar(ChamadoRequestDTO dto) {

        // Busca o usuário pelo ID enviado no DTO
        Usuario usuario =
                usuarioRepository.findById(dto.getUsuarioId())
                        .orElseThrow(() ->
                                new RegraDeNegocioException(
                                        "Usuário não encontrado"
                                ));

        // Cria um novo chamado
        Chamado chamado = new Chamado();

        // Preenche os dados do chamado
        chamado.setTitulo(dto.getTitulo());
        chamado.setDescricao(dto.getDescricao());
        chamado.setPrioridade(dto.getPrioridade());

        // Define status inicial
        chamado.setStatus(StatusChamado.ABERTO);

        // Define data atual
        chamado.setDataAbertura(LocalDateTime.now());

        // Associa o usuário ao chamado
        chamado.setUsuario(usuario);

        // Salva no banco e retorna o objeto salvo
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> listar() {
        return chamadoRepository.findAll();
    }

    public Chamado buscarPorId(Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Chamado não encontrado: " + id));
    }

    public void excluir(Long id) {
        Chamado chamado = buscarPorId(id);
        chamadoRepository.delete(chamado);
    }

}