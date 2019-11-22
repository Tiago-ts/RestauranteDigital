package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido_produto")
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="pedido_idpedido")
	private int idPedido;
	@Column(name="nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "quantidade")
	private int quantidade;
	@Column(name = "valor")
	private float valor;

	
	
	public Comanda() {}
	public Comanda (int idPedido, int quantidade, float valor) {
		this.idPedido = idPedido;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public synchronized Long getId() {
		return id;
	}
	public synchronized void setId(Long id) {
		this.id = id;
	}
	public synchronized int getIdPedido() {
		return idPedido;
	}
	public synchronized void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public synchronized String getNome() {
		return nome;
	}
	public synchronized void setNome(String nome) {
		this.nome = nome;
	}
	public synchronized String getDescricao() {
		return descricao;
	}
	public synchronized void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public synchronized int getQuantidade() {
		return quantidade;
	}
	public synchronized void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public synchronized float getValor() {
		return valor;
	}
	public synchronized void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
}
