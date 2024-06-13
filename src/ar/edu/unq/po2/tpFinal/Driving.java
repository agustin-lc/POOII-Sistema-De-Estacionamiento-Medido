package ar.edu.unq.po2.tpFinal;

import java.time.LocalDateTime;

public class Driving extends EstadoMovimiento {
	@Override
	public void walking(AppEstacionamiento app) {
		// TODO Auto-generated method stub
		// Iniciar estacionamiento
		if (app.getAsistencia()) {
			// notificar
			System.out.print("Alerta de inicio de estacionamiento");
			// inicia el estacionamiento
			//app.getModo().inicioDeEstacionamiento(app);
			iniciarEstacionamiento(app);//iniciar o finaliar
		}
		app.setMovimientoE(new Walking());

	}
	@Override
	public void driving(AppEstacionamiento app) {
		// hacer nada
	}
	private void iniciarEstacionamiento(AppEstacionamiento app) {
		EstacionamientoViaApp est = app.crearEstacionamiento();
		app.setEstacionamiento(est);
		if ( app.hayCreditoDisponible()) {
			int maxHoras = (int) (app.getSaldo() / app.getSem().getPrecioPorHora());
					app.getSem().añadirEstacionamiento(est);
					est.setEstaVigente(true);
					if (maxHoras >= 13) {
						est.horaFin  = LocalDateTime.now().withHour(19).withMinute(59);

					}else {
						est.horaFin = est.horaInicio.plusHours(maxHoras);
					}
		}
	}
}