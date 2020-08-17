package br.com.projetomv.persistence.model;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codigo, descricao, id, numeroPercentual);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(numeroPercentual, other.numeroPercentual);
	}

}
