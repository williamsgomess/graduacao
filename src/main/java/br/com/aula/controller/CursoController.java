package br.com.aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.entity.Curso;
import br.com.aula.repository.CursoRepository;

@RestController
@RequestMapping(value = "/v1/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public ResponseEntity<List<Curso>> buscaTodos() {
		return ResponseEntity.ok(cursoRepository.findAll());
	}

}
