package ar.edu.unq.po2.tpFinal;

public class Driving extends EstadoMovimiento {
	@Override
	public void walking(EstacionamientoViaApp app) {
		// TODO Auto-generated method stub
		// Iniciar estacionamiento
		if (app.getAsistencia()) {
			// notificar
			System.out.print("Alerta de inicio de estacionamiento");
		}
		app.setMovimientoE(new Walking());

	}

	@Override
	public void driving(EstacionamientoViaApp app) {
		// hacer nada
	}
}