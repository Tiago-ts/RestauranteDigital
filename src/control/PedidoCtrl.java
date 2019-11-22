package control;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Comanda;
import model.IComandaService;
import model.IPedidoService;
import model.Pedido;
import model.Produto;
import model.Usuario;
import java.io.Serializable;
import java.sql.Date;


@SuppressWarnings("serial")
@SessionScoped
@Named("pedido")
public class PedidoCtrl implements Serializable {
	
	private Date data = new Date(System.currentTimeMillis());
	private String status;
	private String nomeProduto;
	private String descProduto;
	private float valor;
	Pedido ped = new Pedido();
	Usuario user;
	Comanda comanda = new Comanda();
	
	@Inject
	private IPedidoService servicePedido;
	
	@Inject 
	private IComandaService serviceComanda;
	

public static int getRandomIntegerBetweenRange(int min, int max){
    int x = (int)(Math.random()*((max-min)+1))+min;
    return x;
}
	public void imp(String nome) {
		System.out.println(nome);
	}
	public String goToPratos() {
		return "pratos.xhtml";
	}
	
	public void adicionarPedido(Produto produto, Usuario usuario) {
		user = usuario;
		ped.setIdUsuario(user.getIdUsuario());
		ped = servicePedido.verificarPedido(ped);

		nomeProduto = produto.getNome();
		descProduto = produto.getDescricao();
		valor = produto.getValor();
		
		ped.setIdUsuario(user.getIdUsuario());
		ped.setIdFuncionario(getRandomIntegerBetweenRange(1, 3));
		ped.setData(data);
		
		System.out.println("VAMO VE "+ped.getIdPedido());
		if(ped.getIdPedido() >= 1) {
			System.out.println("Localizou o  pedido");
			comanda.setIdPedido(ped.getIdPedido());
			comanda.setNome(produto.getNome());
			comanda.setDescricao(produto.getDescricao());
			comanda.setQuantidade(1);
			comanda.setValor(produto.getValor());
			System.out.println(ped.getIdPedido());
			serviceComanda.adicionarComanda(comanda);
			System.out.println("Item add na comanda.");
			
		}
		else if(ped.getIdPedido() == 0) {
			ped = servicePedido.cadastrar(ped);
			System.out.println("Pedido Criado !");
			comanda.setIdPedido(ped.getIdPedido());
			comanda.setNome(produto.getNome());
			comanda.setDescricao(produto.getDescricao());
			comanda.setQuantidade(1);
			comanda.setValor(produto.getValor());
			serviceComanda.adicionarComanda(comanda);
			System.out.println("Item add na comanda.");
			
		}
	
	}
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public String getDescProduto() {
		return descProduto;
	}


	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}

	public Pedido getPed() {
		return ped;
	}


	public void setPed(Pedido ped) {
		this.ped = ped;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public IPedidoService getServicePedido() {
		return servicePedido;
	}


	public void setServicePedido(IPedidoService servicePedido) {
		this.servicePedido = servicePedido;
	}

}
