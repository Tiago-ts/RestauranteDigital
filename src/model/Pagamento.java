package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue
	public int idPagamento;
	@Column(name="data-pagamento")
	public Date dataPagamento;
	@Column(name="tipo")
	public String tipo;
	@Column(name="usuario_idusuario")
	public int idUsuario;
	
	public Pagamento (int idPagamento, Date dataPagamento, String tipo, int idUsuario) {
		this.idPagamento = idPagamento;
		this.dataPagamento = dataPagamento;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}
	
	
	
	
	
	
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	
}
