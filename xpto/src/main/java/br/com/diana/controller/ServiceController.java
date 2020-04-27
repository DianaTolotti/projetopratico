package br.com.diana.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.diana.http.Cidade;
import br.com.diana.repository.CidadeRepository;
import br.com.diana.repository.entity.CidadeEntity;


/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
		
	private final  CidadeRepository repository = new CidadeRepository();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova cidade
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Cidade cidade){
		
		CidadeEntity entity = new CidadeEntity();
				
		try {
			entity.setCodigo(cidade.getCodigo());
			entity.setIdIbge(cidade.getIdIbge());
			entity.setEstado(cidade.getEstado());
			entity.setNomeCidade(cidade.getNomeCidade());
			entity.setCapital(cidade.getCapital());
			entity.setLongitude(cidade.getLongitude());
			entity.setLatitude(cidade.getLatitude());
			entity.setNao_acentos(cidade.getNao_acentos());
			entity.setNome_alternativo(cidade.getNome_alternativo());
			entity.setMicroregiao(cidade.getMicroregiao());
			entity.setMesoregiao(cidade.getMesoregiao());
			
			repository.Salvar(entity);
			
			return "Registro cadastrado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	
	}
	
	/**
	 * Essse método altera uma cidade já cadastrada
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Cidade cidade){
		
		CidadeEntity entity = new CidadeEntity();
		
		try {
			entity.setCodigo(cidade.getCodigo());
			entity.setIdIbge(cidade.getIdIbge());
			entity.setEstado(cidade.getEstado());
			entity.setNomeCidade(cidade.getNomeCidade());
			entity.setCapital(cidade.getCapital());
			entity.setLongitude(cidade.getLongitude());
			entity.setLatitude(cidade.getLatitude());
			entity.setNao_acentos(cidade.getNao_acentos());
			entity.setNome_alternativo(cidade.getNome_alternativo());
			entity.setMicroregiao(cidade.getMicroregiao());
			entity.setMesoregiao(cidade.getMesoregiao());
			
			repository.Alterar(entity);
			
			return "Registro alterado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao alterar o registro " + e.getMessage();
			
		}

	}
	/**
	 * Esse método lista todas cidades cadastradas na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasCidades")
	public List<Cidade> TodasCidades(){
		
		List<Cidade> cidades =  new ArrayList<Cidade>();
		
		List<CidadeEntity> listaEntityCidades = repository.TodasCidades();
		
		for (CidadeEntity entity : listaEntityCidades) {
			
			cidades.add(new Cidade(entity.getCodigo(), entity.getIdIbge(), entity.getEstado(), entity.getNomeCidade(), entity.getCapital(), entity.getLongitude(), entity.getLatitude(), entity.getNao_acentos(), entity.getNome_alternativo(), entity.getMicroregiao(), entity.getMesoregiao()));
		}
		
		return cidades;
	}
	
	/**
	 * Esse método busca uma cidade cadastrada pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getCidade/{idIbge}")
	public Cidade GetCidade(@PathParam("idIbge") Integer idIbge){
		
		CidadeEntity entity = repository.GetCidade(idIbge);
		
		if(entity != null)
			return new Cidade(entity.getCodigo(), entity.getIdIbge(), entity.getEstado(), entity.getNomeCidade(), entity.getCapital(), entity.getLongitude(), entity.getLatitude(), entity.getNao_acentos(), entity.getNome_alternativo(), entity.getMicroregiao(), entity.getMesoregiao());
		
		return null;
	}
	
	/**
	 * Excluindo uma cidade pelo idIbge
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{idIbge}")	
	public String Excluir(@PathParam("idIbge") Integer idIbge){
		
		try {
			
			repository.Excluir(idIbge);
			
			return "Registro excluido com sucesso!";
			
		} catch (Exception e) {
		
			return "Erro ao excluir o registro! " + e.getMessage();
		}
		
	}
	
}
