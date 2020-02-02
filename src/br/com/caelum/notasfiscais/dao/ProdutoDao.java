package br.com.caelum.notasfiscais.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.notasfiscais.connection.ConnectionFactory;
import br.com.caelum.notasfiscais.mb.Produto;

public class ProdutoDao {

	public Produto save(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return produto;
	}
	
	public void remove(Produto produto) {
		EntityManager manager = new ConnectionFactory().getConnection();
		
		try {
			manager.getTransaction().begin();
			//manager.remove(produto);
			manager.remove(manager.merge(produto)); //remove
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}
	
	public void update(Produto produto) {
		EntityManager manager = new ConnectionFactory().getConnection();
		
		try {
			manager.getTransaction().begin();
			manager.merge(produto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	public List<Produto> listaTodos(){
		EntityManager manager = new ConnectionFactory().getConnection();
		
		CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
		query.select(query.from(Produto.class));
		
		List<Produto> lista = manager.createQuery(query).getResultList();
		
		manager.close();
		
		return lista;
	}
	
}
