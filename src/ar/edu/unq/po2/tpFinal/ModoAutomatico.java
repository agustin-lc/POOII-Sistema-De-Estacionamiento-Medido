package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class ModoAutomatico implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		if (!estacionamientoApp.estacionamientoVigente()) {
			// estacionamientoApp.getSem().notificacionDeInicio(estacionamientoApp.getPatente());
		if (!estacionamientoApp.estacionamientoVigente() && estacionamientoApp.hayCreditoDisponible()) {
			EstacionamientoViaApp estacionamiento = new EstacionamientoViaApp(estacionamientoApp.getPatente(),
					LocalDateTime.now(), estacionamientoApp.getCelular());
			estacionamiento.getSem().añadirEstacionamiento(estacionamiento);
			estacionamiento.setEstaVigente(true);
		}

	}

	@Override
	public void finDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		if (estacionamientoApp.estacionamientoVigente()) {
			// estacionamientoApp.getSem().notificacionDeFin(estacionamientoApp.getCelular());
			estacionamientoApp.setEstaVigente(false);
			estacionamientoApp.setHoraFin(LocalDateTime.now());
			estacionamientoApp.descontarMontoPorEstacionamiento(estacionamientoApp
					.getMontoPorTiempoUtilizado(estacionamientoApp.getHoraInicio(), estacionamientoApp.getHoraFin()));
			estacionamientoApp.getSem().notificarSuscriptores();
		}
	}

}
