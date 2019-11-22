package model;

import javax.persistence.EntityManager;


import model.Produt;
import model.ConnectionFactory;

public class ProdutoDAOO {
	
	public Produt save(Produt produto){
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try{
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
			
				
		}catch(Exception e){
				
				System.err.println(e);
				em.getTransaction().rollback();
				
		}finally{
				em.close();
				
			}
			return produto;
		}
	public Produt Editar(Produt produto){
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try{
			em.getTransaction().begin();
			
			if(produto.getId()== null){
				em.persist(produto);
			}else{
				em.merge(produto);
				
			}
			em.getTransaction().commit();
			
		}catch (Exception e){
			
			System.err.println(e);
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}
		return produto;
		
	}
	}


