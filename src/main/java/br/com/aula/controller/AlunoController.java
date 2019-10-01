package br.com.aula.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.entity.Aluno;
import br.com.aula.entity.Curso;
import br.com.aula.entity.dto.AlunoRequestDTO;
import br.com.aula.entity.dto.AlunoResponseDto;
import br.com.aula.repository.CursoRepository;
import br.com.aula.service.AlunoService;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public ResponseEntity<List<AlunoResponseDto>> buscaAlunos() {
		
		List<Aluno> alunos = alunoService.buscaTodosAlunos();
		
		List<AlunoResponseDto> dto = alunos.stream().map(a -> AlunoResponseDto.getDtoFrom(a)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<AlunoResponseDto> salvar(@RequestBody AlunoRequestDTO dto) {
		
		Optional<Curso> cursoOp = cursoRepository.findById(dto.getCursoId());
		Curso curso = cursoOp.get();
		Aluno aluno = converteDtoEmAluno(dto, curso);
		Aluno save = alunoService.cria(aluno);
		return ResponseEntity.ok(AlunoResponseDto.getDtoFrom(save));
	}
	
	@GetMapping("/{nomeAluno}")
	public ResponseEntity<AlunoResponseDto> buscaPorNome(@PathVariable("nomeAluno")String nome) {
		
		Aluno aluno = alunoService.buscaPor(nome);
		
		return ResponseEntity.ok(AlunoResponseDto.getDtoFrom(aluno));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AlunoResponseDto> salvar(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
		
		Aluno alunoSalvo = alunoService.atualiza(id, dto);
		return ResponseEntity.ok(AlunoResponseDto.getDtoFrom(alunoSalvo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		
		alunoService.removeAlunoPor(id);
		return ResponseEntity.noContent().build();
	}

	private Aluno converteDtoEmAluno(AlunoRequestDTO dto, Curso curso) {
		Aluno aluno = new Aluno();
		aluno.setNome(dto.getNome());
		aluno.setMatricula(dto.getMatricula());
		aluno.setCurso(curso);
		return aluno;
	}

}
