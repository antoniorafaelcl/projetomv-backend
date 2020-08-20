package br.com.projetomv.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.projetomv.dto.MensagemRetornoDTO;
import br.com.projetomv.dto.ProdutoDTO;
import br.com.projetomv.endpoint.ProdutoEndPoint;
import br.com.projetomv.service.ProdutoService;

public class ProdutoEndPointImpl implements ProdutoEndPoint {
	
	@EJB
	private ProdutoService produtoService;
	
	@Override
	public Response consultarTodos() {
		return Response.status(Status.OK).entity(produtoService.consultarTodos()).build();
	}

	@Override
	public Response consultarPorCodigo(Long codigo) {
		return Response.status(Status.OK).entity(produtoService.consultarPorCodigo(codigo)).build();
	}

	@Override
	public Response cadastrar(ProdutoDTO produtoDTO) {
		produtoService.cadastrar(produtoDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Produto cadastrado com sucesso")).build();
	}

	@Override
	public Response editar(ProdutoDTO produtoDTO) {
		produtoService.editar(produtoDTO);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto editado com sucesso")).build();
	}

	@Override
	public Response deletar(Long codigo) {
		produtoService.deletar(codigo);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto deletado com sucesso")).build(); 
	}

	@Override
	public Response reajustarPrecoPorCategoria(String categoria, Double preco) {
		produtoService.reajustarPrecoPorCategoria(categoria, preco);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produtos ajustados com sucesso")).build();
	}

	@Override
	public Response reajustarPrecoPorRangePercentual(Double percentualInicial, Double percentualFim, Double preco) {
		produtoService.reajustarPrecoPorRangePercentual(percentualInicial, percentualFim, preco);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto ajustados com sucesso")).build();
	}

}
