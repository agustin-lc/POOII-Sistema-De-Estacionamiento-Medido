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

	public boolean estacionamientoVigente(String patente) {
		return sem.getZonasDeEstacionamientos().stream().anyMatch(s -> s.estacionamientoDePatente(patente));
	}

	public void generarInfraccion(String patente) {
		if (!this.estacionamientoVigente(patente)) {
			Infraccion infraccion = new Infraccion(patente, LocalDate.now(), this, zonaAsignada);
			sem.añadirInfraccion(infraccion);
		}
	}

	public int getCelular() {
		return celular;
	}
}
