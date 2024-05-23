package ar.edu.unq.po2.tpFinal;

public class Celular {
	private String numero;
	private Double saldo;
	
	public String getNumero() {
		return numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void recargarSaldo(double monto) {
		this.saldo += monto;
	}
		
}