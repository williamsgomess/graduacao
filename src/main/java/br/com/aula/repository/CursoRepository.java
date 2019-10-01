package br.com.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
