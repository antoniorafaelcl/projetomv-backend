package br.com.projetomv.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.persistence.dao.ProdutoDAO;
import br.com.projetomv.persistence.model.Produto;

@Stateless
public class ProdutoDAOImpl extends GenericDAOImpl<Long, Produto>  implements ProdutoDAO{
	
	
	public ProdutoDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Produto> consultarTodos() throws DAOException {
		try {
			StringBuilder consulta = new StringBuilder();
			consulta.append("SELECT p FROM Produto p");
			
			TypedQuery<Produto> resultado = getEntityManager().createQuery(consulta.toString(), Produto.class);
			return resultado.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}
	
	@Override
	public Produto consultarPorCodigo(Long codigo) throws RegistroNaoEncontradoException, DAOException {
		try {
			StringBuilder consulta = new StringBuilder();
			consulta
				.append("SELECT p FROM Produto p")
				.append(" WHERE p.id =:id");
			
			TypedQuery<Produto> resultado = getEntityManager().createQuery(consulta.toString(), Produto.class);
			resultado.setParameter("id", codigo);
			
			return resultado.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}
	
	@Override
	public void reajustarPrecoPorCategoria(String categoria, Double preco) {
		Query resultado = getEntityManager().createNativeQuery("{ call reajustePrecoProduto.reajustarPrecoPorCategoria(:categoria, :preco)}");
		resultado.setParameter("categoria", categoria);
		resultado.setParameter("preco", preco);
		resultado.executeUpdate();
	}
	
	@Override
	public void reajustarPrecoPorRangePercentual(Double percentualInicial, Double percentualFim, Double preco) {
		Query resultado = getEntityManager().createNativeQuery("{ call reajustePrecoProduto.reajustarPrecoPorRangePercentual(:percentualInicial, :percentualFim, :preco)}");
		resultado.setParameter("percentualInicial", percentualInicial);
		resultado.setParameter("percentualFim", percentualFim);
		resultado.setParameter("preco", preco);
		resultado.executeUpdate();
	}

}
