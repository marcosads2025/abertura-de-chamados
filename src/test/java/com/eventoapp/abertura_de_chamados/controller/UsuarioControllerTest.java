package com.eventoapp.abertura_de_chamados.controller;

import com.eventoapp.abertura_de_chamados.dto.UsuarioRequestDTO;
import com.eventoapp.abertura_de_chamados.entity.Usuario;
import com.eventoapp.abertura_de_chamados.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// 1. IMPORTANTE: Adicionada a importação correta para o Spring Boot 3.5+
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

// Importações estáticas para deixar o código mais limpo
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc; // Ferramenta que simula as requisições HTTP

    @Autowired
    private ObjectMapper objectMapper; // Ferramenta para converter Objetos Java em JSON

    // 2. CORRIGIDO: Adicionada a anotação que faltava para criar o Mock no contexto do Spring
    @MockitoBean
    private UsuarioService usuarioService;

    @Test
    @DisplayName("Deve retornar status 201 e o usuário criado ao fazer POST")
    void deveCriarUsuario() throws Exception {
        // 1. Prepara os dados de entrada
        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setNome("João da Silva");
        dto.setEmail("joao@email.com");

        // 2. Prepara o que o Mock do Service deve devolver
        Usuario usuarioCriado = new Usuario();
        usuarioCriado.setNome("João da Silva");
        usuarioCriado.setEmail("joao@email.com");

        // Ensina o mock: "Quando chamarem o criar(), devolva o usuarioCriado"
        Mockito.when(usuarioService.criar(Mockito.any(UsuarioRequestDTO.class))).thenReturn(usuarioCriado);

        // 3. Executa a requisição e verifica os resultados
        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))) // Transforma o DTO em JSON
                .andExpect(status().isCreated()) // Espera Status 201
                .andExpect(jsonPath("$.nome").value("João da Silva"))
                .andExpect(jsonPath("$.email").value("joao@email.com"));
    }

    @Test
    @DisplayName("Deve retornar status 200 e uma lista de usuários ao fazer GET")
    void deveListarUsuarios() throws Exception {
        // 1. Prepara os dados
        UsuarioRequestDTO dto1 = new UsuarioRequestDTO();
        dto1.setNome("Maria");
        dto1.setEmail("maria@email.com");

        UsuarioRequestDTO dto2 = new UsuarioRequestDTO();
        dto2.setNome("Pedro");
        dto2.setEmail("pedro@email.com");

        // 2. Ensina o mock
        Mockito.when(usuarioService.listar()).thenReturn(List.of(dto1, dto2));

        // 3. Executa a requisição GET
        mockMvc.perform(get("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Espera Status 200
                .andExpect(jsonPath("$.length()").value(2)) // Espera que a lista tenha 2 itens
                .andExpect(jsonPath("$[0].nome").value("Maria")) // Verifica o primeiro item
                .andExpect(jsonPath("$[1].nome").value("Pedro")); // Verifica o segundo item
    }
}