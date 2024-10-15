package org.serratec.candidato.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.candidato.dto.CandidatoDto;
import org.serratec.candidato.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	@Autowired
	
	private CandidatoService servico;
		
	@GetMapping
	public List<CandidatoDto> listarCandidatos(){
		return servico.obterTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CandidatoDto> listarPorId(@PathVariable Long id){
		Optional<CandidatoDto> dto = servico.obterPorId(id);
		if(dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CandidatoDto cadastrarCandidato(@RequestBody CandidatoDto dto) {
		return servico.salvarCandidato(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarPedido(@PathVariable Long id) {
		if(!servico.apagarCandidato(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado!");
		}	
		return ResponseEntity.ok("Candidato com id "+ id +" excluído com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDto> alterarPedido(@PathVariable Long id, 
			@RequestBody CandidatoDto dto) {
		Optional<CandidatoDto> candidatoAlterado = servico.alterarCandidato(id, dto);
		if(!candidatoAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(candidatoAlterado.get());
	}
	
}