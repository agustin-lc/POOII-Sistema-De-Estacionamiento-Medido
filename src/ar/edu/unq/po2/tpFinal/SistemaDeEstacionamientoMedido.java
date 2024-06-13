package ar.edu.unq.po2.tpFinal;

import static org.mockito.ArgumentMatchers.intThat;

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
	private List<AppEstacionamiento> celulares;

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
		celulares = new ArrayList<AppEstacionamiento>();
	}
	public void avanzarHorario(int horas) {
	horario = horario.plusHours(horas);
	if(horario.getHour() >= 20) {
		this.finalizarEstacionamientos();
	}
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(int h) {
		this.horario = LocalDateTime.of(LocalDate.now(), LocalTime.of(h, 0));
	}
	// GETTERS

	public List<Estacionamiento> getEstacionamientosRegistrados() {
		return estacionamientosRegistrados;
	}
	public List<ISuscriptor> getSuscriptores() {
		return suscriptores;
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
		 List<Estacionamiento> toReturn = estacionamientosRegistrados.stream().filter(e -> e.estaVigente()).collect(Collectors.toList());
		return toReturn;
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
	
	public void añadirZonaEstacionamiento(ZonaDeEstacionamiento zona) {
		zonasDeEstacionamiento.add(zona);
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
		return this.estacionamientosRegistrados.stream()
				.anyMatch(est -> est.getPatente().equals(patente) && est.estaVigente());
	}

	public void finalizarEstacionamientos() {
		
		this.getEstacionamientosVigentes().stream().forEach(e -> e.finalizar(this.getCierreFranja()));
		this.getEstacionamientosVigentes().clear();
		this.notificarFinEstacionamiento();
		
	}
	public void añadirCompra(Compra compra) {
		this.comprasRegistradas.add(compra);
	}

	public List<Compra> getComprasRegistradas() {
		return comprasRegistradas;
	}
	public void añadirEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientosRegistrados.add(estacionamiento);
		this.notificarInicioEstacionamiento();
	}

	
	public List<AppEstacionamiento> getCelulares() {
		return this.celulares;
	}

	public AppEstacionamiento getCelular(String celular) {
		// retorna lista de celulares
		AppEstacionamiento ce = this.celulares.stream().filter(c -> c.getNumero().equals(celular)).findFirst()
				.orElse(null);
		return ce;
	}

	public double creditoDeTodos() {
		int monto = 0;
		List<AppEstacionamiento> cels = this.getCelulares();
		for (AppEstacionamiento c : cels) {
				monto = (int) (monto + c.getSaldo());
			}
		return monto;

		}
	
	public void agregarCelular(AppEstacionamiento celular) {
		// TODO Auto-generated method stub
		celulares.add(celular);
	}

	}