package br.com.projetomv.mapper;

import br.com.projetomv.dto.ProdutoDTO;
import br.com.projetomv.persistence.model.Categoria;
import br.com.projetomv.persistence.model.Produto;

public class ProdutoMapper {

	public ProdutoMapper() {
		super();
	}
	
	public static Produto mapperDTOParaEntidade(ProdutoDTO produtoDTO, Categoria categoria) {
		Produto produto = new Produto();
		if(produtoDTO.getCodigo() != null) {
			produto.setId(produtoDTO.getCodigo());
		}
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setPreco(produtoDTO.getPreco());
		produto.setCategoria(categoria);
		
		return produto;
	}
	
}
