package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class Infraccion {
	private String patente;
	private LocalDateTime fechaInfraccion;
	private Inspector inspector;
	private ZonaDeEstacionamiento zonaInfraccion;

	public Infraccion(String patente, LocalDateTime fecha, Inspector inspector, ZonaDeEstacionamiento zonaAsignada) {
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

	public LocalDateTime getFechaInfraccion() {
		return fechaInfraccion;
	}

	public String getPatente() {
		return patente;
	}

}
