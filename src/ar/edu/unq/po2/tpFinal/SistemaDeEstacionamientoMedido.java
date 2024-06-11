package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeEstacionamientoMedido {

	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	private LocalDateTime inicioFranja;
	private LocalDateTime cierreFranja;
	private List<ISuscriptor> suscriptores;
	private List<Infraccion> infracciones;
	private List<Estacionamiento> estacionamientosRegistrados;
	private double precioPorHora;
	private List<Compra> comprasRegistradas;

	public SistemaDeEstacionamientoMedido(LocalDateTime inicio, LocalDateTime fin, double precio) {
		this.setPrecioPorHora(precio);
		this.setCierreFranja(fin);
		this.setInicioFranja(inicio);
		zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
		suscriptores = new ArrayList<ISuscriptor>();
		infracciones = new ArrayList<Infraccion>();
		estacionamientosRegistrados = new ArrayList<Estacionamiento>();
		comprasRegistradas = new ArrayList<Compra>();
	}
	// GETTERS

	public List<ZonaDeEstacionamiento> getZonasDeEstacionamientos() {
		return zonasDeEstacionamiento;
	}

	public LocalDateTime getInicioFranja() {
		return inicioFranja;
	}

	public LocalDateTime getCierreFranja() {
		return cierreFranja;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public List<Inspector> getInspectores() {
		return zonasDeEstacionamiento.stream().map(zona -> zona.getInspector()).toList();
	}

	public List<List<PuntoDeVenta>> getPuntosDeVentas() {
		return zonasDeEstacionamiento.stream().map(zona -> zona.getPuntoDeVenta()).toList();
	}

	public List<Estacionamiento> getEstacionamientosVigentes() {
		return estacionamientosRegistrados.stream().filter(e -> e.estaVigente(LocalDateTime.now()))
				.collect(Collectors.toList());
	}

	// SETTERS
	public void setInicioFranja(LocalDateTime inicioFranja) {
		this.inicioFranja = inicioFranja;
	}

	public void setCierreFranja(LocalDateTime cierreFranja) {
		this.cierreFranja = cierreFranja;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public void añadirSuscriptor(ISuscriptor suscriptor) {
		this.suscriptores.add(suscriptor);
	}

	public void removerSuscriptor(ISuscriptor suscriptor) {
		if (suscriptores.contains(suscriptor)) {
			suscriptores.remove(suscriptor);
		}
	}

	// METHODS
	public void notificarSuscriptores() {
		suscriptores.forEach(sub -> sub.notificar());
	}

	public void añadirInfraccion(String patente, Inspector inspec) {
		LocalDateTime fechaYHoraActual = LocalDateTime.now();
		ZonaDeEstacionamiento zonaInspector = inspec.getZonaAsignada();
		Infraccion infraccion = new Infraccion(patente, fechaYHoraActual, inspec, zonaInspector);
		infracciones.add(infraccion);
		this.notificarSuscriptores();
	}

	public boolean poseeEstacionamientoVigente(String patente) {
		return this.estacionamientosRegistrados.stream().filter(est -> est.getPatente() == patente).toList().isEmpty();
	}

	public void finalizarEstacionamientos() {
		this.getEstacionamientosVigentes().stream().forEach(e -> e.finalizar(this.getCierreFranja()));
		this.notificarSuscriptores();
	}

	public void añadirCompra(Compra compra) {
		this.comprasRegistradas.add(compra);
		this.notificarSuscriptores();
	}

	public void añadirEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientosRegistrados.add(estacionamiento);
		this.notificarSuscriptores();
	}

}
