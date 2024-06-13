package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento implements MovementSensor {
	private IModoApp modo;
	private String patente;
	private String celular;
	private double saldo;
	private SistemaDeEstacionamientoMedido sem;
	private EstadoMovimiento movimientoE;
	private Boolean asistencia;

	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, String numero) {
		this.setModo(new ModoManual());
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.celular = numero;
		sem.agregarCelular(this);
	}

	@Override
	public void finalizar(LocalDateTime hora) {
		this.horaFin = hora;
		// this.estaVigente() = false;
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

	public boolean estacionamientoVigente() {
		return sem.poseeEstacionamientoVigente(this.patente);
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		movimientoE.walking(this);
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		movimientoE.driving(this);
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
