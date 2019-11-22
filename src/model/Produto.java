package model;



import  javax.persistence.Entity;
import  javax.persistence.Id;
import  javax.persistence.Table;
import  javax.persistence.Column;
import javax.persistence.*;
@Entity
@Table(name="produto") 
public class Produto
{
    @Id 
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    @Column(name="idproduto")
    public int idproduto;
    @Column(name="nome", nullable=false)
    public String Nome;
    @Column(name="descricao", nullable=false)
    public String Descricao;     
    @Column(name="valor", nullable=false)
    public float Valor;
    
       
    public Produto(){}
        
    
    public int getIdproduto() {
		return idproduto;
	}


	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getDescricao() {
		return Descricao;
	}


	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	public float getValor() {
		return Valor;
	}


	public void setValor(float valor) {
		Valor = valor;
	}


	public Produto(String nome, String descricao, float valor){   
    	
        this.Nome = nome;
        this.Descricao = descricao;
        this.Valor = valor;
       
    }
      
}
