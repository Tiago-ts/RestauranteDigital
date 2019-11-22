package model;

import javax.persistence.*;

@Entity
@Table(name="mesa")
public class Mesa {
	
	@Id
	@GeneratedValue
	public int idMesa;
	@Column(name="quantidade-lugares")
	public int quantidadeLugares;
	
	
	public Mesa (int quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}
	
	
	
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getQuantidadeLugares() {
		return quantidadeLugares;
	}
	public void setQuantidadeLugares(int quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}
	
	
	
	

}
