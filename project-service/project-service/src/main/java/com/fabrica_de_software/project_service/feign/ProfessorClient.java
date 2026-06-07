package com.fabrica_de_software.project_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fabrica_de_software.project_service.dtos.ProfessorDTO;

@FeignClient(name = "academic-service")
public interface ProfessorClient {
	
	@GetMapping("/professor/{id}")
	public ProfessorDTO buscarProfessor(@PathVariable("id") long id);

}
