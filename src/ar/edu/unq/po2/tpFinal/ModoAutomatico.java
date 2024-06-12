package ar.edu.unq.po2.tpFinal;

public class ModoAutomatico implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		if (!estacionamientoApp.estacionamientoVigente()) {
			//estacionamientoApp.getSem().notificacionDeInicio(estacionamientoApp.getPatente());
		}

	}

	@Override
	public void finDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		if (estacionamientoApp.estacionamientoVigente()) {
		//	estacionamientoApp.getSem().notificacionDeFin(estacionamientoApp.getCelular());
		}
	}

}
