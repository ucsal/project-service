package com.fabrica_de_software.project_service.exceptions;

public class ProjetoNaoEncontradoException extends RuntimeException {
    public ProjetoNaoEncontradoException(String msg) {
        super(msg);
    }
}