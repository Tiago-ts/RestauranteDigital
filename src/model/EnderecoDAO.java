package model;


import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.*;
@Stateless
public class EnderecoDAO{
	
	public Endereco salvarEndereco(Endereco endereco)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			System.out.println(endereco.getIdEndereco());
			session.save(endereco).getClass();
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return endereco;
	}
 
	public Endereco getCliente(int enderecoId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Endereco endereco = (Endereco) session.get(Endereco.class, enderecoId);
			return endereco;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}