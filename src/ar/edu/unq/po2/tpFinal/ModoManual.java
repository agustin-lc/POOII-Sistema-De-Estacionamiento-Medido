package ar.edu.unq.po2.tpFinal;

public class ModoManual implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(AppEstacionamiento estacionamientoApp) {
		EstacionamientoViaApp est = estacionamientoApp.crearEstacionamiento();
			if (!est.estaVigente() && est.hayCreditoDisponible()) {
				
			est.getSem().añadirEstacionamiento(est);
			est.setEstaVigente(true);
				
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
