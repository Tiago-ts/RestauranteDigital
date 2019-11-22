package model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IProdutoService
{
   public void Cadastrar(Produto produto);

public List<Produto> ListarProdutos();
}


