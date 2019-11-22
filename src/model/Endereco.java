package model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue
	@Column(name = "idendereco")
	public int IdEndereco;
	@Column(name = "cidade", nullable = false)
	public String Cidade;
	@Column(name = "logradouro", nullable = false)
	public String Logradouro;
	@Column(name = "UF", nullable = false)
	public String UF;
	@Column(name = "cep", nullable = false)
	public String Cep;
	
	public Endereco(String cidade, String logradouro, String UF, String cep) {
		this.Cidade = cidade;
		this.Logradouro = logradouro;
		this.UF = UF;
		this.Cep = cep;
	}
	
	
	
	public int getIdEndereco() {
		return IdEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		IdEndereco = idEndereco;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	

	
	
	
}
