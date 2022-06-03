package br.com.portifolio.planeja.form;

import br.com.portifolio.planeja.model.Despesa;

public class DespesaForm {
	
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
	public Despesa converter() {
		return new Despesa(descricao, valor, data);
	}
	

}
