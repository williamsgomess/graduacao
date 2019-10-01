package br.com.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Aluno findByNome(String nome);

}
