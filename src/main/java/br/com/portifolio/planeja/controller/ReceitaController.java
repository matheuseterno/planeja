package br.com.portifolio.planeja.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}