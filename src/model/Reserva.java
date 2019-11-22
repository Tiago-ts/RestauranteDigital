package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue
	public int idReserva;
	@Column(name="hora-data")
	public Date horaData;
	@Column(name="idUsuario")
	public int idUsuario;
	@Column(name="mesa_idmesa")
	public int idMesa;
	
	public Reserva(Date horadata, int idusuario, int idmesa) {
		this.horaData = horadata;
		this.idUsuario = idusuario;
		this.idMesa = idmesa;
		
		
	}
	
	
	
	
	
	
	
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Date getHoraData() {
		return horaData;
	}
	public void setHoraData(Date horaData) {
		this.horaData = horaData;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
}

