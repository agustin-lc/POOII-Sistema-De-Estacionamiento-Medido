package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {
	private int cantidadHoras;

	public EstacionamientoCompraPuntual(String patente, LocalDateTime horaInicio, LocalDateTime horaFin, int cantidad) {
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.cantidadHoras = cantidad;
	}

	@Override
	public void finalizar(LocalDateTime hora) {
		// TODO Auto-generated method stub

	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

}
