package br.com.caelum.notasfiscais.bean;

import br.com.caelum.notasfiscais.mb.Produto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.ProdutoDao;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	// private Produto produto; //pega os atributos da classe Produto
	private Produto produto = new Produto();// pega os atributos da classe Produto
	private List<Produto> produtos;
	List<Double> valorTotal = new ArrayList<Double>();
	//private Double precos;

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) { // o setPropertyActionListener se ultiliza desse metodo
		this.produto = produto;
	}

	public void grava() {
		ProdutoDao dao = new ProdutoDao();
		
		if (produto.getId() == null) {
			dao.save(produto);
		} else {
			dao.update(produto);
		}

		this.produtos = dao.listaTodos(); // atualiza a lista com o novo produto inserido
		this.produto = new Produto(); // Limpar campos criando uma nova instancia
	}

	public void cancelarEdicao() {
		this.produto = new Produto();
	}

	public void exclui(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	// @SuppressWarnings("unused")
	public List<Produto> getProdutos() {

		// Double precos = 0.0;
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = new ProdutoDao().listaTodos();
			/*
			 * double total = 0; for (Produto produto : produtos) { precos =
			 * produto.getPreco(); total = total + precos; valorTotal.add(precos); }
			 * 
			 * System.out.println("Totaal: " + total);
			 */

		}

		return produtos;

	}

}
