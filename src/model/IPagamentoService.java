package model;

import javax.ejb.Local;

@Local
public interface IPagamentoService {

	public void realizarPagamento(Pedido pedido);
	
}
