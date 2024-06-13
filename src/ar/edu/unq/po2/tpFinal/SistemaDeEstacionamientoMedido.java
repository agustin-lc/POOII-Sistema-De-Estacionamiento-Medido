package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaDeEstacionamientoMedido {

	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	private LocalDateTime inicioFranja;
	private LocalDateTime cierreFranja;
	private LocalDateTime horario;
	private List<ISuscriptor> suscriptores;
	private List<Infraccion> infracciones;
	private List<Estacionamiento> estacionamientosRegistrados;
	private List<EstacionamientoViaApp> celulares;

	private double precioPorHora;
	private List<Compra> comprasRegistradas;

	public SistemaDeEstacionamientoMedido() {
		this.setPrecioPorHora(40.00);
		this.setCierreFranja(LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 0))); // finaliza a las 20:00
		this.setInicioFranja(LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 0))); // inicia a las 07:00
		this.horario = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0));
		zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
		suscriptores = new ArrayList<ISuscriptor>();
		infracciones = new ArrayList<Infraccion>();
		estacionamientosRegistrados = new ArrayList<Estacionamiento>();
		comprasRegistradas = new ArrayList<Compra>();

	}
	public void avanzarHorario(int horas) {
	horario = horario.plusHours(horas);
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	// GETTERS

	public List<Estacionamiento> getEstacionamientosRegistrados() {
		return estacionamientosRegistrados;
	}

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
		return estacionamientosRegistrados.stream().filter(e -> e.estaVigente()).collect(Collectors.toList());
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

	public void notificarInicioEstacionamiento() {
		suscriptores.forEach(sub -> sub.notificarInicioEstacionamiento());
	}

	public void notificarFinEstacionamiento() {
		suscriptores.forEach(sub -> sub.notificarFinEstacionamiento());
	}

	public void añadirInfraccion(String patente, Inspector inspec) {
		LocalDateTime fechaYHoraActual = LocalDateTime.now();
		ZonaDeEstacionamiento zonaInspector = inspec.getZonaAsignada();
		Infraccion infraccion = new Infraccion(patente, fechaYHoraActual, inspec, zonaInspector);
		infracciones.add(infraccion);
	}

	public boolean poseeEstacionamientoVigente(String patente) {
		return this.estacionamientosRegistrados.stream().filter(est -> est.getPatente() == patente).toList().isEmpty();
	}

	public void finalizarEstacionamientos() {
		this.getEstacionamientosVigentes().stream().forEach(e -> e.finalizar(this.getCierreFranja()));
		this.notificarFinEstacionamiento();
	}

	public void añadirCompra(Compra compra) {
		this.comprasRegistradas.add(compra);
	}

	public void añadirEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientosRegistrados.add(estacionamiento);
		this.notificarInicioEstacionamiento();
	}

	public double getPrecioTotalDeFranja() {
		return (this.getInicioFranja().getHour() + this.getCierreFranja().getHour()) * this.getPrecioPorHora();
	}

	public List<EstacionamientoViaApp> getCelulares(){
		return this.celulares;
	}
	public EstacionamientoViaApp getCelular(String celular) {
		// retorna lista de celulares
		EstacionamientoViaApp ce = this.celulares.stream().filter(c -> c.getCelular().equals(celular)).findFirst()
				.orElse(null);
		return ce;
	}

	public void agregarCelular(EstacionamientoViaApp celular) {
		// TODO Auto-generated method stub
		celulares.add(celular);
	}

}
