package model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IComandaService {
	
	public void adicionarComanda(Comanda comanda);
	
	public List<Comanda> listar(int idPedido);
	
	public Comanda addQuantidade(Comanda comanda);
	
	public Comanda diminuirQuantidade(Comanda comanda);
	
	public void remover(Comanda comanda);
}
