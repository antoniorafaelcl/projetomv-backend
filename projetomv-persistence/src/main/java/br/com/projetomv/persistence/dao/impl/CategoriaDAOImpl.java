package br.com.projetomv.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.persistence.dao.CategoriaDAO;
import br.com.projetomv.persistence.model.Categoria;

@Stateless
public class CategoriaDAOImpl extends GenericDAOImpl<Long, Categoria> implements CategoriaDAO {

	public  CategoriaDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Categoria> consultarTodos() throws DAOException {
		try {
			StringBuilder consulta = new StringBuilder();
			consulta.append("SELECT c FROM Categoria c");

			TypedQuery<Categoria> resultado = getEntityManager().createQuery(consulta.toString(), Categoria.class);
			return resultado.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}

	@Override
	public Categoria consultarPorID(Long id) throws RegistroNaoEncontradoException, DAOException {
		try {
			StringBuilder consulta = new StringBuilder();
			consulta.append("SELECT c FROM Categoria c").append(" WHERE c.id =:id");

			TypedQuery<Categoria> resultado = getEntityManager().createQuery(consulta.toString(), Categoria.class);
			resultado.setParameter("id", id);

			return resultado.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}
	}

}
