package model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue
	@Column(name = "idcliente")
	public int IdCliente;
	
	@Column(name = "nome", nullable = false)
	public String Nome;
	
	@Column(name = "cpf", nullable = false)
	public int Cpf;

	
	

	public Cliente(String nome, int cpf) {
		this.Nome = nome;
		this.Cpf = cpf;

	}




	public int getIdCliente() {
		return IdCliente;
	}




	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
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

	
}
