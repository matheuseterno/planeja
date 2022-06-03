package br.com.portifolio.planeja.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.portifolio.planeja.model.Receita;

public class ReceitaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @NotEmpty
	private String valor;
	@NotNull @NotEmpty
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
