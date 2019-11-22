package control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Cliente;
import model.Endereco;
import model.IClienteService;
import model.IEnderecoService;
import model.IUsuarioService;
import model.Usuario;

@SuppressWarnings("serial")
@SessionScoped
@Named("cadastro")
public class CadastroCtrl implements Serializable {
	@Inject
	private IClienteService cli;
	private Cliente cliente = new Cliente(null, 0);
	private String nome;
	private int cpf;
	@Inject
	private IEnderecoService servicoEnd;
	private String cidade;
	private String logradouro;
	private String uf;
	private String cep;
	private Endereco end = new Endereco(null, null, null, null);
	
	@Inject
	private IUsuarioService userService;
	private Usuario usuario;// =Usuario.getInstance();
	private String login;
	private String senha;
	private int idCliente;
	private int idEndereco;
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String cadastrar() {
		System.out.println("Chego no cadastrar cadasrt");
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		System.out.println("Chego no cadastrar cadasrt");
		System.out.println("Chego no cadastrar cadasrt");
		cli.Cadastrar(cliente);
		System.out.println("Chego no cadastrar cadasrt");
		usuario.setIdCliente(cliente.getIdCliente());
		System.out.println("CAdastrou cliente");
		FacesMessage msg = new FacesMessage("Cliente cadastrado", nome);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Chego no cadastrar cadas22rt");
		end.setCidade(cidade);
		end.setLogradouro(logradouro);
		System.out.println("Chego no cadastrar cadas222rt");
		end.setUF(uf);
		end.setCep(cep);
		servicoEnd.Cadastrar(end);
		usuario.setIdEndereco(end.getIdEndereco());
		System.out.println("CAdastrou end");
		usuario.setLogin(this.login);
		usuario.setSenha(this.senha);
		userService.cadastrar(usuario);
		System.out.println("CAdastrou usuario");
		return null;
	}

	public IClienteService getCli() {
		return cli;
	}

	public void setCli(IClienteService cli) {
		this.cli = cli;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public IEnderecoService getServicoEnd() {
		return servicoEnd;
	}

	public void setServicoEnd(IEnderecoService servicoEnd) {
		this.servicoEnd = servicoEnd;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public IUsuarioService getUserService() {
		return userService;
	}

	public void setUserService(IUsuarioService userService) {
		this.userService = userService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

