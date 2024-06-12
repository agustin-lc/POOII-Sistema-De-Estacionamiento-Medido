package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento implements MovementSensor{
	private IModoApp modo;
	private String patente;
	private String celular;
	private double saldo;
	private SistemaDeEstacionamientoMedido sem;
	private EstadoMovimiento movimientoE;
	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, LocalDateTime horaFin, String numero) {
		this.modo = new ModoManual();
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.celular = numero;
		sem.agregarCelular(this);
	}

	// public int getNumeroDeCelular() {
	// return numeroDeCelular;
	// }

	@Override
	public void finalizar(LocalDateTime hora) {
		this.horaFin = hora;
		// this.estaVigente() = false;
	}

	public void agregarSaldo(double monto) {
		saldo = saldo + monto;
	}

	public void cambiarModo(IModoApp modo) {
		this.modo = modo;
	}

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	// fijarse override!
	public String getPatente() {
		return patente;
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
	movimientoE.driving();	
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		
	}

	

	public void setMovimientoE(EstadoMovimiento movimientoE) {
		this.movimientoE = movimientoE;
	}
}
