package com.fabrica_de_software.project_service.dtos;

import com.fabrica_de_software.project_service.enums.StatusProjeto;

public class ProjetoStatusRequestDTO {
    
    private long projetoId;
    private StatusProjeto status;

    public ProjetoStatusRequestDTO() {}

    public long getProjetoId() { 
        return projetoId; 
    }
    
    public void setProjetoId(long projetoId) { 
        this.projetoId = projetoId; 
    }
    
    public StatusProjeto getStatus() { 
        return status; 
    }
    
    public void setStatus(StatusProjeto status) { 
        this.status = status; 
    }
}