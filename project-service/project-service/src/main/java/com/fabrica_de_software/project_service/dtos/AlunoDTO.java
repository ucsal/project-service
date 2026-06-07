package com.fabrica_de_software.project_service.dtos;

public class AlunoDTO {
	private Long id;
	private String nome;
	private String ra;
	private String telefone;
	private String email;

	public AlunoDTO() {
		super();
	}

	public AlunoDTO(Long id, String nome, String ra, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.ra = ra;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase().trim();
	}

}
