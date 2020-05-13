package br.com.strawhat.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.strawhat.model.Associado;

public class AssociadoDTO implements Serializable{
private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;

	private String cpf;
	private String rg;
	private String endereco;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeNascimento;

	public AssociadoDTO() {}

	public AssociadoDTO(Associado obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
		this.dataDeNascimento = obj.getDataDeNascimento();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
