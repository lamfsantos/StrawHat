package br.com.strawhat.dto;

import java.io.Serializable;

import br.com.strawhat.model.Associado;

public class AssociadoGetMensalidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;

	public AssociadoGetMensalidadeDTO() {
	}

	public AssociadoGetMensalidadeDTO(Associado obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
