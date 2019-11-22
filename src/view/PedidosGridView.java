package view;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.IPedidoService;
import model.Pedido;
import model.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@Named("listarPedidos")
public class PedidosGridView  implements Serializable{
	
	@Inject
	private IPedidoService servPed;
	
	private int idpedido;
	private Date data;
	private int idFuncionario;
	private String status;
	private List<Pedido> todosPedidos;
	public synchronized List<Pedido> getTodosPedidos() {
		return todosPedidos;
	}

	public synchronized void setTodosPedidos(List<Pedido> todosPedidos) {
		this.todosPedidos = todosPedidos;
	}
	
	public void listarPedidos(Usuario usuario) {
		todosPedidos = servPed.listarPedidos(usuario);
	}
	
	public synchronized IPedidoService getServPed() {
		return servPed;
	}
	public synchronized void setServPed(IPedidoService servPed) {
		this.servPed = servPed;
	}
	public synchronized int getIdpedido() {
		return idpedido;
	}
	public synchronized void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public synchronized Date getData() {
		return data;
	}
	public synchronized void setData(Date data) {
		this.data = data;
	}
	public synchronized int getIdFuncionario() {
		return idFuncionario;
	}
	public synchronized void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public synchronized String getStatus() {
		return status;
	}
	public synchronized void setStatus(String status) {
		this.status = status;
	}

}
