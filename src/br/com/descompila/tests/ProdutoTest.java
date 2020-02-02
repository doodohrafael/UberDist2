package br.com.descompila.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.notasfiscais.connection.ConnectionFactory;
import br.com.caelum.notasfiscais.mb.Produto;
import br.com.caelum.notasfiscais.dao.ProdutoDao;

public class ProdutoTest {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setDescricao("Bebidas 2");
		
		ProdutoDao dao = new ProdutoDao();
		produto = dao.save(produto);

		System.out.println("ID: "+ produto.getId());
		System.out.println("Descrição: "+ produto.getDescricao());
		
		
		//Criando uma tabelo no banco
		/*
		 * Categoria c = new Categoria(); c.setDescricao("Bebidas");
		 * 
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		 * EntityManager em = emf.createEntityManager();
		 * 
		 * em.getTransaction().begin(); em.persist(c); em.getTransaction().commit();
		 * 
		 * em.close(); emf.close();
		 */
		
		//Criando uma tabelo no banco
		/*
		 * Categoria c = new Categoria(); c.setDescricao("Comidas");
		 * 
		 * EntityManager em = new ConnectionFactory().getConnection();
		 * 
		 * em.getTransaction().begin(); em.persist(c); em.getTransaction().commit();
		 * 
		 * em.close();
		 */
		
	}

}
