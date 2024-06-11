package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public abstract class Compra {
	private double nroTicket;
	private PuntoDeVenta puntoDeCompra;
	private LocalDateTime fechaYHora;

	public double getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(double nroTicket) {
		this.nroTicket = nroTicket;
	}

	public PuntoDeVenta getPuntoDeCompra() {
		return puntoDeCompra;
	}

	public void setPuntoDeCompra(PuntoDeVenta puntoDeCompra) {
		this.puntoDeCompra = puntoDeCompra;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

}
