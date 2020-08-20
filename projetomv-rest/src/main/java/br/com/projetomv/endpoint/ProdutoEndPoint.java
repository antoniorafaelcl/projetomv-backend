package br.com.projetomv.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projetomv.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("produtos")
@Tag(name = "Produto", description = "Recurso para produtos")
public interface ProdutoEndPoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Lista todos os produtos cadastrados no sistema", summary = "Listar Produtos", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response consultarTodos();
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Consultar um produto no sistema", summary = "Consultar um produto", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response consultarPorCodigo(@PathParam(value = "codigo") Long codigo);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Cadastrar um produto no sistema", summary = "Cadastrar um produto", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response cadastrar(@RequestBody(description = "Objeto Produto que será adicionado",
						required = true, 
						content = @Content(schema = @Schema(implementation = ProdutoDTO.class))) @Valid ProdutoDTO produtoDTO);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Editar um produto no sistema", summary = "Editar um produto", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response editar(@RequestBody(description = "Objeto Produto que será adicionado",
						required = true, 
						content = @Content(schema = @Schema(implementation = ProdutoDTO.class))) @Valid ProdutoDTO produtoDTO);
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Deletar um produto no sistema", summary = "Deletar um produto", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response deletar(@PathParam(value = "codigo") Long codigo);
	
	@PUT
	@Path("/ajuste-preco-categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Editar o preço de um produto por categoria no sistema", summary = "Editar o preço de um produto por categoria", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response reajustarPrecoPorCategoria (@QueryParam("categoria") String categoria, @QueryParam("preco") Double preco);
	
	@PUT
	@Path("/ajuste-preco-range-categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(description = "Editar o preço de um produto por categoria no sistema", summary = "Editar o preço de um produto por categoria", 
	   responses = {
			   @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
			   @ApiResponse(responseCode = "400", description = "Bad Request"),
			   @ApiResponse(responseCode = "404", description = "Not found"),
			   @ApiResponse(responseCode = "500", description = "Internal Server Error")})
	Response reajustarPrecoPorRangePercentual(@QueryParam("percentualInicial") Double percentualInicial, @QueryParam("percentualFim") Double percentualFim, @QueryParam("preco") Double preco);
	
}
