package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {
	private int cantidadHoras;
	// CONSTRUCTOR
	public EstacionamientoCompraPuntual(String patente, LocalDateTime localDateTime, LocalDateTime localDateTime2,
			int cantidad, SistemaDeEstacionamientoMedido sem) {
		this.patente = patente;
		this.horaInicio = localDateTime;
		this.horaFin = localDateTime2;
		this.cantidadHoras = cantidad;
		this.sem = sem;
	}
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	@Override
	public void finalizar(LocalDateTime hora) {
		this.setEstaVigente(false);
		this.setHoraFin(hora);
	}

}