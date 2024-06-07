package ar.edu.unq.po2.tpFinal;

public class Estacionamiento {

	String patenteEstacionada;
	ZonaDeEstacionamiento zona;
	
	public Estacionamiento(ZonaDeEstacionamiento zona) {
		super();
		this.zona = zona;
		zona.agregarEstacionamiento(this);
	}
}
