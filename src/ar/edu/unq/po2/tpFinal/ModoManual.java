package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class ModoManual implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(AppEstacionamiento app) {
		EstacionamientoViaApp est = app.crearEstacionamiento();
		//app.setEstacionamiento(est);
		//int maxHoras = (int) (app.getSaldo() / app.getSem().getPrecioPorHora());
			if (app.hayCreditoDisponible()) {
				System.out.println("Credito disponible "+ app.getSaldo());
				
			app.getSem().añadirEstacionamiento(est);
			if (app.getSaldo() >= 520){ 
				//app.maximoDeHoras() > 12) {
				est.horaFin  = app.getSem().getCierreFranja(); //LocalDateTime.now().withHour(19).withMinute(59);
				System.out.println("Estacionamiento hasta las 19:59");
				est.setEstaVigente(true);
				//app.getEstacionamiento().setHoraFin(LocalDateTime.now().withHour(19).withMinute(59));
				//app.getEstacionamiento().setEstaVigente(true);
				}else {
				est.horaFin = est.horaInicio.plusHours(app.maximoDeHoras() );
				System.out.println("Estacionamiento hasta las "+ est.horaInicio.plusHours( app.maximoDeHoras()));
				est.setEstaVigente(true);
//					app.getEstacionamiento().setHoraFin(app.getEstacionamiento().getHoraInicio().plusHours(
//							Math.max(app.maximoDeHoras(),13)));
//					app.getEstacionamiento().setEstaVigente(true);
				
				}
			}else {
				est.setEstaVigente(false);	
//				app.getEstacionamiento().setEstaVigente(false);
				}
			
			app.setEstacionamiento(est);
	}
	


	@Override
	public void finDeEstacionamiento(AppEstacionamiento estacionamientoApp) {
		EstacionamientoViaApp est = estacionamientoApp.getEstacionamiento();
	est.finalizar(estacionamientoApp.getSem().getHorario());
		//if (est.estaVigente()) {
		//		est.setEstaVigente(false);
		//est.setHoraFin(estacionamientoApp.getSem().getHorario());
		est.descontarMontoPorEstacionamiento(est.getMontoPorTiempoUtilizado( est.getHoraFin()));
		est.getSem().notificarFinEstacionamiento();
			//}
		
		
	}


	@Override
	public void walking(AppEstacionamiento appEstacionamiento) {}

	@Override
	public void driving(AppEstacionamiento appEstacionamiento) {}
	

}