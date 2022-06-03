package br.com.portifolio.planeja.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.portifolio.planeja.model.Receita;

public class ReceitaForm {

	private String descricao;
	private String valor;
	private String data;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Receita converter() {
		return new Receita(descricao, valor, data);
	}

}
