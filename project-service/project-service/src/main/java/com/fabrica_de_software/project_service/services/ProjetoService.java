package com.fabrica_de_software.project_service.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fabrica_de_software.project_service.dtos.MensagemDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoRequestDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoResponseDTO;
import com.fabrica_de_software.project_service.dtos.ProjetoStatusRequestDTO;
import com.fabrica_de_software.project_service.entities.Projeto;
import com.fabrica_de_software.project_service.enums.StatusProjeto;
import com.fabrica_de_software.project_service.exceptions.ProjetoNaoEncontradoException;
import com.fabrica_de_software.project_service.feign.ProfessorClient;
import com.fabrica_de_software.project_service.producers.ProjetoEventProducer;
import com.fabrica_de_software.project_service.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	private final ProjetoRepository projetoRepository;
	private final ValidarStatusService validarStatusService;
	private final ProjetoEventProducer projetoEventProducer;
	private final ProfessorClient professorClient;

	public ProjetoService(ProjetoRepository projetoRepository, ValidarStatusService validarStatusService,
			ProjetoEventProducer projetoEventProducer, ProfessorClient professorClient) {
		this.projetoRepository = projetoRepository;
		this.validarStatusService = validarStatusService;
		this.projetoEventProducer = projetoEventProducer;
		this.professorClient = professorClient;
	}

	public MensagemDTO solicitarProjeto(ProjetoRequestDTO request, Long professorId) {
		Projeto projeto = new Projeto(request.getTitulo(), request.getObjetivo(), request.getPerfilUsuarios(),
				request.getLocalUtilizacao(), request.getFuncionalidades(), request.getDemanda(),
				request.getDataInicio(), null, professorId, StatusProjeto.SOLICITADO, false);

		projetoRepository.save(projeto);
		return new MensagemDTO("Projeto solicitado com sucesso!", LocalDateTime.now());
	}

	public List<ProjetoResponseDTO> listarProjetos(StatusProjeto status) {
		return projetoRepository.findByStatus(status).stream()
				.map(p -> ProjetoResponseDTO.builder().id(p.getId()).titulo(p.getTitulo()).objetivo(p.getObjetivo())
						.perfilUsuarios(p.getPerfilUsuarios()).localUtilizacao(p.getLocalUtilizacao())
						.funcionalidades(p.getFuncionalidades()).demanda(p.getDemanda()).dataInicio(p.getDataInicio())
						.professorId(p.getProfessorId()).temGrupo(p.isTemGrupo()).status(p.getStatus()).build())
				.toList();
	}

	public List<ProjetoResponseDTO> listarProjetosProfessor(Long professorId) {
		return projetoRepository.findByProfessorId(professorId).stream()
				.map(p -> ProjetoResponseDTO.builder().id(p.getId()).titulo(p.getTitulo()).objetivo(p.getObjetivo())
						.perfilUsuarios(p.getPerfilUsuarios()).localUtilizacao(p.getLocalUtilizacao())
						.funcionalidades(p.getFuncionalidades()).demanda(p.getDemanda()).dataInicio(p.getDataInicio())
						.professorId(p.getProfessorId()).temGrupo(p.isTemGrupo()).status(p.getStatus()).build())
				.toList();
	}

	public MensagemDTO atualizarStatus(ProjetoStatusRequestDTO request) {
		Projeto projeto = projetoRepository.findById(request.getProjetoId())
				.orElseThrow(() -> new ProjetoNaoEncontradoException("Projeto não encontrado!"));

		StatusProjeto atual = projeto.getStatus();
		StatusProjeto novo = request.getStatus();

		validarStatusService.validarTransacao(atual, novo);

		switch (request.getStatus()) {
		case EM_ANALISE:
			projeto.setStatus(StatusProjeto.EM_ANALISE);
			projetoEventProducer
					.enviarEmailEmAnalise(professorClient.buscarProfessor(projeto.getProfessorId()).getEmail());
			break;
		case APROVADO:
			projeto.setStatus(StatusProjeto.APROVADO);
			projeto.setDataAprovacao(LocalDate.now());
			projetoEventProducer
					.enviarEmailAprovacao(professorClient.buscarProfessor(projeto.getProfessorId()).getEmail());
			break;
		case CANCELADO:
			projeto.setStatus(StatusProjeto.CANCELADO);
			projetoEventProducer
					.enviarEmailCancelamento(professorClient.buscarProfessor(projeto.getProfessorId()).getEmail());
			break;
		default:
			break;
		}

		projetoRepository.save(projeto);
		return new MensagemDTO("Projeto atualizado com sucesso!", LocalDateTime.now());
	}
}