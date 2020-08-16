package br.com.projetomv.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA", schema = "projetomv")
public class Categoria extends EntidadeBase<Long> {

	private static final long serialVersionUID = -7202612145769412801L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_CATEGORIA")
	private Long id;
	
	@Column(name = "CD_CATEGORIA")
	private Long codigo;
	
	@Column(name = "DS_CATEGORIA")
	private String descricao;
	
	@Column(name = "NR_PERCENTUAL")
	private Double numeroPercentual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getNumeroPercentual() {
		return numeroPercentual;
	}

	public void setNumeroPercentual(Double numeroPercentual) {
		this.numeroPercentual = numeroPercentual;
	}

}
