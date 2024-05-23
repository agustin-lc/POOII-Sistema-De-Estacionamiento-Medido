package ar.edu.unq.po2.tpFinal;

public class PuntoDeVenta {



	public void recargarCredito(Celular celular, double monto) {
	    celular.recargarSaldo(monto);
	    System.out.println("Se ha creditado el $" + monto);
	}
}
