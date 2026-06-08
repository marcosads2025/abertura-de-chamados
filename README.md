# 🚀 Sistema de Abertura de Chamados

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![JUnit](https://img.shields.io/badge/JUnit-5-success)
![Mockito](https://img.shields.io/badge/Mockito-Testing-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-red)

---

## 📋 Sobre o Projeto

O Sistema de Abertura de Chamados é uma API REST desenvolvida com Java e Spring Boot para gerenciamento de solicitações de suporte técnico.

O projeto foi construído seguindo boas práticas de desenvolvimento Back-End, arquitetura em camadas e princípios da Programação Orientada a Objetos, simulando um ambiente corporativo de Service Desk.

Além das funcionalidades de negócio, o projeto conta com uma suíte de testes automatizados utilizando JUnit 5 e Mockito, garantindo maior confiabilidade e qualidade do código.

---

## 🎯 Objetivos do Projeto

* Aplicar conceitos de Programação Orientada a Objetos (POO)
* Desenvolver APIs REST com Spring Boot
* Trabalhar com persistência de dados utilizando JPA/Hibernate
* Implementar operações CRUD completas
* Aplicar tratamento de exceções
* Simular regras de negócio de um sistema real de suporte técnico
* Desenvolver testes unitários automatizados
* Utilizar boas práticas de desenvolvimento Back-End

---

## 🛠 Tecnologias Utilizadas

### Back-End

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

### Testes

* JUnit 5
* Mockito
* Spring Boot Test

### Ferramentas

* Postman
* Git
* GitHub
* IntelliJ IDEA

---

## 📂 Arquitetura do Projeto

A aplicação segue uma arquitetura em camadas para promover organização, manutenção e escalabilidade.

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Estrutura de Pacotes

```text
src/main/java
│
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── enums
└── config
```

---

## ⚙️ Funcionalidades

### 👤 Usuários

* Cadastrar usuário
* Buscar usuário por ID
* Listar usuários
* Atualizar usuário
* Excluir usuário

### 🎫 Chamados

* Abrir chamado
* Buscar chamado por ID
* Listar chamados
* Atualizar chamado
* Alterar status
* Encerrar chamado
* Relacionar chamado a usuário

---

## 📡 Endpoints Principais

### Usuários

| Método | Endpoint       |
| ------ | -------------- |
| POST   | /usuarios      |
| GET    | /usuarios      |
| GET    | /usuarios/{id} |
| PUT    | /usuarios/{id} |
| DELETE | /usuarios/{id} |

### Chamados

| Método | Endpoint       |
| ------ | -------------- |
| POST   | /chamados      |
| GET    | /chamados      |
| GET    | /chamados/{id} |
| PUT    | /chamados/{id} |
| DELETE | /chamados/{id} |

---

## 💾 Banco de Dados

### Usuário

```java
public class Usuario {

    private Long id;
    private String nome;
    private String email;

}
```

### Chamado

```java
public class Chamado {

    private Long id;
    private String titulo;
    private String descricao;
    private String status;

}
```

### Relacionamento

```text
Usuario
   │
   │ 1
   │
   │ N
Chamado
```

Um usuário pode possuir vários chamados cadastrados no sistema.

---

## 🧪 Testes Automatizados

O projeto possui testes unitários desenvolvidos com JUnit 5 e Mockito.

### Objetivos dos Testes

* Validar regras de negócio
* Garantir comportamento esperado dos Services
* Simular dependências utilizando Mock Objects
* Evitar regressões durante evoluções do sistema

### Tecnologias Utilizadas

* JUnit 5
* Mockito
* Spring Boot Test

### Exemplo de Teste com Mockito

```java
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveBuscarUsuarioPorId() {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Marcos");

        when(repository.findById(1L))
                .thenReturn(Optional.of(usuario));

        Usuario resultado =
                service.buscarPorId(1L);

        assertEquals("Marcos",
                resultado.getNome());
    }
}
```

### Cobertura dos Testes

* Cadastro de usuários
* Busca de usuários
* Atualização de usuários
* Exclusão de usuários
* Cadastro de chamados
* Regras de negócio dos chamados
* Tratamento de exceções

---

## 🚀 Como Executar o Projeto

### Clonar Repositório

```bash
git clone https://github.com/marcosads2025/abertura-de-chamados.git
```

### Entrar na Pasta

```bash
cd abertura-de-chamados
```

### Configurar Banco

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chamados
spring.datasource.username=root
spring.datasource.password=sua_senha
```

### Executar Aplicação

```bash
mvn spring-boot:run
```

---

## ▶ Executar os Testes

Executar todos os testes:

```bash
mvn test
```

Executar com relatório:

```bash
mvn clean test
```

---

## 📚 Conceitos Aplicados

* Programação Orientada a Objetos
* Injeção de Dependência
* DTO Pattern
* Repository Pattern
* Service Layer Pattern
* REST API
* Tratamento Global de Exceções
* Arquitetura em Camadas
* Testes Unitários
* Mock Objects com Mockito
* Boas Práticas com Spring Boot

---

## 🔮 Melhorias Futuras

* Spring Security
* JWT Authentication
* Swagger/OpenAPI
* Paginação
* Filtros avançados
* Docker
* Testes de Integração
* CI/CD com GitHub Actions
* Deploy em Cloud

---

## 👨‍💻 Autor

### Marcos Silva

Desenvolvedor Back-End Java em formação, focado em Java, Spring Boot, APIs REST e Testes Automatizados.

### Contato

GitHub:
https://github.com/marcosads2025

LinkedIn:
(adicionar link)

---

⭐ Projeto desenvolvido para prática de desenvolvimento Back-End, aplicação de regras de negócio e implementação de testes automatizados com JUnit 5 e Mockito.
