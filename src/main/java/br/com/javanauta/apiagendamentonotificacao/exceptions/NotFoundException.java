package br.com.javanauta.apiagendamentonotificacao.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
