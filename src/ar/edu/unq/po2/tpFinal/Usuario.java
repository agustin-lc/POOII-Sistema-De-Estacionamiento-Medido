package ar.edu.unq.po2.tpFinal;

public class Usuario {
	// private String nombre;
	private int celular;
	private String patente;
	private int saldo;
	private ModalidadEstacionamiento modalidad;
	private PuntoDeVenta p;
//Métodos:

	public void iniciarEstacionamiento(PuntoDeVenta p) {
		p.		
	}

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