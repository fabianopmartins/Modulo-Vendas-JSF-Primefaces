package br.com.vendas.soften.util.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.soften.dao.ProdutoDAO;
import br.com.vendas.soften.entity.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Produto produto = new Produto();
		produto.setNome("Placa Mãe");
		produto.setValorCusto(new BigDecimal("270.00"));
		produto.setValorVenda(new BigDecimal("520.00"));
		
		Produto produto1 = new Produto();
		produto1.setNome("Memória");
		produto.setValorCusto(new BigDecimal("140.00"));
		produto.setValorVenda(new BigDecimal("280.00"));

		Produto produto2 = new Produto();
		produto2.setNome("Fonte");
		produto.setValorCusto(new BigDecimal("230.00"));
		produto.setValorVenda(new BigDecimal("390.00"));

		Produto produto3 = new Produto();
		produto3.setNome("Monitor");
		produto.setValorCusto(new BigDecimal("240.00"));
		produto.setValorVenda(new BigDecimal("470.00"));

		Produto produto4 = new Produto();
		produto4.setNome("Mouse");
		produto.setValorCusto(new BigDecimal("45.00"));
		produto.setValorVenda(new BigDecimal("98.00"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		produtoDAO.salvar(produto1);
		produtoDAO.salvar(produto2);
		produtoDAO.salvar(produto3);
		produtoDAO.salvar(produto4);

	}

	@Test
	@Ignore
	public void listar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		System.out.println("\nTotal de registros encontrado(s): " + resultado.size());
		System.out.println("\n|||||||||| Produtos ||||||||||\n");
		for (Produto produto : resultado) {
			System.out.println("Código Registro Tabela: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Valor de Custo: " + produto.getValorCusto());
			System.out.println("Valor de Venda: " + produto.getValorVenda());
			System.out.println("\n|||||||||||||||||||||||||||||\n");
		}
	}

	@Test
	@Ignore
	public void buscar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(6L);

		System.out.println("\n|||| Resultado da busca ||||");

		if (produto == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			System.out.println("\n|||||||||| Produto ||||||||||\n");
			System.out.println("Código Registro Tabela: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Valor de Custo: " + produto.getValorCusto());
			System.out.println("Valor de Venda: " + produto.getValorVenda());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(3L);

		if (produto == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			produtoDAO.excluir(produto);

			System.out.println("\nRegistro removido:\n");
			System.out.println("Código Registro Tabela: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Valor de Custo: " + produto.getValorCusto());
			System.out.println("Valor de Venda: " + produto.getValorVenda());
		}
	}

	@Test
	@Ignore
	public void editar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(3L);

		if (produto == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			produto.setNome("Teclado");
			produto.setValorCusto(new BigDecimal("150.00"));
			produto.setValorVenda(new BigDecimal("390.00"));
			produtoDAO.editar(produto);

			System.out.println("\nRegistro alterado:\n");
			System.out.println("Código Registro Tabela: " + produto.getId());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Valor de Custo: " + produto.getValorCusto());
			System.out.println("Valor de Venda: " + produto.getValorVenda());
		}
	}
}