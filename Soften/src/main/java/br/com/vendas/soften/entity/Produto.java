package br.com.vendas.soften.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto extends GenericEntity {

	private static final long serialVersionUID = 1508432923628529907L;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(precision = 14, scale = 4, nullable = false)
	private BigDecimal valorCusto;

	@Column(precision = 14, scale = 4, nullable = false)
	private BigDecimal valorVenda;

	public Produto() {

	}

	public Produto(String nome, BigDecimal valorCusto, BigDecimal valorVenda) {
		super();
		this.nome = nome;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}