package com.fabrica_de_software.project_service.exceptions;

public class TransacaoInvalidaException extends RuntimeException {
    public TransacaoInvalidaException(String msg) {
        super(msg);
    }
}