package br.com.vendas.soften.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_venda_itens")
public class PedidoVendaItem extends GenericEntity {

	private static final long serialVersionUID = 6992233732851456526L;

	@Column(precision = 14, scale = 4, nullable = false)
	private BigDecimal valorParcial;

	@Column(precision = 14, scale = 4, nullable = false)
	private BigDecimal quantidade;

	@ManyToOne
	@JoinColumn(name = "pedido_venda_codigo")
	private PedidoVenda pedidoVenda;

	@ManyToOne
	@JoinColumn(name = "produto_codigo")
	private Produto produto;

	public PedidoVendaItem() {

	}

	public PedidoVendaItem(BigDecimal valorParcial, BigDecimal quantidade, PedidoVenda pedidoVenda, Produto produto) {
		super();
		this.valorParcial = valorParcial;
		this.quantidade = quantidade;
		this.pedidoVenda = pedidoVenda;
		this.produto = produto;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}