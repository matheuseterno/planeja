package br.com.portifolio.planeja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.portifolio.planeja.model.Despesa;

public class DetalhesDespesaDto {
	
	private String descricao;
	private LocalDate data;
	private BigDecimal valor;
	
	public DetalhesDespesaDto(Despesa despesa) {
		this.data = despesa.getData();
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public static List<DetalhesDespesaDto> converter(List<Despesa> despesa) {
		return despesa.stream().map(DetalhesDespesaDto::new).collect(Collectors.toList());
	}
	

}
