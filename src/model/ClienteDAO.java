package model;


import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.*;

@SuppressWarnings("serial")
@Stateless
public class ClienteDAO implements Serializable{
	
 
	public Cliente saveCliente(Cliente cliente)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cliente;
	}
 
	public Cliente getCliente(int clienteId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Cliente cliente = (Cliente) session.get(Cliente.class, clienteId);
			return cliente;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
public Cliente save(Cliente cliente){
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			
				
		}catch(Exception e){
				
				System.err.println(e);
				em.getTransaction().rollback();
				
		}finally{
				em.close();
				
			}
		return cliente;
			
		}

	
	
	
}



