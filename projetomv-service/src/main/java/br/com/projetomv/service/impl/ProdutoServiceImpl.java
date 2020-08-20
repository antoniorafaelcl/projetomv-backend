package br.com.projetomv.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.projetomv.dto.ProdutoDTO;
import br.com.projetomv.enumeration.MensagemEnum;
import br.com.projetomv.exception.DAOException;
import br.com.projetomv.exception.NegocioException;
import br.com.projetomv.exception.RegistroNaoEncontradoException;
import br.com.projetomv.mapper.ProdutoMapper;
import br.com.projetomv.persistence.dao.ProdutoDAO;
import br.com.projetomv.persistence.model.Categoria;
import br.com.projetomv.persistence.model.Produto;
import br.com.projetomv.service.CategoriaService;
import br.com.projetomv.service.ProdutoService;
import br.com.projetomv.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProdutoServiceImpl extends GenericServiceImpl<Long, Produto> implements ProdutoService{

	private static final long serialVersionUID = 4737294229379309116L;
	
	@EJB
	private ProdutoDAO produtoDAO;
	
	@EJB
	private CategoriaService categoriaService;
	
	@Override
	public List<Produto> consultarTodos() {
		try {
			return produtoDAO.consultarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG_ERRO));
		}
	}
	
	@Override
	public Produto consultarPorCodigo(Long codigo) {
		try {
			return produtoDAO.consultarPorCodigo(codigo);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Produto com o codigo: " + codigo + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG_ERRO));
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(ProdutoDTO produtoDTO) {
		Categoria categoria = categoriaService.consultarPorId(produtoDTO.getIdCategoria());
		produtoDAO.gravar(ProdutoMapper.mapperDTOParaEntidade(produtoDTO, categoria));
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void editar(ProdutoDTO produtoDTO) {
		Categoria categoria = categoriaService.consultarPorId(produtoDTO.getIdCategoria());
		produtoDAO.gravar(ProdutoMapper.mapperDTOParaEntidade(produtoDTO, categoria));
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void deletar(Long codigo) {
		produtoDAO.excluir(codigo);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void reajustarPrecoPorCategoria(String categoria, Double preco) {
		produtoDAO.reajustarPrecoPorCategoria(categoria, preco);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void reajustarPrecoPorRangePercentual(Double percentualInicial, Double percentualFim, Double preco) {
		produtoDAO.reajustarPrecoPorRangePercentual(percentualInicial, percentualFim, preco);
		
	}

}
