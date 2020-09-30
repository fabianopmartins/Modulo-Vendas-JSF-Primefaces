package br.com.vendas.soften.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.vendas.soften.bean.AutenticacaoBean;
import br.com.vendas.soften.entity.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		String paginaAtual = Faces.getViewId();
		
		boolean paginaDeAutenticacao = paginaAtual.contains("login.xhtml");
		
		if(!paginaDeAutenticacao) {
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			if(autenticacaoBean == null) {
				Faces.navigate("/pages/login.xhtml");
				return;
			}
			
			Usuario usuario = autenticacaoBean.getUsuarioLogado();
			
			if(usuario == null) {
				Faces.navigate("/pages/login.xhtml");
				return;
			}
		}
	}
	
	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}