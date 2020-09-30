package br.com.vendas.soften.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.vendas.soften.dao.UsuarioDAO;
import br.com.vendas.soften.entity.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	private UsuarioDAO usuarioDAO;
 	
	private List<Usuario> usuarios;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String logar(String login, String senha) {
		
		if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
			return "pagina-principal";
		}
		FacesContext ctx = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
		ctx.addMessage(null, msg);
		return "";
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
	}
	
	public void listar() {
		try {
			usuarios = usuarioDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuarios.");
			erro.printStackTrace();
		}
	}

	public void novo() {
		usuario = new Usuario();
	}

	public void salvar() {
		try {
			
			if(usuarioDAO.buscarPorSenha(usuario.getSenha()) != null) {						
				
				Messages.addGlobalInfo("Usuario já cadastrado");
			} else {
				usuarioDAO.merge(usuario);
				novo();
				usuarios = usuarioDAO.listar("nome");

				Messages.addGlobalInfo("Usuario salvo com sucesso");
				
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuario.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			usuarioDAO.excluir(usuario);
			usuarios = usuarioDAO.listar("nome");
			Messages.addGlobalInfo("Usuario removido.");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o usuario.");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o usuario.");
			erro.printStackTrace();
		}
	}
}