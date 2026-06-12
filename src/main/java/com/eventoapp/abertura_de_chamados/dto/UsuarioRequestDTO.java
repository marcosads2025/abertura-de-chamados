package com.eventoapp.abertura_de_chamados.dto;

// 1. IMPORTANTE: Adicione o import da sua entidade Usuario
import com.eventoapp.abertura_de_chamados.entity.Usuario;

public class UsuarioRequestDTO {

    private String nome;
    private String email;
    private String senha;

    // Construtor vazio (mantido)
    public UsuarioRequestDTO() {
    }

    // 2. 👉 O CONSTRUTOR QUE FALTAVA 👈
    public UsuarioRequestDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
}