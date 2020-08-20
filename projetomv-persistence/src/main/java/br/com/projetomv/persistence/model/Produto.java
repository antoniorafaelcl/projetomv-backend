package br.com.projetomv.persistence.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO", schema = "mv")
public class Produto extends EntidadeBase<Long> {

	private static final long serialVersionUID = -8835643582282215145L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_PRODUTO")
	private Long id;

	@Column(name = "DS_PRODUTO")
	private String descricao;

	@Column(name = "PRECO_PRODUTO")
	private Double preco;

	@ManyToOne
	@JoinColumn(name = "CD_CATEGORIA")
	private Categoria categoria;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(categoria, descricao, id, preco);
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
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(preco, other.preco);
	}

}
