package model;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import config.HibernateUtil;



public class MesaDAO {

	
	public Mesa salvarMesa(Mesa mesa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(mesa);
			transaction.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			session.close();
		}
		return mesa;
		
		
		
		
		
	}
	
}
