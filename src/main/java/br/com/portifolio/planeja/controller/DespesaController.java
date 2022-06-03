package br.com.portifolio.planeja.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.portifolio.planeja.dto.DespesaDto;
import br.com.portifolio.planeja.dto.DetalhesDespesaDto;
import br.com.portifolio.planeja.form.DespesaForm;
import br.com.portifolio.planeja.model.Despesa;
import br.com.portifolio.planeja.repository.DespesaRepository;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@GetMapping
	public List<DetalhesDespesaDto> lista(){
		List<Despesa> despesas = despesaRepository.findAll();
		return DetalhesDespesaDto.converter(despesas);
	}
	
	@GetMapping("/despesas/{id}")
	public ResponseEntity<DetalhesDespesaDto> detalhar(@PathVariable("id") Long id) {
		Optional<Despesa> despesa = despesaRepository.findById(id);
		if(despesa.isPresent()) {
			return ResponseEntity.ok(new DetalhesDespesaDto(despesa.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaForm despesaForm, UriComponentsBuilder uriBuilder){
		Despesa despesa = despesaForm.converter();
		despesaRepository.save(despesa);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		 Optional<Despesa> despesa = despesaRepository.findById(id);
		if(despesa.isPresent()) {
			despesaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
