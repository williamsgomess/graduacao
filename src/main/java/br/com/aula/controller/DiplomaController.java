package br.com.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.entity.Diploma;
import br.com.aula.repository.DiplomaRepository;

@RestController
@RequestMapping("/v1/diploma")
public class DiplomaController {
	
	@Autowired
	private DiplomaRepository diplomaRepository;
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Diploma> buscaPorMatricula(@PathVariable("matricula") String matricula) {
		return ResponseEntity.ok(diplomaRepository.findByAlunoMatricula(matricula));
	}

}
