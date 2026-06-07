package com.fabrica_de_software.project_service.dtos;

import java.time.LocalDate;
import com.fabrica_de_software.project_service.enums.StatusProjeto;

public class ProjetoResponseDTO {
    
    private long id;
    private String titulo;
    private String objetivo;
    private String perfilUsuarios;
    private String localUtilizacao;
    private String funcionalidades;
    private String demanda;
    private LocalDate dataInicio;
    private Long professorId;
    private boolean temGrupo;
    private StatusProjeto status;

    public ProjetoResponseDTO() {}

    private ProjetoResponseDTO(Builder b) {
        this.id = b.id;
        this.titulo = b.titulo;
        this.objetivo = b.objetivo;
        this.perfilUsuarios = b.perfilUsuarios;
        this.localUtilizacao = b.localUtilizacao;
        this.funcionalidades = b.funcionalidades;
        this.demanda = b.demanda;
        this.dataInicio = b.dataInicio;
        this.professorId = b.professorId;
        this.temGrupo = b.temGrupo;
        this.status = b.status;
    }

    public long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getObjetivo() { return objetivo; }
    public String getPerfilUsuarios() { return perfilUsuarios; }
    public String getLocalUtilizacao() { return localUtilizacao; }
    public String getFuncionalidades() { return funcionalidades; }
    public String getDemanda() { return demanda; }
    public LocalDate getDataInicio() { return dataInicio; }
    public Long getProfessorId() { return professorId; }
    public boolean isTemGrupo() { return temGrupo; }
    public StatusProjeto getStatus() { return status; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private long id;
        private String titulo;
        private String objetivo;
        private String perfilUsuarios;
        private String localUtilizacao;
        private String funcionalidades;
        private String demanda;
        private LocalDate dataInicio;
        private Long professorId;
        private boolean temGrupo;
        private StatusProjeto status;

        public Builder() {}

        public Builder id(long id) { this.id = id; return this; }
        public Builder titulo(String titulo) { this.titulo = titulo; return this; }
        public Builder objetivo(String objetivo) { this.objetivo = objetivo; return this; }
        public Builder perfilUsuarios(String perfilUsuarios) { this.perfilUsuarios = perfilUsuarios; return this; }
        public Builder localUtilizacao(String localUtilizacao) { this.localUtilizacao = localUtilizacao; return this; }
        public Builder funcionalidades(String funcionalidades) { this.funcionalidades = funcionalidades; return this; }
        public Builder demanda(String demanda) { this.demanda = demanda; return this; }
        public Builder dataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; return this; }
        public Builder professorId(Long professorId) { this.professorId = professorId; return this; }
        public Builder temGrupo(boolean temGrupo) { this.temGrupo = temGrupo; return this; }
        public Builder status(StatusProjeto status) { this.status = status; return this; }

        public ProjetoResponseDTO build() { return new ProjetoResponseDTO(this); }
    }

	
}