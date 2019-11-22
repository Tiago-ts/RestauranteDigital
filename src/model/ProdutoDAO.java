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
public class ProdutoDAO implements Serializable
{
	public Produto saveProduto(Produto Produto)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(Produto);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Produto;
	}
 
	public Produto getProdutos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			/*
			List<Produto> produtos = session.createQuery("from Produto order by idproduto").list();
			return produtos;*/
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return getProdutos();
	}
	@SuppressWarnings("unchecked")
	public List<Produto> ListarProdutos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Produto> list = new ArrayList<>();
		try {
			
			list = session.createQuery("from Produto order by idproduto").list();
			
			System.out.println("Pegando todos os produtos DAO"+list.size());
			System.out.println("a");
			
			System.out.println("b");
			return list;
		} catch (HibernateException e) {
			System.out.println("Deu erro ---------"+e);
		}finally {
			
			session.close();
		}
        
     
   
         
        return list;
    }
 public static void main(String[] args) {
	ProdutoDAO p = new ProdutoDAO();
	p.ListarProdutos();
}
}

