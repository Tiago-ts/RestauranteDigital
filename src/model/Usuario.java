package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuario")
public class Usuario {

	
	
	@Id
	@GeneratedValue
	public int idUsuario;
	@Column(name="login")
	public String login;
	@Column(name="senha")
	public String senha;
	@Column(name="cliente_idcliente")
	public int idCliente;
	@Column(name="endereco_idendereco")
	public int idEndereco;
	@Transient
	public boolean val;
	
//	private static Usuario instancia;
//	
//	public static Usuario getInstance() {
//		if(instancia == null) {
//			instancia = new Usuario();
//			
//		}
//		return instancia;
//	}
//	
	

	
	
//	private Usuario() {}
	public Usuario(String login, String senha,int idcliente, int idendereco) {
		
		this.login = login;
		this.senha = senha;
		this.idCliente = idcliente;
		this.idEndereco = idendereco;
		
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized boolean isVal() {
		return val;
	}
	public synchronized void setVal(boolean val) {
		this.val = val;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	
}
