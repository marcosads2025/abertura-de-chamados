package com.eventoapp.abertura_de_chamados.repository;

import com.eventoapp.abertura_de_chamados.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
    extends JpaRepository<Usuario, Long>



{


}