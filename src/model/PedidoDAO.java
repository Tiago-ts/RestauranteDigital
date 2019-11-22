package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;

@SuppressWarnings("serial")
@Stateless
public class PedidoDAO implements Serializable {

	public Pedido salvarPedido(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(pedido);
			transaction.commit();
			System.out.println("id no DAO"+pedido.getIdPedido());
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pedido;
	}

	@SuppressWarnings("unchecked")
	public Pedido verificar(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql ="from Pedido where usuario_idusuario= :idUsuario and status= :status order by idpedido";
			System.out.println(pedido.getIdUsuario()+pedido.getStatus());
			List<Pedido> pedidos = session.createQuery(hql)
					.setParameter("idUsuario", pedido.getIdUsuario()).setParameter("status", pedido.getStatus()).list();

			if (pedidos.isEmpty() == true) {
				System.out.println("Usuario Não tem pedidos em Aberto");
				
			} else {
				System.out.println("Encontrei o pedido");
				pedido = pedidos.get(0);
				}
			
			return pedido;
		} catch (HibernateException e) {
			System.out.println("deu erro ----------" + e);
			// e.printStackTrace();
		} finally {
			session.close();
		}
		return pedido;
	}
	public Pedido pagarPedido(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			System.out.println("pedido é este "+pedido.getIdPedido());
			System.out.println(pedido.getStatus());
			transaction = session.beginTransaction();
			session.update(pedido);
			transaction.commit();
			
			return pedido;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
		return pedido;
		
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> listarPedidos(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Pedido> list = new ArrayList<>();
		try {
			list = session
					.createQuery("from Pedido where  usuario_idusuario= :idUsuario").setParameter("idUsuario", usuario.getIdUsuario()).list();
			
			
			return list;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------" + e);
		} finally {
			session.close();
		}
		return list;
	}
	

}
