package br.com.vendas.soften.util.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.soften.dao.EstadoDAO;
import br.com.vendas.soften.entity.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");

		Estado estado1 = new Estado();
		estado1.setNome("São Paulo");
		estado1.setSigla("SP");

		Estado estado2 = new Estado();
		estado2.setNome("Minas Gerais");
		estado2.setSigla("MG");

		Estado estado3 = new Estado();
		estado3.setNome("Santa Catarina");
		estado3.setSigla("SC");

		Estado estado4 = new Estado();
		estado4.setNome("Mato Grosso");
		estado4.setSigla("MT");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		estadoDAO.salvar(estado1);
		estadoDAO.salvar(estado2);
		estadoDAO.salvar(estado3);
		estadoDAO.salvar(estado4);

	}

	@Test
	@Ignore
	public void listar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("\nTotal de registros encontrado(s): " + resultado.size());
		System.out.println("\n|||||||||| Estados ||||||||||\n");
		for (Estado estado : resultado) {
			System.out.println("Código Registro Tabela: " + estado.getId());
			System.out.println("Nome: " + estado.getNome());
			System.out.println("Sigla: " + estado.getSigla());
			System.out.println("\n|||||||||||||||||||||||||||||\n");
		}
	}

	@Test
	@Ignore
	public void buscar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(6L);

		System.out.println("\n|||| Resultado da busca ||||");

		if (estado == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			System.out.println("\n|||||||||| Estado ||||||||||\n");
			System.out.println("Código Registro Tabela: " + estado.getId());
			System.out.println("Nome: " + estado.getNome());
			System.out.println("Sigla: " + estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(3L);

		if (estado == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			estadoDAO.excluir(estado);

			System.out.println("\nRegistro removido:\n");
			System.out.println("Código Registro Tabela: " + estado.getId());
			System.out.println("Nome: " + estado.getNome());
			System.out.println("Sigla: " + estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void editar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(3L);

		if (estado == null) {
			System.out.println("\nNenhum registro encontrado\n");
		} else {

			estado.setNome("Mato Grosso");
			estado.setSigla("MT");
			estadoDAO.editar(estado);

			System.out.println("\nRegistro alterado:\n");
			System.out.println("Código Registro Tabela: " + estado.getId());
			System.out.println("Nome: " + estado.getNome());
			System.out.println("Sigla: " + estado.getSigla());
		}
	}
}