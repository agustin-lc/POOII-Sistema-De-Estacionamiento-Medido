package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {
	private int numeroDeCelular;

	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, LocalDateTime horaFin, int numero) {
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.numeroDeCelular = numero;
	}

	public int getNumeroDeCelular() {
		return numeroDeCelular;
	}

	@Override
	public void finalizar(LocalDateTime hora) {
		this.horaFin = hora;
		// this.estaVigente() = false;
	}

}
