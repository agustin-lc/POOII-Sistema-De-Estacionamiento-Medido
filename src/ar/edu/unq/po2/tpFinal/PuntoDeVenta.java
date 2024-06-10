package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class PuntoDeVenta {

	private SistemaDeEstacionamientoMedido sem;

	public void recargarCredito(int celular, int monto) {
		sem.añadirCompra(new CompraRecargaSaldo(1234, this, LocalDateTime.now(), celular, monto));
		System.out.println("Se ha creditado el $" + monto);
	}

	public void registrarCompraPuntual() {
		//ACA SE DEBE HACER EL NEW PERO DE COMPRAESTACIONAMIENTO TODAVIA PENDIENTE
		//sem.añadirCompra(new Compra);
	}
}
