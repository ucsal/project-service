package com.fabrica_de_software.project_service.services;

import org.springframework.stereotype.Service;

import com.fabrica_de_software.project_service.enums.StatusProjeto;
import com.fabrica_de_software.project_service.exceptions.TransacaoInvalidaException;

@Service
public class ValidarStatusService {

    public void validarTransacao(StatusProjeto atual, StatusProjeto novo) {
        if (atual == StatusProjeto.SOLICITADO && novo != StatusProjeto.EM_ANALISE) {
            throw new TransacaoInvalidaException("Transição inválida!");
        }

        if (atual == StatusProjeto.EM_ANALISE && (novo != StatusProjeto.APROVADO && novo != StatusProjeto.CANCELADO)) {
            throw new TransacaoInvalidaException("Transição inválida!");
        }

        if (atual == StatusProjeto.APROVADO || atual == StatusProjeto.CANCELADO) {
            throw new TransacaoInvalidaException("Projeto já finalizado!");
        }
    }
}