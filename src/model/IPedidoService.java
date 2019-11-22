package model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IPedidoService {
	
	public Pedido cadastrar(Pedido pedido);
	public Pedido verificarPedido(Pedido pedido);
	public List<Pedido> listarPedidos(Usuario usuario);
	

}
