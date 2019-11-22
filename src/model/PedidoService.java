package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
@Stateless
public class PedidoService implements IPedidoService {

	@Inject
	private PedidoDAO pedidoDAO;
	@Override
	public Pedido cadastrar(Pedido pedido) {
		try {
			this.pedidoDAO.salvarPedido(pedido);
			System.out.println("pedido Salvo com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro:" + e);
		}
		System.out.println("id no service"+pedido.getIdPedido());
		return pedido;
	}

	public synchronized PedidoDAO getPedidoDAO() {
		return pedidoDAO;
	}

	public synchronized void setPedidoDAO(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}

	@Override
	public Pedido verificarPedido(Pedido pedido) {
		
		return pedidoDAO.verificar(pedido);
		
		
		
	}

	@Override
	public List<Pedido> listarPedidos(Usuario usuario) {
		
		return pedidoDAO.listarPedidos(usuario);
	}
}
