package ar.edu.unq.po2.tpFinal;

public class ModoAutomatico implements IModoApp {

	SistemaDeEstacionamientoMedido sem;
	//@Override
	
	
	
//		if (!estacionamientoApp.estaVigente() && estacionamientoApp.hayCreditoDisponible()) {
//			EstacionamientoViaApp estacionamiento = new EstacionamientoViaApp(estacionamientoApp.getPatente(),
//					estacionamientoApp.getSem().getHorario(), estacionamientoApp.getCelular());
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
	public void cambioACaminar(AppEstacionamiento app) {
//estacionar
		EstacionamientoViaApp est = app.crearEstacionamiento();
		
		if (app.hayCreditoDisponible()) {
			System.out.println("Credito disponible "+ app.getSaldo());
			
			app.getSem().añadirEstacionamiento(est);
			//pregunta si tiene igual o mas saldo que hasta el final del dia
			if (app.getSaldo() >= 520){ 
			
				est.horaFin  = app.getSem().getCierreFranja();//fija hora del fin maximo
				System.out.println("Estacionamiento hasta las 19:59 (c)");
				est.setEstaVigente(true);//activa estacionamiento
				}else {//activa estacionamiento hasta el maximo de credito
					est.horaFin = est.horaInicio.plusHours(app.maximoDeHoras() );
					System.out.println("Estacionamiento hasta las (d) "+ est.horaInicio.plusHours( app.maximoDeHoras()));
					est.setEstaVigente(true);
				}
		}else {
			est.setEstaVigente(false);	
			}
		
		app.setEstacionamiento(est);
	}
	@Override
	public void cambioAManejar(AppEstacionamiento estacionamientoApp) {
		// TODO Auto-generated method stub
		EstacionamientoViaApp est = estacionamientoApp.getEstacionamiento();
	est.finalizar(estacionamientoApp.getSem().getHorario());
		est.descontarMontoPorEstacionamiento(est.getMontoPorTiempoUtilizado( est.getHoraFin()));
		est.getSem().notificarFinEstacionamiento(est);
		
		
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
