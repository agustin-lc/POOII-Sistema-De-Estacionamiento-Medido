package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public abstract class Estacionamiento {
	protected String patente;
	protected LocalDateTime horaInicio;
	protected LocalDateTime horaFin;
	protected boolean estaVigente;
	protected SistemaDeEstacionamientoMedido sem;

	// SETTERS
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

	public void setEstaVigente(boolean expresion) {
		this.estaVigente = expresion;

	}

	// GETTERS
	public LocalDateTime getHoraInicio() {
		return this.horaInicio;
	}

	public LocalDateTime getHoraFin() {
		return this.horaFin;
	}

	public String getPatente() {
		return patente;
	}

	public boolean estaVigente() {
		if(estaVigente && this.horaInicio.getHour() < sem.getCierreFranja().getHour()
				&& this.horaInicio.getHour() >= sem.getInicioFranja().getHour()
				&& horaFin.getHour() > sem.getHorario().getHour()
				&& horaFin.getHour() <= sem.getCierreFranja().getHour()) {
			
//		if (getHoraInicio().isBefore(sem.getCierreFranja())&&
//				getHoraInicio().isAfter(sem.getInicioFranja())&&
//				
//				 getHoraFin().isAfter(sem.getHorario())) {
			estaVigente = true;
			//sem.añadirVigente(this);
			
		}else {
			estaVigente = false;
		}
		return estaVigente;
	}

	public abstract void finalizar(LocalDateTime hora);

	public SistemaDeEstacionamientoMedido getSem() {
		return sem;
	}

	public void setSem(SistemaDeEstacionamientoMedido sem) {
		this.sem = sem;
	}

}
