package br.com.projetomv.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.projetomv.persistence.dao.GenericDAO;
import br.com.projetomv.persistence.model.EntidadeBase;
import br.com.projetomv.service.GenericService;

public abstract class GenericServiceImpl<K extends Serializable, T extends EntidadeBase<K>>
		implements GenericService<K, T> {

	private static final long serialVersionUID = -8808447582497731692L;
	
	@Inject
	private GenericDAO<K, T> dao;

	@Override
	public List<T> listar() {
		return dao.listar();
	}

	@Override
	public T consultarPorId(K id) {
		return dao.consultarPorId(id);
	}

	@Override
	public T gravar(T objeto) {
		return dao.gravar(objeto);
	}

	@Override
	public void excluir(K id) {
		dao.excluir(id);
	}

	@Override
	public void excluir(T objeto) {
		dao.excluir(objeto);
	}

}