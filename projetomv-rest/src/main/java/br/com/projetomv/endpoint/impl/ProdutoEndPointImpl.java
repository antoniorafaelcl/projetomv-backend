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
	public Response deletar(Long id) {
		produtoService.deletar(id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto deletado com sucesso")).build(); 
	}

}
