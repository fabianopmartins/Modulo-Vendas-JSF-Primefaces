package br.com.vendas.soften.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendas.soften.dao.ClienteDAO;
import br.com.vendas.soften.dao.EstadoDAO;
import br.com.vendas.soften.dao.PedidoVendaDAO;
import br.com.vendas.soften.dao.ProdutoDAO;
import br.com.vendas.soften.entity.Cliente;
import br.com.vendas.soften.entity.Estado;
import br.com.vendas.soften.entity.PedidoVenda;
import br.com.vendas.soften.entity.PedidoVendaItem;
import br.com.vendas.soften.entity.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PedidoVendaBean implements Serializable {

	private PedidoVenda pedidoVenda;

	private PedidoVendaDAO pedidoVendaDAO;

	private PedidoVendaItem pedidoVendaItem;

	private Produto produto;

	private ProdutoDAO produtoDAO;

	private Cliente cliente;

	private ClienteDAO clienteDAO;

	private EstadoDAO estadoDAO;

	private List<PedidoVenda> pedidoVendas;

	private List<PedidoVendaItem> pedidoVendaItensSelecionados;

	List<PedidoVendaItem> pedidoVendaProdutos;

	private List<Cliente> clientes;

	private List<Estado> estados;

	private List<Produto> produtos;

	List<Estado> getEstados() {
		return estados;
	}

	void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public List<PedidoVendaItem> getPedidoVendaProdutos() {
		return pedidoVendaProdutos;
	}

	public void setPedidoVendaProdutos(List<PedidoVendaItem> pedidoVendaProdutos) {
		this.pedidoVendaProdutos = pedidoVendaProdutos;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public PedidoVendaDAO getPedidoVendaDAO() {
		return pedidoVendaDAO;
	}

	public void setPedidoVendaDAO(PedidoVendaDAO pedidoVendaDAO) {
		this.pedidoVendaDAO = pedidoVendaDAO;
	}

	public PedidoVendaItem getPedidoVendaItem() {
		return pedidoVendaItem;
	}

	public void setPedidoVendaItem(PedidoVendaItem pedidoVendaItem) {
		this.pedidoVendaItem = pedidoVendaItem;
	}

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

	Cliente getCliente() {
		return cliente;
	}

	void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public List<PedidoVendaItem> getPedidoVendaItensSelecionados() {
		return pedidoVendaItensSelecionados;
	}

	public void setPedidoVendaItensSelecionados(List<PedidoVendaItem> pedidoVendaItensSelecionados) {
		this.pedidoVendaItensSelecionados = pedidoVendaItensSelecionados;
	}

	public List<PedidoVenda> getPedidoVendas() {
		return pedidoVendas;
	}

	public void setPedidoVendas(List<PedidoVenda> pedidoVendas) {
		this.pedidoVendas = pedidoVendas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@PostConstruct
	public void iniciar() {
		pedidoVendaDAO = new PedidoVendaDAO();
		clienteDAO = new ClienteDAO();
		produto = new Produto();
		produtoDAO = new ProdutoDAO();
		pedidoVenda = new PedidoVenda();
	}

	public void listar() {
		try {
			pedidoVendas = pedidoVendaDAO.listar();
			clientes = clienteDAO.listar("nomeRazaoSocial");
			produtos = produtoDAO.listar("nome");
			pedidoVendaItensSelecionados = new ArrayList<>();
			pedidoVenda.setValorTotal(new BigDecimal("0.00"));
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os pedido de vendas.");
			erro.printStackTrace();
		}
	}

	public void novo() {
		pedidoVenda = new PedidoVenda();
		pedidoVenda.setValorTotal(new BigDecimal("0.00"));
		pedidoVendas = pedidoVendaDAO.listar();
		pedidoVendaItensSelecionados = new ArrayList<>();
		clientes = clienteDAO.listar("nomeRazaoSocial");
	}

	public void salvar() {
		try {

			if (pedidoVenda.getCliente() != null) {

				if (pedidoVenda.getValorTotal().signum() == 0) {
					Messages.addGlobalInfo("Insira ao menos um produto na venda!");
					return;
				} else {

					pedidoVendaDAO.merge(pedidoVenda, pedidoVendaItensSelecionados);

					novo();
					Messages.addGlobalInfo("Pedido de venda salvo com sucesso");
				}
			} else {
				Messages.addGlobalInfo("Campo Cliente é de preenchimento obrigatório!");
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o pedido de venda.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pedidoVenda = (PedidoVenda) evento.getComponent().getAttributes().get("pedidoVendaSelecionado");

			pedidoVendaDAO.excluir(pedidoVenda);
			pedidoVendas = pedidoVendaDAO.listar();
			novo();
			Messages.addGlobalInfo("Pedido de venda removido.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o pedido de venda.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pedidoVenda = (PedidoVenda) evento.getComponent().getAttributes().get("pedidoVendaSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o pedido de venda.");
			erro.printStackTrace();
		}
	}

	public void adicionaProduto(ActionEvent evento) {

		int produtoExiste = -1;

		for (int i = 0; i < pedidoVendaItensSelecionados.size(); i++) {
			if (pedidoVendaItensSelecionados.get(i).getProduto().equals(produto)) {
				produtoExiste = i;
			}
		}

		if (produtoExiste < 0) {

			if (produto != null) {
				pedidoVendaItem = new PedidoVendaItem();
				pedidoVendaItem.setId(produto.getId());
				pedidoVendaItem.setProduto(produto);
				pedidoVendaItem.setValorParcial(produto.getValorVenda());
				pedidoVendaItem.setQuantidade(new BigDecimal("1"));

				pedidoVendaItensSelecionados.add(pedidoVendaItem);

			} else {
				Messages.addGlobalInfo("Selecione um produto para inserção!");
			}
		} else {

			pedidoVendaItem = pedidoVendaItensSelecionados.get(produtoExiste);
			pedidoVendaItem.setValorParcial(
					produto.getValorVenda().multiply(pedidoVendaItem.getQuantidade().add(new BigDecimal("1"))));
			pedidoVendaItem.setQuantidade(pedidoVendaItem.getQuantidade().add(new BigDecimal("1")));

		}
		calcular();
	}

	public void excluiProduto(ActionEvent evento) {

		int produtoExiste = -1;

		if (pedidoVendaItem != null) {
			for (int i = 0; i < pedidoVendaItensSelecionados.size(); i++) {
				if (pedidoVendaItensSelecionados.get(i).getProduto().equals(pedidoVendaItem.getProduto())) {
					produtoExiste = i;
				}
			}

			if (produtoExiste > -1) {
				pedidoVendaItensSelecionados.remove(produtoExiste);
			}
		} else {
			Messages.addGlobalInfo("Selecione um produto para exclusão!");
		}
		calcular();

	}

	public void calcular() {
		pedidoVenda.setValorTotal(new BigDecimal("0.00"));

		for (int i = 0; i < pedidoVendaItensSelecionados.size(); i++) {
			PedidoVendaItem pedidoVendaItem = pedidoVendaItensSelecionados.get(i);
			pedidoVenda.setValorTotal(pedidoVenda.getValorTotal().add(pedidoVendaItem.getValorParcial()));
		}
	}
}