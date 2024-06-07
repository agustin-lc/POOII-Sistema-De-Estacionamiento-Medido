package ar.edu.unq.po2.tpFinal;

public class Usuario {
	//private String nombre;
	private int celular;
	private String patente;


	
//Métodos:

	public void iniciarEstacionamientoManual(Estacionamiento estacionamiento,int horas) {
		estacionamiento.zona.iniciarEstacionamiento(estacionamiento,this.getPatente(), horas);
	}
	
	private Object getPatente() {
		return patente;
}

	public void    iniciarEstacionamientoCelular() {
	//celular.

		
	}
//    finalizarEstacionamiento()
}