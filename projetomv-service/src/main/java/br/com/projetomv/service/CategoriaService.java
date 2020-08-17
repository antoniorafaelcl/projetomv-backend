package br.com.projetomv.service;

import java.util.List;

import javax.ejb.Local;

import br.com.projetomv.persistence.model.Categoria;
import br.com.projetomv.persistence.model.Produto;

@Local
public interface CategoriaService extends GenericService<Long, Categoria>{
	/**
	 * Consultar todos as categorias cadastradass
	 * @return Lista de {@link Categoria}
	 */
	List<Categoria> consultarTodos();
	
	/**
	 * Consultar uma categoria por ID
	 * @return {@link Produto}
	 */
	Categoria consultarPorId(Long id);

}
