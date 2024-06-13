package ar.edu.unq.po2.tpFinal;

public class Walking extends EstadoMovimiento {

	@Override
	public void walking(EstacionamientoViaApp app) {
		// TODO Auto-generated method stub

	}

	@Override
	public void driving(EstacionamientoViaApp app) {
		// TODO Auto-generated method stub
		//Finalizar estacionamietno
		if(app.getAsistencia()) {
			//notificar
			System.out.print("Alerta de fin de estacionamiento");
		}
		app.setMovimientoE(new Driving());
	}

}
