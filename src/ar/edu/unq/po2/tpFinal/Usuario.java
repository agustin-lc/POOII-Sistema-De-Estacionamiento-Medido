package ar.edu.unq.po2.tpFinal;

public class Usuario {
	private int celular;
	private String patente;
	private int saldo;
	private IModoApp modalidad;
	private boolean notificacionesActivadas;

//Métodos:
	// <<<<<<< HEAD
// REVISAR
	// public void iniciarEstacionamientoManual(Estacionamiento estacionamiento, int
	// horas) {
	// estacionamiento.zona.iniciarEstacionamiento(estacionamiento,
	// this.getPatente(), horas);
	// }

	public String getPatente() {
		return patente;
	}

	public int getCelular() {
		return celular;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public IModoApp getModalidad() {
		return modalidad;
	}

	public void setModalidad(IModoApp modalidad) {
		this.modalidad = modalidad;
	}

	public boolean getNotificacionesActivadas() {
		return notificacionesActivadas;
	}

	public void activarODesactivarNotificaciones() {
		this.notificacionesActivadas = !notificacionesActivadas;
	}
}
