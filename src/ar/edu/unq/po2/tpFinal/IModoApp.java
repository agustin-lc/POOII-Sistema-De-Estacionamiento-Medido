package ar.edu.unq.po2.tpFinal;

public interface IModoApp {
	void inicioDeEstacionamiento(AppEstacionamiento estacionamientoApp);

	void finDeEstacionamiento(AppEstacionamiento estacionamientoApp);
//	void driving(EstacionamientoViaApp app);
	//void walking(EstacionamientoViaApp app);

	void walking(AppEstacionamiento appEstacionamiento);
	void driving(AppEstacionamiento appEstacionamiento);

	
}
