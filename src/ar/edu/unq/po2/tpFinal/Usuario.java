package ar.edu.unq.po2.tpFinal;

public class Usuario {
	private int celular;
	private String patente;
	private int saldo;
	private IModoApp modalidad;
	private boolean notificacionesActivadas;

//Métodos:
	// CONSTRUCTOR
	public Usuario(int celular, String patente, int saldo, IModoApp modalidad) {
		this.celular = celular;
		this.patente = patente;
		this.saldo = saldo;
		this.modalidad = modalidad;
		this.notificacionesActivadas = true; // TOMAMOS COMO VALOR PREDETERMINADO QUE POSEE LAS NOTIFICACIONES ACTIVADAS
	}

	// GETTERS
	public String getPatente() {
		return patente;
	}

	public int getCelular() {
		return celular;
	}

	public int getSaldo() {
		return saldo;
	}

	public IModoApp getModalidad() {
		return modalidad;
	}

	public boolean getNotificacionesActivadas() {
		return notificacionesActivadas;
	}

	// SETTERS
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setModalidad(IModoApp modalidad) {
		this.modalidad = modalidad;
	}

	// METODOS
	public void activarODesactivarNotificaciones() {
		this.notificacionesActivadas = !notificacionesActivadas;
	}

	public void iniciarEstacionamientoManual(int horas, PuntoDeVenta punto) {
		punto.registrarCompraPuntual(horas, this.patente);
	}

}
