package ar.edu.unq.po2.tpFinal;

public class ModoAutomatico implements IModoApp {

	SistemaDeEstacionamientoMedido sem;
	//@Override
	
	
	
	//	if (!estacionamientoApp.estaVigente() && estacionamientoApp.hayCreditoDisponible()) {
	//		EstacionamientoViaApp estacionamiento = new EstacionamientoViaApp(estacionamientoApp.getPatente(),
	//				estacionamientoApp.getSem().getHorario(), estacionamientoApp.getCelular());
	//		estacionamiento.getSem().añadirEstacionamiento(estacionamiento);
	//		estacionamiento.setEstaVigente(true);
	//		
	//	}

	//@Override
	//public void walking(EstacionamientoViaApp app) {
	//	// TODO Auto-generated method stub
	//	app.movimientoE.walking(app);
	//}

	//@Override
	//public void driving(EstacionamientoViaApp app) {
	//	// TODO Auto-generated method stub
	//	app.movimientoE.driving(app);
	//}

	//}

	@Override
	public void finDeEstacionamiento(AppEstacionamiento estacionamientoApp) {}
	@Override
	public void inicioDeEstacionamiento(AppEstacionamiento estacionamientoApp) {}

	@Override
	public void walking(AppEstacionamiento appEstacionamiento) {
		// TODO Auto-generated method stub
		appEstacionamiento.movimientoE.walking(appEstacionamiento);
	}


	@Override
	public void driving(AppEstacionamiento appEstacionamiento) {
		// TODO Auto-generated method stub
		appEstacionamiento.movimientoE.driving(appEstacionamiento);
		
	}
	
	
	
	//	if (estacionamientoApp.estaVigente()) {
	//		estacionamientoApp.setEstaVigente(false);
	//		estacionamientoApp.setHoraFin(estacionamientoApp.getSem().getHorario());
	//		estacionamientoApp.descontarMontoPorEstacionamiento(estacionamientoApp
	//				.getMontoPorTiempoUtilizado(estacionamientoApp.getHoraInicio(), estacionamientoApp.getHoraFin()));
	//		estacionamientoApp.getSem().notificarFinEstacionamiento();
	//	}
	//}

}
