package com.fabrica_de_software.project_service.dtos;

public class NotificacaoDTO {
    
    private Long professorId;
    private String tipoEvento;

    public NotificacaoDTO() {}

    public NotificacaoDTO(Long professorId, String tipoEvento) {
        this.professorId = professorId;
        this.tipoEvento = tipoEvento;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}