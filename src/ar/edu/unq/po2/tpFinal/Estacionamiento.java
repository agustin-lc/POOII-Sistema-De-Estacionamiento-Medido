package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public abstract class Estacionamiento {
	protected String patente;
	protected LocalDateTime horaInicio;
	protected LocalDateTime horaFin;
	protected boolean estaVigente;

	// SETTERS
	protected void setPatente(String patente) {
		this.patente = patente;
	}

	protected void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	protected void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

	protected void setEstaVigente(boolean expresion) {
		this.estaVigente = expresion;

	}

	// GETTERS
	public LocalDateTime getHoraInicio() {
		return this.horaInicio;
	}

	public LocalDateTime getHoraFin() {
		return this.horaFin;
	}

	public String getPatente() {
		return patente;
	}

	public boolean estaVigente() {
		return false; // LO TOMAMOS COMO PREDETERMINADO QUE EL ESTACIONAMIENTO
	}

	public abstract void finalizar(LocalDateTime hora);

}
