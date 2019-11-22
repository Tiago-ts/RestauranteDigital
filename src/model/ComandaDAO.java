package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.HibernateUtil;

@SuppressWarnings("serial")
@Stateless
public class ComandaDAO implements Serializable {
	public Comanda addComanda(Comanda comanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(comanda).getClass();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return comanda;
	}

	@SuppressWarnings("unchecked")
	public List<Comanda> listarItensComanda(int idPedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Comanda> list = new ArrayList<>();
		try {
			System.out.println(idPedido);
			list = session
					.createQuery("from Comanda where pedido_idpedido = :idPedido").setParameter("idPedido", idPedido).list();
			
			
			System.out.println("Pegando a comanda do DAO" + list.size());
			return list;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
		return list;
	}
	public Comanda addQuantidade(Comanda comanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			System.out.println(comanda.getQuantidade());
			comanda.setQuantidade(comanda.getQuantidade()+1);
			System.out.println(comanda.getQuantidade());
			transaction = session.beginTransaction();
			session.update(comanda);
			transaction.commit();
			
			return comanda;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
		
		return comanda;
	}
	public Comanda diminuirQuantidade(Comanda comanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			System.out.println(comanda.getQuantidade());
			if(comanda.getQuantidade() >= 1){
				comanda.setQuantidade(comanda.getQuantidade()-1);
			}else{
				comanda.setQuantidade(0);
			}
			
			System.out.println(comanda.getQuantidade());
			transaction = session.beginTransaction();
			session.update(comanda);
			transaction.commit();
			
			return comanda;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
		
		return comanda;
	}
	public void remover(Comanda comanda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(comanda);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
	}
	public static void main(String[] args) throws SQLException {
		ComandaDAO c = new ComandaDAO();
		c.listarItensComanda(33);
	}
}
