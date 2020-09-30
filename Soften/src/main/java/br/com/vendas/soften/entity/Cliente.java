package br.com.vendas.soften.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends GenericEntity {

	private static final long serialVersionUID = -6586942673569993093L;

	@Column(length = 60, nullable = false)
	private String nomeRazaoSocial;
	
	@Column(length = 14, nullable = false)
	private int cpfCnpj;
	
	@Column(length = 14, nullable = false)
	private String inscricaoEstadual;
	
	@Column(length = 8, nullable = false)
	private int cep;
	
	@Column(length = 60, nullable = false)
	private String logradouro;
	
	@Column(length = 6, nullable = false)
	private int numero;
	
	@Column(length = 60, nullable = false)
	private String bairro;
	
	@Column(length = 60)
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "cidade_codigo", nullable = false)	
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "estado_codigo", nullable = false)	
	private Estado estado;
	
	public Cliente() {

	}
	
	public Cliente(String nomeRazaoSocial, int cpfCnpj, String inscricaoEstadual, int cep, String logradouro, int numero,
			String bairro, String complemento, Cidade cidade, Estado estado) {
		super();
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.cpfCnpj = cpfCnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public int getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(int cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}