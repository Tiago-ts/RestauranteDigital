package control;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.Cliente;
import model.IClienteService;


@SuppressWarnings("serial")
@SessionScoped
@Named("cliente")

public class ClienteCtrl implements Serializable{
	
	
	
	/**
	 * 
	 */
	private String Nome;
	private int Cpf;
	@Inject
	private IClienteService cli;
	
	public void reset() {
		cli.reset(this.Nome, this.Cpf);
		

	}

	public String cadastrarCliente() {
		Cliente cliente = new Cliente(null, 0);
		System.out.println("Chego no cadastrar");
		cliente.setNome(this.Nome);
		cliente.setCpf(this.Cpf);
		cli.Cadastrar(cliente);
		FacesMessage msg = new FacesMessage("Cliente cadastrado", Nome);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		reset();

		return null;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getCpf() {
		return Cpf;
	}

	public void setCpf(int cpf) {
		Cpf = cpf;
	}

	public IClienteService getCli() {
		return cli;
	}

	public void setCli(IClienteService cli) {
		this.cli = cli;
	}



	
	
	
	
}
