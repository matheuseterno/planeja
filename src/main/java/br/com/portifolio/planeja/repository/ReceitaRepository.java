package br.com.portifolio.planeja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portifolio.planeja.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
