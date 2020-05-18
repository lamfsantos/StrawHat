package br.com.strawhat.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;

import br.com.strawhat.model.Entidade;

public class EntidadeDTO {
	private Integer id;
	
	//O tipo da data aqui é string, porque o back recebe do front a
	//data com o formato dd/mm e tem que se encarregar de adicionar
	//o ano no método fromDTO antes de inserir no banco
	private String data;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	
	public EntidadeDTO() {}

	public EntidadeDTO(Entidade obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.data = df.format(obj.getData());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
