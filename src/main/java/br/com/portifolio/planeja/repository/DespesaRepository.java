package br.com.portifolio.planeja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portifolio.planeja.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
