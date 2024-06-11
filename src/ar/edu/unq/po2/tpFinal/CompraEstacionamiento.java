package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class CompraEstacionamiento extends Compra {
	private int cantHoras;

	public CompraEstacionamiento(double ticketAsignado, PuntoDeVenta punto, LocalDateTime fechayHoraDeRecarga,
			int horas) {
		this.setNroTicket(ticketAsignado);
		this.setPuntoDeCompra(punto);
		this.setFechaYHora(fechayHoraDeRecarga);
		this.setCantHoras(horas);
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

}
