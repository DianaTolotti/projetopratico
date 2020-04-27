package br.com.diana.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diana.repository.entity.CidadeEntity;


public class CidadeRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public CidadeRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_sistemaxpto");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(CidadeEntity cidadeEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(cidadeEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(CidadeEntity cidadeEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(cidadeEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * RETORNA TODAS AS CIDADES CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<CidadeEntity> TodasCidades(){
		
		return this.entityManager.createQuery("SELECT p FROM Cidade c ORDER BY c.nome").getResultList();
	}
	
	/**
	 * CONSULTA UMA PESSOA CADASTRA PELO CÓDIGO
	 * */
	public CidadeEntity GetCidade(Integer idIbge){
		
		return this.entityManager.find(CidadeEntity.class, idIbge);
	}
	
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer idIbge){
		
		CidadeEntity cidade = this.GetCidade(idIbge);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cidade);
		this.entityManager.getTransaction().commit();
		
	}
}
