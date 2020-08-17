package br.com.projetomv.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.projetomv.enumeration.MensagemEnum;
import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.NegocioException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.persistence.dao.CategoriaDAO;
import br.com.projetomv.persistence.model.Categoria;
import br.com.projetomv.service.CategoriaService;
import br.com.projetomv.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CategoriaServiceImpl extends GenericServiceImpl<Long, Categoria> implements CategoriaService{

	private static final long serialVersionUID = -8899084325035777078L;
	
	@EJB
	private CategoriaDAO categoriaDAO;
	
	
	public CategoriaServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Categoria> consultarTodos() {
		try {
			return categoriaDAO.consultarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG_ERRO));
		}
	}
	
	@Override
	public Categoria consultarPorId(Long id) {
		try {
			return categoriaDAO.consultarPorID(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Categorio com o id: " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG_ERRO));
		}
	}

}
