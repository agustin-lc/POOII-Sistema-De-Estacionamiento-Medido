package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;

public class Inspector {
	private int celular;
	private ZonaDeEstacionamiento zonaAsignada;
	private SistemaDeEstacionamientoMedido sem;

	public Inspector(int numero, ZonaDeEstacionamiento zona, SistemaDeEstacionamientoMedido sem) {
		this.celular = numero;
		this.zonaAsignada = zona;
		this.sem = sem;
	}

	public boolean validarEstacionamientoVigente(String patente) {
		boolean poseeEstacionamiento = sem.poseeEstacionamientoVigente(patente);

		if (!poseeEstacionamiento) {
			this.generarInfraccion(patente);
		}
		return poseeEstacionamiento;
	}

	public void generarInfraccion(String patente) {
		this.sem.añadirInfraccion(patente, this);
	}

	public int getCelular() {
		return celular;
	}

	public SistemaDeEstacionamientoMedido getSistema() {
		return sem;
	}

	public ZonaDeEstacionamiento getZonaAsignada() {
		return zonaAsignada;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public void setZonaAsignada(ZonaDeEstacionamiento zonaAsignada) {
		this.zonaAsignada = zonaAsignada;
	}

	public void setSem(SistemaDeEstacionamientoMedido sem) {
		this.sem = sem;
	}

}
