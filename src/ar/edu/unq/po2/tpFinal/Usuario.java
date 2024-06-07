package ar.edu.unq.po2.tpFinal;

public class Usuario {
	// private String nombre;
	private int celular;
	private String patente;
	private int saldo;
	private ModalidadEstacionamiento modalidad;

//Métodos:

	public void iniciarEstacionamientoManual(Estacionamiento estacionamiento, int horas) {
		estacionamiento.zona.iniciarEstacionamiento(estacionamiento, this.getPatente(), horas);
	}

	private Object getPatente() {
		return patente;
	}

	public void iniciarEstacionamientoCelular() {
		// celular.

	}
//    finalizarEstacionamiento()

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