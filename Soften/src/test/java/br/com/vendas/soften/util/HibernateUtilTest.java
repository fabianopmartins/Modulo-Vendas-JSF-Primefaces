package br.com.vendas.soften.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
	}
}