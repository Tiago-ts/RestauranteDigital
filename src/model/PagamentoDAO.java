package model;

import java.io.Serializable;

import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;

@SuppressWarnings("serial")
@Stateless
public class PagamentoDAO implements Serializable{
	
	public Pedido realizarPagamento(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(pedido);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pedido;
		
	}
	public Pagamento getPagamento(int pagamentoId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Pagamento Pagamento = (Pagamento) session.get(Pagamento.class, pagamentoId);
			return Pagamento;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	

}
