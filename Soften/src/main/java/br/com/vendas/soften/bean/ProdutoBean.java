package br.com.vendas.soften.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendas.soften.dao.ProdutoDAO;
import br.com.vendas.soften.entity.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private Produto produto;

	private ProdutoDAO produtoDAO;

	private String[] produtosSelecionados;

	private List<Produto> produtos;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public String[] getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(String[] produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@PostConstruct
	public void iniciar() {
		produtoDAO = new ProdutoDAO();
	}

	public void listar() {
		try {
			produtos = produtoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os produtos.");
			erro.printStackTrace();
		}
	}

	public void novo() {
		produto = new Produto();
	}

	public void salvar() {
		try {
			produtoDAO.merge(produto);

			novo();
			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			produtoDAO.excluir(produto);
			produtos = produtoDAO.listar();
			Messages.addGlobalInfo("Produto removido.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o produto.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o produto.");
			erro.printStackTrace();
		}
	}
}