package ar.edu.unq.po2.tpFinal;

public class Usuario {
	//private String nombre;
	private Celular celular;
	private Vehiculo vehiculo;


	
//Métodos:

	public void iniciarEstacionamientoManual(Estacionamiento estacionamiento,int horas) {
		estacionamiento.zona.iniciarEstacionamiento(estacionamiento,this.vehiculo.getPatente(), horas);
	}
	
	public void    iniciarEstacionamientoCelular() {
	//celular.

		
	}
//    finalizarEstacionamiento()
}