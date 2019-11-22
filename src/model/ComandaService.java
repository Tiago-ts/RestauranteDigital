package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ComandaService implements IComandaService {
	
	@Inject
	private ComandaDAO repComanda;
	@Override
	public void adicionarComanda(Comanda comanda) {
		try {
		repComanda.addComanda(comanda);
		System.out.println("Comanda adicionada");
		}catch (Exception e) {
			System.out.println("deu erro "+e);
		}
		
	}



	@Override
	public List<Comanda> listar(int idPedido) {
		List<Comanda> list = new ArrayList<>(); 
		list = repComanda.listarItensComanda(idPedido);
		return list;
	}



	@Override
	public Comanda addQuantidade(Comanda comanda) {
		repComanda.addQuantidade(comanda);
		
		return comanda;
		
	}



	@Override
	public Comanda diminuirQuantidade(Comanda comanda) {
		repComanda.diminuirQuantidade(comanda);
		return comanda;
	}



	@Override
	public void remover(Comanda comanda) {
		repComanda.remover(comanda);
		
	}

}
