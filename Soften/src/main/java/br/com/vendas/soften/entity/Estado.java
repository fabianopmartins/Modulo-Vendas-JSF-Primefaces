package br.com.vendas.soften.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "estados")
public class Estado extends GenericEntity {

	private static final long serialVersionUID = -4920390791852197048L;

	@Column(length = 2, nullable = false)
	private String sigla;

	@Column(length = 70, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "estado", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Cidade> cidadess;

	public Estado() {
	
	}

	public Estado(String sigla, String nome, List<Cidade> cidadess) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.cidadess = cidadess;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidadess() {
		return cidadess;
	}

	public void setCidadess(List<Cidade> cidadess) {
		this.cidadess = cidadess;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}