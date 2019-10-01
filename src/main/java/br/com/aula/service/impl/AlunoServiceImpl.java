package br.com.aula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.entity.Aluno;
import br.com.aula.entity.dto.AlunoRequestDTO;
import br.com.aula.repository.AlunoRepository;
import br.com.aula.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	

	@Override
	public List<Aluno> buscaTodosAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno buscaPor(String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	@Override
	public Aluno buscaAlunoPor(Long id) {
		return alunoRepository.findById(id).get();
	}

	@Override
	public void removeAlunoPor(Long id) {
		alunoRepository.deleteById(id);
	}

	@Override
	public Aluno cria(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno atualiza(Long id, AlunoRequestDTO dto) {
		Aluno aluno = this.buscaAlunoPor(id);
		aluno.setMatricula(dto.getMatricula());
		aluno.setNome(dto.getNome().isEmpty() ? aluno.getNome() : dto.getNome());
		return alunoRepository.save(aluno);
	}

}
