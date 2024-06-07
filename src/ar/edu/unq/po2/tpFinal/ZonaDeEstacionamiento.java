package ar.edu.unq.po2.tpFinal;
import java.util.ArrayList;
import java.util.HashMap;

public class ZonaDeEstacionamiento {

	private ArrayList<PuntoDeVenta> puntoDeVenta = new ArrayList<PuntoDeVenta>();
	private ArrayList<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();

	public ArrayList<PuntoDeVenta> getPuntoDeVenta() {
		return puntoDeVenta;
	}
	
	public ArrayList<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public void iniciarEstacionamiento(Estacionamiento estacionamiento,String patente, int horas) {
		// TODO Auto-generated method stub
		if (estacionamientos.contains(estacionamiento)) {
			
		}
	}

	public void agregarEstacionamiento(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		estacionamientos.add(estacionamiento);
		}

}
