package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public class Infraccion {
	private String patente;
	private LocalDate fechaInfraccion;
	private Inspector inspector;
	private ZonaDeEstacionamiento zonaInfraccion;

	public Infraccion(String patente, LocalDate fecha, Inspector inspector, ZonaDeEstacionamiento zonaAsignada) {
		this.patente = patente;
		this.fechaInfraccion = fecha;
		this.inspector = inspector;
		this.zonaInfraccion = zonaAsignada;
	}

	public ZonaDeEstacionamiento getZonaInfraccion() {
		return zonaInfraccion;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public LocalDate getFechaInfraccion() {
		return fechaInfraccion;
	}

	public String getPatente() {
		return patente;
	}

}
