package br.com.vendas.soften.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "pedido_venda")
public class PedidoVenda extends GenericEntity {

	private static final long serialVersionUID = 2899240064135888515L;

	@Column(precision = 12, scale = 2, nullable = false)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "cliente_codigo", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "pedidoVenda", fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private List<PedidoVendaItem> pedidoVendaItens;

	public PedidoVenda() {

	}

	public PedidoVenda(BigDecimal valorTotal, Cliente cliente, List<PedidoVendaItem> pedidoVendaItens) {
		super();
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.pedidoVendaItens = pedidoVendaItens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoVendaItem> getPedidoVendaItens() {
		return pedidoVendaItens;
	}

	public void setPedidoVendaItens(List<PedidoVendaItem> pedidoVendaItens) {
		this.pedidoVendaItens = pedidoVendaItens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}