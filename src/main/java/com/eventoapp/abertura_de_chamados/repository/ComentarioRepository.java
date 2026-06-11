package com.eventoapp.abertura_de_chamados.repository;

import com.eventoapp.abertura_de_chamados.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository

        extends JpaRepository<Comentario, Long> {

    List<Comentario> findByChamadoId(Long chamadoId);


}
