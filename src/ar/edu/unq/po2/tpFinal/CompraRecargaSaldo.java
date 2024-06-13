package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class CompraRecargaSaldo extends Compra {
	private String nroCelular;
	private int montoARecargar;

	public CompraRecargaSaldo(double ticketAsignado, PuntoDeVenta punto, LocalDateTime fechayHoraDeRecarga,
			String nroDeCelularRecargado, int monto) {
		this.setNroTicket(ticketAsignado);
		this.setPuntoDeCompra(punto);
		this.setFechaYHora(fechayHoraDeRecarga);
		this.setNroCelular(nroDeCelularRecargado);
		this.montoARecargar = monto;

	}

	public int getMontoARecargar() {
		return montoARecargar;
	}

	public String getNroCelular() {
		return nroCelular;
	}

	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}

}
