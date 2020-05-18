package br.com.strawhat.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.strawhat.model.Mensalidade;

public class MensalidadeGetDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date data;
	private Double valor;

	private AssociadoGetMensalidadeDTO associado;

	public MensalidadeGetDTO() {
	}

	public MensalidadeGetDTO(Mensalidade obj) {
		id = obj.getId();
		data = obj.getData();
		valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public AssociadoGetMensalidadeDTO getAssociado() {
		return associado;
	}

	public void setAssociado(AssociadoGetMensalidadeDTO associado) {
		this.associado = associado;
	}

}
