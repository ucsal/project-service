package com.fabrica_de_software.project_service.dtos;

import java.time.LocalDateTime;

public class MensagemDTO {

    private String mensagem;
    private LocalDateTime dataHora;

    public MensagemDTO(String mensagem, LocalDateTime dataHora) {
        this.mensagem = mensagem;
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}