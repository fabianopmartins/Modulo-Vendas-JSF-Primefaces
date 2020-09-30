package br.com.vendas.soften.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.vendas.soften.dao.UsuarioDAO;
import br.com.vendas.soften.entity.Usuario;

@WebListener
public class InicializacaoListener implements ServletContextListener {
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
		
        UsuarioDAO usuario = new UsuarioDAO();
        
        System.out.println("Verificando se existe usuário padrão (Admin)!");
        
        if(usuario.buscarPorSenha("@Admin2020") != null ){
        	System.out.println("Usuário padrão (Admin) encontrado!");
        } else {
        	System.out.println("Usuário padrão (Admin) não encontrado!");
        	System.out.println("Criando usuário padrão (Admin)!");
        	
        	Usuario usuarioAdmin = new Usuario();
        	usuarioAdmin.setNome("Soften");
        	usuarioAdmin.setLogin("Admin");        	
        	usuarioAdmin.setSenha("@Admin2020");
        	usuarioAdmin.setTipo(true);
        	
        	usuario.salvar(usuarioAdmin);
        	
        	System.out.println("Usuário padrão (Admin) criado!");
        }
    }
 
	@Override
    public void contextDestroyed(ServletContextEvent event) {
    }	
}