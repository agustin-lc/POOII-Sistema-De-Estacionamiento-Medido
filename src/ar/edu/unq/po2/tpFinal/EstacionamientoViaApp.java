package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento  {
	
	private String patente;
	private String celular;
	private double saldo;
	
	
SistemaDeEstacionamientoMedido sem;
	
	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, String numero,SistemaDeEstacionamientoMedido sem) {
	
		this.patente = patente;
	this.horaInicio = horaInicio;
		this.celular = numero;
		this.sem = sem;
		horaFin  = LocalDateTime.now().withHour(19).withMinute(59);
	}


	
	public String getPatente() {
		return patente;
	}

	@Override
	public void finalizar(LocalDateTime hora) {
		this.horaFin = hora;
		// this.estaVigente() = false;
		this.estaVigente = false;
		sem.getEstacionamientosVigentes().remove(this);
	}

	

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	public String getCelular() {
		return celular;
	}

	


	public LocalDateTime getHoraFin() {
		if (this.horaFin != null) {
			System.out.print("Estacionamiento se encuentra vigente");
		}
		return this.horaFin;
	}

	public void descontarMontoPorEstacionamiento(double monto) {
		saldo = saldo - monto;
	}

	public double getMontoPorTiempoUtilizado(LocalDateTime inicio, LocalDateTime fin) {
		return (fin.getHour() - inicio.getHour()) * sem.getPrecioPorHora();
	}

}
