package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;

public class ReservaDAO {
	
	
	public Reserva salvarReserva(Reserva reserva) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(reserva);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			session.close();
			
		}
		
		return reserva;
		
	}

}
