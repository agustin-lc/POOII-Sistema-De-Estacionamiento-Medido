package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZonaDeEstacionamiento {

	private List<PuntoDeVenta> puntosDeVentas;
	private List<Estacionamiento> estacionamientos;
	private Inspector inspector;

	public ZonaDeEstacionamiento(Inspector inspec) {
		this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.inspector = inspec;
	}

	public List<PuntoDeVenta> getPuntoDeVenta() {
		return puntosDeVentas;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void iniciarEstacionamiento(Estacionamiento estacionamiento, Object object, int horas) {
		// TODO Auto-generated method stub
		if (estacionamientos.contains(estacionamiento)) {

		}
	}

	public void agregarEstacionamiento(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		estacionamientos.add(estacionamiento);
	}
	
	public boolean estacionamientoDePatente(String patente) {
		return estacionamientos.contains(patente);
	}

}
