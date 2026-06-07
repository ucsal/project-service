package com.fabrica_de_software.project_service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabrica_de_software.project_service.entities.Projeto;
import com.fabrica_de_software.project_service.enums.StatusProjeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    
    List<Projeto> findByStatus(StatusProjeto status);
   
    List<Projeto> findByProfessorId(Long professorId);
    
}