package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {
	private IModoApp modo;
	private String patente;
	private String celular;
	private double saldo;
	private SistemaDeEstacionamientoMedido sem;
	private int numeroDeCelular;

	public EstacionamientoViaApp(String patente, LocalDateTime horaInicio, LocalDateTime horaFin, int numero) {
		this.modo = new ModoManual();
		this.patente = patente;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.numeroDeCelular = numero;
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

<<<<<<< HEAD
=======
		
	public void agregarSaldo(double monto) {
		saldo = saldo + monto;
	}
>>>>>>> branch 'main' of https://github.com/agustin-lc/POOII-Sistema-De-Estacionamiento-Medido.git
	public void cambiarModo(IModoApp modo) {
		this.modo = modo;
	}

<<<<<<< HEAD
	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}
=======
    	public SistemaDeEstacionamientoMedido getSem() {
    		return sem;
    	}
    //fijarse override!
   	 public String getPatente() {
    		return patente;
    	}
    
    	public String getCelular() {
    		return celular;
    	}
    
    	public double getSaldo() {
        	return saldo;
    	}
>>>>>>> branch 'main' of https://github.com/agustin-lc/POOII-Sistema-De-Estacionamiento-Medido.git

<<<<<<< HEAD
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
=======
    
    	public boolean estacionamientoVigente() {
    		return sem.poseeEstacionamientoVigente(this.patente);
    	}

		public int getNumeroDeCelular() {
			return numeroDeCelular;
		}
>>>>>>> branch 'main' of https://github.com/agustin-lc/POOII-Sistema-De-Estacionamiento-Medido.git
}
