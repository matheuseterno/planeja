package br.com.portifolio.planeja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.portifolio.planeja.model.Receita;

public class DetalhesReceitaDto {
	
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	public DetalhesReceitaDto(Receita receita) {
		this.descricao = receita.getDescricao();
		this.data = receita.getData();
		this.valor = receita.getValor();
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public static List<DetalhesReceitaDto> converter(List<Receita> receitas) {
		return receitas.stream().map(DetalhesReceitaDto::new).collect(Collectors.toList());
	}

}
