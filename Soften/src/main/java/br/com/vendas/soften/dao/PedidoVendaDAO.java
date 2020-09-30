package br.com.vendas.soften.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.soften.entity.PedidoVenda;
import br.com.vendas.soften.entity.PedidoVendaItem;
import br.com.vendas.soften.util.HibernateUtil;

public class PedidoVendaDAO extends GenericDAO<PedidoVenda> {

	public void merge(PedidoVenda pedidoVenda, List<PedidoVendaItem> pedidoVendaItens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.save(pedidoVenda);

			for (int i = 0; i < pedidoVendaItens.size(); i++) {
				PedidoVendaItem pedidoVendaItem = pedidoVendaItens.get(i);
				pedidoVendaItem.setPedidoVenda(pedidoVenda);
				sessao.save(pedidoVendaItem);
			}

			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}