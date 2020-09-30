package br.com.vendas.soften.util.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.soften.dao.CidadeDAO;
import br.com.vendas.soften.dao.EstadoDAO;
import br.com.vendas.soften.entity.Cidade;
import br.com.vendas.soften.entity.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(1L);

		Estado estado1 = estadoDAO.buscar(2L);

		Estado estado2 = estadoDAO.buscar(3L);

		Estado estado3 = estadoDAO.buscar(4L);

		Estado estado4 = estadoDAO.buscar(5L);

		Cidade cidade = new Cidade();
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(estado);

		Cidade cidade1 = new Cidade();
		cidade1.setNome("São Paulo");
		cidade1.setEstado(estado1);

		Cidade cidade2 = new Cidade();
		cidade2.setNome("Miraí");
		cidade2.setEstado(estado2);

		Cidade cidade3 = new Cidade();
		cidade3.setNome("Florianópolis");
		cidade3.setEstado(estado3);

		Cidade cidade4 = new Cidade();
		cidade4.setNome("Cuiabá");
		cidade4.setEstado(estado4);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		cidadeDAO.salvar(cidade1);
		cidadeDAO.salvar(cidade2);
		cidadeDAO.salvar(cidade3);
		cidadeDAO.salvar(cidade4);
	}

	@Test
	@Ignore
	public void listar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		System.out.println("\nTotal de registros encontrado(s): " + resultado.size());
		System.out.println("\n|||||||||| Cidades ||||||||||\n");
		for (Cidade cidade : resultado) {
			System.out.println("Código Registro Tabela: " + cidade.getId());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla: " + cidade.getEstado().getSigla());
			System.out.println("\n|||||||||||||||||||||||||||||\n");
		}
	}

	@Test
	@Ignore
	public void buscar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(6L);

		System.out.println("\n|||| Resultado da busca ||||");

		if (cidade == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			System.out.println("\n|||||||||| Cidade ||||||||||\n");
			System.out.println("Código Registro Tabela: " + cidade.getId());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla: " + cidade.getEstado().getSigla());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(3L);

		if (cidade == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			cidadeDAO.excluir(cidade);

			System.out.println("\nRegistro removido:\n");
			System.out.println("Código Registro Tabela: " + cidade.getId());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla: " + cidade.getEstado().getSigla());
		}
	}

	@Test
	@Ignore
	public void editar() {
		
		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(3L);

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(3L);

		if (cidade == null || estado == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			cidade.setNome("Campinas");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);

			System.out.println("\nRegistro alterado:\n");
			System.out.println("Código Registro Tabela: " + cidade.getId());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla: " + cidade.getEstado().getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscarPorEstado() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(1L);

		System.out.println("\nTotal de registros encontrado(s): " + resultado.size());
		System.out.println("\n|||||||||| Cidades por estado ||||||||||\n");
		for (Cidade cidade : resultado) {
			System.out.println("Código Registro Tabela: " + cidade.getId());
			System.out.println("Nome: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla: " + cidade.getEstado().getSigla());
			System.out.println("\n|||||||||||||||||||||||||||||\n");
		}
	}
}