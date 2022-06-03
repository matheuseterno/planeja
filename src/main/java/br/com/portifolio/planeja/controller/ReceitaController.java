package br.com.portifolio.planeja.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.portifolio.planeja.dto.DetalhesReceitaDto;
import br.com.portifolio.planeja.dto.ReceitaDto;
import br.com.portifolio.planeja.form.ReceitaForm;
import br.com.portifolio.planeja.model.Receita;
import br.com.portifolio.planeja.repository.ReceitaRepository;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@GetMapping
	public List<DetalhesReceitaDto> lista() {
		List<Receita> receitas = receitaRepository.findAll();
		return DetalhesReceitaDto.converter(receitas);
	}
	
	@GetMapping("/receitas/{id}")
	public ResponseEntity<DetalhesReceitaDto> detalhar(@PathVariable("id") Long id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		if(receita.isPresent()) {
			return ResponseEntity.ok(new DetalhesReceitaDto(receita.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ReceitaDto> cadastrar(@RequestBody @Valid ReceitaForm receitaForm, UriComponentsBuilder uriBuilder){
		Receita receita = receitaForm.converter();
		receitaRepository.save(receita);
		URI uri = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar (@PathVariable("id") Long id){
		Optional<Receita> receita = receitaRepository.findById(id);
		if(receita.isPresent()) {
			receitaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}