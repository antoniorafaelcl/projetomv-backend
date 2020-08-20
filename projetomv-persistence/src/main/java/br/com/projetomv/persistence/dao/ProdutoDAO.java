package br.com.projetomv.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.persistence.model.Produto;

@Local
public interface ProdutoDAO extends GenericDAO<Long, Produto>{
	
	List<Produto> consultarTodos() throws DAOException;
	
	Produto consultarPorCodigo(Long codigo) throws RegistroNaoEncontradoException, DAOException;
	
	void reajustarPrecoPorCategoria (String categoria, Double preco);
	
	void reajustarPrecoPorRangePercentual(Double percentualInicial, Double percentualFim, Double preco);
}
