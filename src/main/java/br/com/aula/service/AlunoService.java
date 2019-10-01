package br.com.aula.service;

import java.util.List;

import br.com.aula.entity.Aluno;
import br.com.aula.entity.dto.AlunoRequestDTO;

/**
 * Interface de service
 * 
 * @author williams.gomes
 *
 */
public interface AlunoService {
	
	/**
	 * Busca todos os alunos
	 * 
	 * @return lista de alunos;
	 */
	List<Aluno> buscaTodosAlunos();
	
	/**
	 * Busca aluno pelo nome
	 * @param nome
	 * @return um aluno
	 */
	Aluno buscaPor(String nome);
	
	Aluno buscaAlunoPor(Long id);
	
	/**
	 * Remove um aluno;
	 * @param aluno
	 */
	void removeAlunoPor(Long id);
	
	/**
	 * Cria um aluno
	 * @param aluno
	 * @return Aluno
	 */
	Aluno cria(Aluno aluno);

	/**
	 * Ataliza aluno
	 * @param aluno
	 * @return aluno
	 */
	Aluno atualiza(Long id, AlunoRequestDTO dto);

}
