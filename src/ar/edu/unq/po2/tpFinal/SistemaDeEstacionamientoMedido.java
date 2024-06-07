package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeEstacionamientoMedido {

	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	private int inicioFranja;
	private int cierreFranja;
	private List<ISuscriptor> suscriptores;
	private List<Infraccion> infracciones;

	public List<Inspector> getInspectores() {
		return zonasDeEstacionamiento.stream().map(zona -> zona.getInspector()).toList();
	}

	public List<List<PuntoDeVenta>> getPuntosDeVentas() {
		return zonasDeEstacionamiento.stream().map(zona -> zona.getPuntoDeVenta()).toList();
	}

	public List<ZonaDeEstacionamiento> getZonasDeEstacionamientos() {
		return zonasDeEstacionamiento;
	}

	public List<Integer> getCreditosDeCelulares() {
		return null;
		// realizar un map sobre lista de estacionamientos realizados
	}

	public void añadirSuscriptor(ISuscriptor suscriptor) {
		this.suscriptores.add(suscriptor);
	}

	public void removerSuscriptor(ISuscriptor suscriptor) {
		if (suscriptores.contains(suscriptor)) {
			suscriptores.remove(suscriptor);
		}
	}

	public void notificarSuscriptores() {
		suscriptores.forEach(sub -> sub.notificar());
	}

	public int getInicioFranja() {
		return inicioFranja;
	}

	public int getCierreFranja() {
		return cierreFranja;
	}

	public void añadirInfraccion(String patente, Inspector inspec) {
		LocalDateTime fechaYHoraActual = LocalDateTime.now();
		ZonaDeEstacionamiento zonaInspector = inspec.getZonaAsignada();
		Infraccion infraccion = new Infraccion(patente, fechaYHoraActual, inspec, zonaInspector);
		infracciones.add(infraccion);
	}

	public boolean poseeEstacionamientoVigente(String patente) {
		return this.getZonasDeEstacionamientos().stream().filter(est -> est.estacionamientoDePatente(patente)).toList()
				.isEmpty();
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

}
