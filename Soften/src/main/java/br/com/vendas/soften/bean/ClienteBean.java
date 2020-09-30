package br.com.vendas.soften.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendas.soften.dao.CidadeDAO;
import br.com.vendas.soften.dao.ClienteDAO;
import br.com.vendas.soften.dao.EstadoDAO;
import br.com.vendas.soften.entity.Cidade;
import br.com.vendas.soften.entity.Cliente;
import br.com.vendas.soften.entity.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;

	private ClienteDAO clienteDAO;
	
	private Estado estado;
	
	private EstadoDAO estadoDAO;
	
	private CidadeDAO cidadeDAO;

	private List<Cliente> clientes;

	private List<Cidade> cidades;

	private List<Estado> estados;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}

	public void setCidadeDAO(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
		 clienteDAO = new ClienteDAO();
		 estadoDAO = new EstadoDAO();
		 cidadeDAO = new CidadeDAO();
	}
	
	public void listar() {
		try {
			clientes = clienteDAO.listar("nomeRazaoSocial");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes.");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cliente = new Cliente();
			estado = new Estado();
			estados = estadoDAO.listar("nome");
			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma novo cliente.");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			clienteDAO.merge(cliente);

			novo();

			estados = estadoDAO.listar("nome");
			cidades = cidadeDAO.listar();
			clientes = clienteDAO.listar("nomeRazaoSocial");

			Messages.addGlobalInfo("Cliente salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			clienteDAO.excluir(cliente);
			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Cliente removido.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Cliente não pode ser excluído!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			estados = estadoDAO.listar();
			cidades = cidadeDAO.listar();

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			estado = cliente.getCidade().getEstado();
			cidades = cidadeDAO.buscarPorEstado(cliente.getEstado().getId());			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o cliente.");
			erro.printStackTrace();
		}
	}

	public void popular() {

		try {
			if (cliente.getEstado() != null) {
				cidades = cidadeDAO.buscarPorEstado(cliente.getEstado().getId());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades.");
			erro.printStackTrace();
		}

	}
}