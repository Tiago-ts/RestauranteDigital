package model;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PagamentoService implements IPagamentoService{

	@Inject
	private PedidoDAO repPed;

	@Override
	public void realizarPagamento(Pedido pedido) {
try {
			
			repPed.pagarPedido(pedido);
			System.out.println("Peagamento Salva com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: "+e);
			// TODO: handle exception
		}
		
	}

}
