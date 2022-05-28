package br.com.portifolio.planeja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.portifolio.planeja.dto.DespesaDto;
import br.com.portifolio.planeja.model.Despesa;
import br.com.portifolio.planeja.repository.DespesaRepository;

@RestController
public class DespesaController {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@GetMapping("/despesas")
	public List<DespesaDto> lista(){
		List<Despesa> despesas = despesaRepository.findAll();
		return DespesaDto.converter(despesas);
	}
	
	@GetMapping("/despesas/{id}")
	public ResponseEntity<DespesaDto> detalhar(@PathVariable("id") Long id) {
		Optional<Despesa> despesa = despesaRepository.findById(id);
		if(despesa.isPresent()) {
			return ResponseEntity.ok(new DespesaDto(despesa.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
