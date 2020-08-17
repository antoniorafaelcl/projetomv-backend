package br.com.projetomv.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.persistence.model.Categoria;

@Local
public interface CategoriaDAO extends GenericDAO<Long, Categoria> {
	
	List<Categoria> consultarTodos() throws DAOException;
	
	Categoria consultarPorID(Long id) throws RegistroNaoEncontradoException, DAOException;
}
