package ar.edu.unq.po2.tpFinal;


public class ModoManual implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(AppEstacionamiento app) {
		EstacionamientoViaApp est = app.crearEstacionamiento();
		
			if (app.hayCreditoDisponible()) {
				System.out.println("Credito disponible "+ app.getSaldo());
				
				app.getSem().añadirEstacionamiento(est);
				//pregunta si tiene igual o mas saldo que hasta el final del dia
				if (app.getSaldo() >= 520){ 
				
					est.horaFin  = app.getSem().getCierreFranja();//fija hora del fin maximo
					System.out.println("Estacionamiento hasta las 19:59");
					est.setEstaVigente(true);//activa estacionamiento
					}else {//activa estacionamiento hasta el maximo de credito
						est.horaFin = est.horaInicio.plusHours(app.maximoDeHoras() );
						System.out.println("Estacionamiento hasta las "+ est.horaInicio.plusHours( app.maximoDeHoras()));
						est.setEstaVigente(true);
					}
			}else {
				est.setEstaVigente(false);	
				}
			
			app.setEstacionamiento(est);
	}
	


	@Override
	public void finDeEstacionamiento(AppEstacionamiento estacionamientoApp) {
		EstacionamientoViaApp est = estacionamientoApp.getEstacionamiento();
	est.finalizar(estacionamientoApp.getSem().getHorario());
		est.descontarMontoPorEstacionamiento(est.getMontoPorTiempoUtilizado( est.getHoraFin()));
		est.getSem().notificarFinEstacionamiento(est);
		
		
	}




	@Override
	public void cambioACaminar(AppEstacionamiento estacionamientoApp) {
		// TODO Auto-generated method stub
		//avisar
	}



	@Override
	public void cambioAManejar(AppEstacionamiento estacionamientoApp) {
		// TODO Auto-generated method stub
		//avisar
	}
	

}