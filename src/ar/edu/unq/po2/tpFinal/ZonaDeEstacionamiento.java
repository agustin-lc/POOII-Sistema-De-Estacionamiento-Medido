package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZonaDeEstacionamiento {

	private List<PuntoDeVenta> puntosDeVentas;
	private Inspector inspector;

	public ZonaDeEstacionamiento(Inspector inspec) {
		this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
		this.inspector = inspec;
	}

	public List<PuntoDeVenta> getPuntoDeVenta() {
		return puntosDeVentas;
	}



	public Inspector getInspector() {
		return inspector;
	}




}
