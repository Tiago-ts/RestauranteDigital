package control;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.IPagamentoService;
import model.IPedidoService;
import model.Pedido;
import model.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@Named("pagar")
public class PagamentoCtrl implements Serializable{
	
	@Inject
	private IPagamentoService servPg;
	@Inject
	private IPedidoService servPed;
	private float valorPago;
	Pedido pedido;
	
	
	
	@PostConstruct
	public void init(Usuario user) {
		pedido.setIdUsuario(user.getIdUsuario());
		pedido = servPed.verificarPedido(pedido);
		
	}
	
	public void pagar(float pagamento, Pedido pedido) {
		System.out.println("o numero é "+pedido.getIdPedido()+pedido.getStatus());
		if(pagamento != valorPago) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ta querendo me enrolar?","valor não bate!"));
			
		}else if(pagamento == valorPago) {
			pedido.setStatus("FECHADO");
			
			servPg.realizarPagamento(pedido);
			FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Obrigado!",  "Pedido Fechado"));
	        
		}
		
	}
	
	
	
	public synchronized IPagamentoService getServPg() {
		return servPg;
	}

	public synchronized void setServPg(IPagamentoService servPg) {
		this.servPg = servPg;
	}

	public synchronized float getValorPago() {
		return valorPago;
	}

	public synchronized void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	
	
	
	
	

}
