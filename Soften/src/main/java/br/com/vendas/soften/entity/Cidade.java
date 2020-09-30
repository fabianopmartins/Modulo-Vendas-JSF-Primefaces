package br.com.vendas.soften.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cidades")
public class Cidade extends GenericEntity {

	private static final long serialVersionUID = 6297704211934502289L;

	@Column(length = 70, nullable = false)
	private String nome;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "estado_codigo", nullable = false)
	private Estado estado;

	public Cidade() {

	}

	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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