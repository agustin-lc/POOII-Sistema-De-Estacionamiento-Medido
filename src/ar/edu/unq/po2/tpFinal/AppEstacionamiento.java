package ar.edu.unq.po2.tpFinal;

public class AppEstacionamiento  implements MovementSensor {
	private IModoApp modo;//verificar conexiones con modos
	private String patente;
	private String numero;
	private double saldo;
	public EstadoMovimiento movimientoE;
	private Boolean asistencia;
	private SistemaDeEstacionamientoMedido sem;

	private EstacionamientoViaApp estacionamiento;
	
	public AppEstacionamiento(String patente, String numero,SistemaDeEstacionamientoMedido sem) {
		this.setModo(new ModoManual()); // por defecto manual
		this.patente = patente;
	//	this.horaInicio = horaInicio;
		this.numero = numero;
		this.sem = sem;  
		sem.agregarCelular(this);
		//this.movimientoE(new )
		asistencia = false;
		movimientoE = new Driving();
	}
	
	public EstacionamientoViaApp crearEstacionamiento() {
		EstacionamientoViaApp est = new EstacionamientoViaApp(this.getPatente(), sem.getHorario(),numero,sem);
		est.setSem(sem);
		
		return est;
	}
	
	
	public void inicioDeEstacionamiento() {
		modo.inicioDeEstacionamiento(this);
	}
	public void finEstacionamiento() {
		modo.finDeEstacionamiento(this);
	}
	
	
	
	
	public EstacionamientoViaApp getEstacionamiento() {
		return estacionamiento;
	}

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	public void setEstacionamiento(EstacionamientoViaApp e)
	{
		this.estacionamiento = e;
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		//movimientoE.walking(this);
		//movimientoE = new Walking();
//		modo.walking(this);
//		movimientoE.walking(this);
		modo.walking(this);
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
	//	movimientoE.driving(this);
		//movimientoE = new Driving();
		modo.driving(this);
//		movimientoE.driving(this);
	}
	
	public String getPatente() {
		return patente;
	}
	
	public void recargarSaldo(double monto) {
		saldo = saldo + monto;
	}

	public void cambiarModo(IModoApp modo) {
		this.setModo(modo);
	//	this.movimientoE = new Driving();
		modo.driving(this);
	}

	public String getNumero() {
		return numero;
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

	

	public void setModo(IModoApp modo) {
		this.modo = modo;
	}

	public boolean hayCreditoDisponible() {
		return this.getSaldo() >= 40;//sem.getPrecioTotalDeFranja();
	}

	public int maximoDeHoras() {
		int maxHoras = (int) ((getSaldo() / getSem().getPrecioPorHora())); 
		return maxHoras;
	}
	
	

	

}