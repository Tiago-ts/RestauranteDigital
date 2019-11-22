package model;


import model.Produt;
import model.ProdutoDAOO;

public class TesteProduto {
	
	public static void main(String[] args) {
		
		ProdutoDAOO dao = new ProdutoDAOO();
		Produt produto = new Produt();
		
		
		
	
		produto.setDescricao("Arroz");
		produto.setQuantidade(20);
		produto.setValor(4.5);
	//	produto.setCategoria(categoria);
		
		dao.save(produto);
		
	//	EDITAR
		//	produto.setId(1);
		//	produto.setDescricao("feijão");
		//	produto.setQuantidade(10);
		//	produto.setValor(9.5);
		//	produto.setCategoria(categoria);
		//	dao.Editar(produto);
}
}
