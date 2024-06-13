package ar.edu.unq.po2.tpFinal;

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
		if (!est.estaVigente() && app.hayCreditoDisponible()) {
					EstacionamientoViaApp estacionamiento = new EstacionamientoViaApp(app.getPatente(),
							app.getSem().getHorario(), app.getCelular());
					estacionamiento.getSem().añadirEstacionamiento(estacionamiento);
					estacionamiento.setEstaVigente(true);
		}
	}
}