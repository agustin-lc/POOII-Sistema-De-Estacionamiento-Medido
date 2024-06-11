package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class CompraRecargaSaldo extends Compra {
	private int nroCelular;
	private int montoARecargar;

	public CompraRecargaSaldo(double ticketAsignado, PuntoDeVenta punto, LocalDateTime fechayHoraDeRecarga,
			int nroDeCelularRecargado, int monto) {
		this.setNroTicket(ticketAsignado);
		this.setPuntoDeCompra(punto);
		this.setFechaYHora(fechayHoraDeRecarga);
		this.setNroCelular(nroDeCelularRecargado);
		this.setMontoARecargar(monto);

	}

	public int getMontoARecargar() {
		return montoARecargar;
	}

	public void setMontoARecargar(int montoARecargar) {
		this.montoARecargar = montoARecargar;
	}

	public int getNroCelular() {
		return nroCelular;
	}

	public void setNroCelular(int nroCelular) {
		this.nroCelular = nroCelular;
	}

}
