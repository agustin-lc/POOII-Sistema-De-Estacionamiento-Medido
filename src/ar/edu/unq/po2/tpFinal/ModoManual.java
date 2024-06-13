package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class ModoManual implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(AppEstacionamiento app) {
		EstacionamientoViaApp est = app.crearEstacionamiento();
		app.setEstacionamiento(est);
		int maxHoras = (int) (app.getSaldo() / app.getSem().getPrecioPorHora());
			if (app.hayCreditoDisponible()) {
				
			app.getSem().añadirEstacionamiento(est);
			app.getEstacionamiento().setEstaVigente(true);
			if (maxHoras >= 13) {
				est.horaFin  = LocalDateTime.now().withHour(19).withMinute(59);

				}else {
				est.horaFin = est.horaInicio.plusHours(maxHoras);
				}
			}

	}

	@Override
	public void finDeEstacionamiento(AppEstacionamiento estacionamientoApp) {
		EstacionamientoViaApp est = estacionamientoApp.crearEstacionamiento();
		if (est.estaVigente()) {
				est.setEstaVigente(false);
		est.setHoraFin(estacionamientoApp.getSem().getHorario());
				est.descontarMontoPorEstacionamiento(est
				.getMontoPorTiempoUtilizado(est.getHoraInicio(), est.getHoraFin()));
				est.getSem().notificarFinEstacionamiento();
			}
		
		
	}


	@Override
	public void walking(AppEstacionamiento appEstacionamiento) {}

	@Override
	public void driving(AppEstacionamiento appEstacionamiento) {}
	

}
