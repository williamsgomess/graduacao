package br.com.aula.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.aula.entity.Aluno;

public class AlunoResponseDto {

	private Long id;
	private String nome;
	private String matricula;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@JsonIgnore
	public static AlunoResponseDto getDtoFrom(Aluno aluno) {

		AlunoResponseDto dto = new AlunoResponseDto();
		dto.setId(aluno.getId());
		dto.setNome(aluno.getNome());
		dto.setMatricula(aluno.getMatricula());

		return dto;
	}

}
