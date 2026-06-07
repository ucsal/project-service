package com.fabrica_de_software.project_service.producers;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import com.fabrica_de_software.project_service.dtos.AlunoDTO;
import com.fabrica_de_software.project_service.dtos.EmailDTO;

@Service
public class ProjetoEventProducer {
	private final RabbitTemplate rabbitTemplate;

	public ProjetoEventProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void enviarEmailEmAnalise(String emailProfessor) {
		rabbitTemplate.convertAndSend("fila.email", new EmailDTO(emailProfessor, null, "ANALISE", null));
	}

	public void enviarEmailAprovacao(String emailProfessor) {
		rabbitTemplate.convertAndSend("fila.email", new EmailDTO(emailProfessor, null, "APROVACAO", null));
	}

	public void enviarEmailCancelamento(String emailProfessor) {
		rabbitTemplate.convertAndSend("fila.email", new EmailDTO(emailProfessor, null, "CANCELAMENTO", null));
	}

	public void enviarEmailCadastro(String emailProfessor, String ra) {
		rabbitTemplate.convertAndSend("fila.email", new EmailDTO(emailProfessor, ra, "CADASTRO", null));
	}

	public void enviarEmailGrupo(String emailProfessor, List<AlunoDTO> alunos) {
		rabbitTemplate.convertAndSend("fila.email", new EmailDTO(emailProfessor, null, "GRUPO_CRIADO", alunos));
	}

}