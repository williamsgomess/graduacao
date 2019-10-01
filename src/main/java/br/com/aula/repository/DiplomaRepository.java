package br.com.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aula.entity.Diploma;

public interface DiplomaRepository extends JpaRepository<Diploma, String> {

	Diploma findByAlunoMatricula(String matricula);
	
}
