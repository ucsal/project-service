package com.fabrica_de_software.project_service.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica_de_software.project_service.dtos.MensagemDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoRequestDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoResponseDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoStatusRequestDTO;
import com.fabrica_de_software.project_service.enums.StatusProjeto;
import com.fabrica_de_software.project_service.services.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	private final ProjetoService projetoService;

	public ProjetoController(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}

	@PostMapping("/envio/{id}")
	public ResponseEntity<MensagemDTO> solicitarProjeto(@RequestBody ProjetoRequestDTO request,
			@PathVariable("id") Long professorId) {
		MensagemDTO mensagem = projetoService.solicitarProjeto(request, professorId);
		return ResponseEntity.ok(mensagem);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<ProjetoResponseDTO>> listarProjetos(@RequestParam StatusProjeto status) {
		List<ProjetoResponseDTO> projetos = projetoService.listarProjetos(status);
		return ResponseEntity.ok(projetos);
	}

	@GetMapping("/professor/{id}")
	public ResponseEntity<List<ProjetoResponseDTO>> listarProjetosProfessor(@PathVariable("id") Long professorId) {
		List<ProjetoResponseDTO> projetos = projetoService.listarProjetosProfessor(professorId);
		return ResponseEntity.ok(projetos);
	}

	@PatchMapping("/status")
	public ResponseEntity<MensagemDTO> atualizarStatus(@RequestBody ProjetoStatusRequestDTO request) {
		MensagemDTO mensagem = projetoService.atualizarStatus(request);
		return ResponseEntity.ok(mensagem);
	}
}