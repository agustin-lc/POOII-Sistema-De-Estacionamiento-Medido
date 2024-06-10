package ar.edu.unq.po2.tpFinal;

public class Usuario {
	// private String nombre;
	private int celular;
	private String patente;
	private int saldo;
	private ModalidadEstacionamiento modalidad;
	private PuntoDeVenta p;
//Métodos:
	// <<<<<<< HEAD
// REVISAR
	// public void iniciarEstacionamientoManual(Estacionamiento estacionamiento, int
	// horas) {
	// estacionamiento.zona.iniciarEstacionamiento(estacionamiento,
	// this.getPatente(), horas);
	// }

	public void iniciarEstacionamiento(PuntoDeVenta p) {
		modalidad.iniciarEstacionamiento();
	}
	// >>>>>>> refs/remotes/origin/main

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

	public ModalidadEstacionamiento getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadEstacionamiento modalidad) {
		this.modalidad = modalidad;
	}
}