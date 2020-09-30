package br.com.vendas.soften.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuarios")
public class Usuario extends GenericEntity {

	private static final long serialVersionUID = 8534915253502833566L;

	@Column(length = 40, nullable = false)
	private String nome;

	@Column(length = 10, nullable = false)
	private String login;

	@Column(length = 20, nullable = false)
	private String senha;

	@Transient
	private String senhaSemCriptografia;
	
	private boolean tipo;

	public Usuario() {

	}

	public Usuario(String nome, String login, String senha, boolean tipo) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		if (tipo) {
			tipoFormatado = "Admin";
		} else {
			tipoFormatado = "Usuário";
		}
		return tipoFormatado;
	}
}