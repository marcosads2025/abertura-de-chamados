package com.eventoapp.abertura_de_chamados.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean ativo;
    private LocalDateTime dataCadastro;

    @PrePersist
    public void criarData(){
        dataCadastro = LocalDateTime.now();

                ativo = true;
    }

    public void setRole(com.eventoapp.abertura_de_chamados.unums.Role role) {
    }
}
