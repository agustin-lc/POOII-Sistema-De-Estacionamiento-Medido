package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class PuntoDeVenta {
	private SistemaDeEstacionamientoMedido sem;
	// CONSTRUCTOR
	public PuntoDeVenta(SistemaDeEstacionamientoMedido sem) {
		this.sem = sem;
	}

	// METODOS
	public double getNumeroTicketRandom() {
		// Numero de control
		return Math.random();
	}

	public void recargarCredito(String celular, int monto) {
		sem.getCelulares(celular).agregarSaldo(monto);
		sem.añadirCompra(
				new CompraRecargaSaldo(this.getNumeroTicketRandom(), this, LocalDateTime.now(), celular, monto));
		System.out.println("Se ha creditado el $" + monto);
	}
	public void registrarCompraPuntual(int horas, String patente) {
		this.registrarEstacionamiento(horas, patente);
		CompraEstacionamiento ticketEstacionamiento = new CompraEstacionamiento(this.getNumeroTicketRandom(), this,
				LocalDateTime.now(), horas);
		sem.añadirCompra(ticketEstacionamiento);
	}
	private void registrarEstacionamiento(int horas, String patente) {
		EstacionamientoCompraPuntual estacionamiento = new EstacionamientoCompraPuntual(patente, LocalDateTime.now(),
				LocalDateTime.now().plusHours(horas), horas);
		sem.añadirEstacionamiento(estacionamiento);
	}
}
