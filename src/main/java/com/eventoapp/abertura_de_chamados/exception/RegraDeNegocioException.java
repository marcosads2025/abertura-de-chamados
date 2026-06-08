package com.eventoapp.abertura_de_chamados.exception;

public class RegraDeNegocioException extends RuntimeException {

    // Construtor original sem argumentos (opcional manter, mas é uma boa prática)
    public RegraDeNegocioException() {
        super("Regra de NegocioException");
    }

    // NOVO CONSTRUTOR: Recebe a mensagem personalizada e repassa para o RuntimeException
    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}