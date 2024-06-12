package ar.edu.unq.po2.tpFinal;

public class ModoAutomatico implements IModoApp {

	@Override
	public void alertaInicioDeEstacionamiento(Usuario usuario) {
		String patente = usuario.getPatente();
		usuario.iniciarEstacionamientoAPP(patente);

	}

	@Override
	public void alertaFinDeEstacionamiento(Usuario usuario) {
		// TODO Auto-generated method stub

	}

}
