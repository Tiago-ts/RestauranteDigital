package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;

public class FuncionarioDAO {
	public Funcionario salvarFuncionario(Funcionario funcionario)
	{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try{
				transaction = session.beginTransaction();
				session.save(funcionario);
				transaction.commit();
				
			}catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		return funcionario;
		
	}
	public Funcionario getFuncionario(int funcionarioId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Funcionario funcionario = (Funcionario) session.get(Funcionario.class, funcionarioId);
			return funcionario;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
