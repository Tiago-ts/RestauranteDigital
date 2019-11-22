package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
	@Id
	@GeneratedValue
	@Column(name = "idFuncionario")
	public int IdFuncionario;
	@Column(name = "nome", nullable = false)
	public String Nome;
	@Column(name ="data-admissao")
	public String DataAdmissao;
	
	
	public int getIdFuncionario() {
		return IdFuncionario;
	}


	public void setIdFuncionario(int idFuncionario) {
		IdFuncionario = idFuncionario;
	}


	public Funcionario(String nome, String data) {
		this.Nome = nome;
		this.DataAdmissao = data;
		

	}
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataAdmissao() {
		return DataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao) {
		DataAdmissao = dataAdmissao;
	}
	

}
