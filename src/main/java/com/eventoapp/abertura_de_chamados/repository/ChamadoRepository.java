package com.eventoapp.abertura_de_chamados.repository;

import com.eventoapp.abertura_de_chamados.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {


}