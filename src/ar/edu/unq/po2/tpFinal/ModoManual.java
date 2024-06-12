package ar.edu.unq.po2.tpFinal;

public class ModoManual implements IModoApp {

	@Override
	public void inicioDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		if (estacionamientoApp.getSaldo() > 40) {
            		estacionamientoApp.getSem().notificacionDeInicio(estacionamientoApp.getPatente());
            		System.out.println("Estacionamiento iniciado manualmente.");
        	} else {
            		System.out.println("Saldo insuficiente para iniciar el estacionamiento.");
        	}
    	}

	@Override
	public void finDeEstacionamiento(EstacionamientoViaApp estacionamientoApp) {
		estacionamientoApp.getSem().notificacionDeFin(estacionamientoApp.getCelular());
        	System.out.println("Estacionamiento finalizado manualmente.");
	}

}
