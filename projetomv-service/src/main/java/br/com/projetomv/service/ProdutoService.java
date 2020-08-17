package br.com.projetomv.service;

import java.util.List;

import javax.ejb.Local;

import br.com.projetomv.dto.ProdutoDTO;
import br.com.projetomv.persistence.model.Produto;

@Local
public interface ProdutoService extends GenericService<Long, Produto> {
	
	/**
	 * Consultar todos os produtos cadastrados
	 * @return Lista de {@link Produto}
	 */
	List<Produto> consultarTodos();
	
	/**
	 * Consultar um produto por ID
	 * @return {@link Produto}
	 */
	Produto consultarPorCodigo(Long codigo);

	/**
	 * Cadastrar um produto
	 * @param produtoDTO - {@link ProdutoDTO}
	 */
	void cadastrar(ProdutoDTO produtoDTO);

	/**
	 * Editar um produto
	 * @param produtoDTO - {@link ProdutoDTO}
	 */
	void editar(ProdutoDTO produtoDTO);
	
	/**
	 * Deletar um produto
	 * @param id - Id do {@link Produto}
	 */
	void deletar(Long id);
}
