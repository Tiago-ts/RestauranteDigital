package view;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Comanda;
import model.IComandaService;
import model.IPedidoService;
import model.Pedido;
import model.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@Named("Comanda")
public class ComandaGridView implements Serializable {
	@Inject
	private IPedidoService servPed;
	@Inject
	private IComandaService servComanda;
	Usuario user;
	Comanda com;
	Pedido pedido;
	private int numPed;
	private List<Comanda> comanda;
	

	public String getValorTotalDaComanda() {
		int total = 0;

		for (Comanda items : comanda) {
			total += items.getValor();
		}

		return new DecimalFormat("###,###.###").format(total);
	}

	public void addQuantidade(Comanda comanda) {

		servComanda.addQuantidade(comanda);
	}

	public void diminuirQuantidade(Comanda comanda) {

		servComanda.diminuirQuantidade(comanda);
	}

	public String goToComanda(Usuario user) {
		pedido.setIdUsuario(user.getIdUsuario());
		pedido = servPed.verificarPedido(pedido);
		numPed = pedido.getIdPedido();
		this.comanda = servComanda.listar(pedido.getIdPedido());

		return "comanda.xhtml";
	}
	
	public void remover(Comanda item) {
		servComanda.remover(item);
	}
	public IComandaService getServComanda() {
		return servComanda;
	}

	public void setServComanda(IComandaService servComanda) {
		this.servComanda = servComanda;
	}

	public List<Comanda> getComanda() {
		return comanda;
	}

	public void setComanda(List<Comanda> comanda) {
		this.comanda = comanda;
	}

	public synchronized IPedidoService getServPed() {
		return servPed;
	}

	public synchronized void setServPed(IPedidoService servPed) {
		this.servPed = servPed;
	}

	public synchronized Usuario getUser() {
		return user;
	}

	public synchronized void setUser(Usuario user) {
		this.user = user;
	}

	public synchronized Comanda getCom() {
		return com;
	}

	public synchronized void setCom(Comanda com) {
		this.com = com;
	}

	public synchronized Pedido getPedido() {
		return pedido;
	}

	public synchronized void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public synchronized int getNumPed() {
		return numPed;
	}

	public synchronized void setNumPed(int numPed) {
		this.numPed = numPed;
	}
	

}
