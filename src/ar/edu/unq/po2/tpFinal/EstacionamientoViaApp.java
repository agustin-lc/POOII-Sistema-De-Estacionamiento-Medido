package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento  {
	private IModoApp modo;//verificar conexiones con modos
	private String patente;
	private String celular;
	private double saldo;
	public EstadoMovimiento movimientoE;
	private Boolean asistencia;

	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, String numero) {
		this.setModo(new ModoManual()); // por defecto manual
		this.patente = patente;
	this.horaInicio = horaInicio;
		this.celular = numero;
		
	}


	public String getPatente() {
		return patente;
	}

	@Override
	public void finalizar(LocalDateTime hora) {
		this.horaFin = hora;
		// this.estaVigente() = false;
		this.estaVigente = false;
	}

	public void agregarSaldo(double monto) {
		saldo = saldo + monto;
	}

	public void cambiarModo(IModoApp modo) {
		this.setModo(modo);
	}

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	public String getCelular() {
		return celular;
	}

	public double getSaldo() {
		return saldo;
	}



	public void setMovimientoE(EstadoMovimiento movimientoE) {
		this.movimientoE = movimientoE;
	}

	public Boolean getAsistencia() {
		return asistencia;
	}

	public void alternarAsistencia() {
		this.asistencia = !asistencia;
	}

	public IModoApp getModo() {
		return modo;
	}

	public void setModo(IModoApp modo) {
		this.modo = modo;
	}

	public boolean hayCreditoDisponible() {
		return this.getSaldo() > sem.getPrecioTotalDeFranja();
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
