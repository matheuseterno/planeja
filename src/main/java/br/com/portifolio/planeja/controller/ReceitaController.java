package br.com.portifolio.planeja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portifolio.planeja.dto.ReceitaDto;
import br.com.portifolio.planeja.model.Receita;
import br.com.portifolio.planeja.repository.ReceitaRepository;

@RestController
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@GetMapping("/receitas")
	public List<Receita> lista() {
		List<Receita> receitas = receitaRepository.findAll();
		return receitas;
	}
	
	@GetMapping("/receitas/{id}")
	public ResponseEntity<ReceitaDto> detalhar(@PathVariable("id") Long id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		if(receita.isPresent()) {
			return ResponseEntity.ok(new ReceitaDto(receita.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Receita> cadastrar (){
		return null;
	}
}