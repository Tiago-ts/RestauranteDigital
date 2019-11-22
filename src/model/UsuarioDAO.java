package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.criterion.Restrictions;
/*
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
*/
import config.HibernateUtil;

@SuppressWarnings("serial")
@Stateless
public class UsuarioDAO implements Serializable {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public Usuario salvarUsuario(Usuario usuario) {
		try {
			transaction = session.beginTransaction();
			session.save(usuario);
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public Usuario buscar(String login, String senha) {
		Usuario  userObjeto = new Usuario();// =Usuario.getInstance();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Usuario> usuarios = (List<Usuario>) session.createCriteria(Usuario.class)
					.add(Restrictions.ilike("login", login)).list();
			List<Usuario> usuarios1 = (List<Usuario>) session.createCriteria(Usuario.class)
					.add(Restrictions.ilike("senha", senha)).list();
			userObjeto = usuarios.get(0);
			if (usuarios.isEmpty() == true || usuarios1.isEmpty() == true) {
				System.out.println("Usuario ou senha não cadastrado");
				userObjeto.setVal(false); 
			} else {
				System.out.println("Encontrei o login");
				userObjeto.setVal(true);
			}

			return userObjeto;
		} catch (HibernateException e) {
			System.out.println("deu erro ----------" + e);
		} finally {
			session.close();
		}
		return userObjeto;

	}

}
