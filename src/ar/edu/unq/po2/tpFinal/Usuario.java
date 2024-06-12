package ar.edu.unq.po2.tpFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Usuario {
	private int celular;
	private String patente;
	private double saldo;
	private IModoApp modalidad;
	private boolean notificacionesActivadas;
	private SistemaDeEstacionamientoMedido sem;

//Métodos:
	// CONSTRUCTOR
	public Usuario(int celular, String patente, int saldo, IModoApp modalidad, SistemaDeEstacionamientoMedido sem) {
		this.celular = celular;
		this.patente = patente;
		this.saldo = saldo;
		this.modalidad = modalidad;
		this.sem = sem;
		this.notificacionesActivadas = true; // TOMAMOS COMO VALOR PREDETERMINADO QUE POSEE LAS NOTIFICACIONES ACTIVADAS
	}

	// GETTERS
	public String getPatente() {
		return patente;
	}

	public int getCelular() {
		return celular;
	}

	public double getSaldo() {
		return saldo;
	}

	public IModoApp getModalidad() {
		return modalidad;
	}

	public boolean getNotificacionesActivadas() {
		return notificacionesActivadas;
	}

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	// SETTERS
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setModalidad(IModoApp modalidad) {
		this.modalidad = modalidad;
	}

	// METODOS
	public void activarODesactivarNotificaciones() {
		this.notificacionesActivadas = !notificacionesActivadas;
	}

	public void iniciarEstacionamientoManual(int horas, PuntoDeVenta punto) {
		punto.registrarCompraPuntual(horas, this.patente);
	}

	public void iniciarEstacionamientoAPP(String patente2) {
		if (this.hayCreditoDisponible()) {
			EstacionamientoViaApp estacionamiento = new EstacionamientoViaApp(patente2, LocalDateTime.now(),
					LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 0)), celular); // se inicia la clase
																						// estacionamientoViaApp con los
																						// datos de ahora hasta fin de
																						// franja
			sem.añadirEstacionamiento(estacionamiento);
		} else {
			System.out.print("Saldo insuficiente. Estacionamiento no permitido.");
		}
	}

	private boolean hayCreditoDisponible() {
		return this.getSaldo() > sem.getPrecioTotalDeFranja();
	}

}
