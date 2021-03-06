package br.com.portifolio.planeja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.portifolio.planeja.model.Despesa;

public class DespesaDto {
	
	private Long id;
	private String descricao;
	private LocalDate data;
	private BigDecimal valor;
	
	public DespesaDto(Despesa despesa) {
		this.id = despesa.getId();
		this.descricao = despesa.getDescricao();
		this.data = despesa.getData();
		this.valor = despesa.getValor();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public static List<DespesaDto> converter(List<Despesa> despesa) {
		return despesa.stream().map(DespesaDto::new).collect(Collectors.toList());
	}
}
