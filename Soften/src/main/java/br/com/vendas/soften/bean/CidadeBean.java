package br.com.vendas.soften.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendas.soften.dao.CidadeDAO;
import br.com.vendas.soften.dao.EstadoDAO;
import br.com.vendas.soften.entity.Cidade;
import br.com.vendas.soften.entity.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;

	private CidadeDAO cidadeDAO;
	
	private EstadoDAO estadoDAO;
	
	private List<Cidade> cidades;

	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}
	
	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public void setCidadeDAO(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void iniciar() {
		 cidadeDAO = new CidadeDAO();
		 estadoDAO = new EstadoDAO();
	}

	public void listar() {
		try {
			cidades = cidadeDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as cidades.");
			erro.printStackTrace();

		}
	}

	public void novo() {
		try {
			cidade = new Cidade();
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova cidade.");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			cidadeDAO.merge(cidade);

			novo();
			
			estados = estadoDAO.listar("nome");
			cidades = cidadeDAO.listar("nome");

			Messages.addGlobalInfo("Cidade salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a cidade.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			cidadeDAO.excluir(cidade);
			cidades = cidadeDAO.listar("nome");
			Messages.addGlobalInfo("Cidade removida.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a cidade.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");

			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar a cidade.");
			erro.printStackTrace();
		}		
	}
}