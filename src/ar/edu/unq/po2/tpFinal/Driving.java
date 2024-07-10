package ar.edu.unq.po2.tpFinal;

public class Driving extends EstadoMovimiento {

	@Override
	public void walking() {

		app.cambioACaminar();
		app.setMovimientoE(new Walking());
	}

	@Override
	public void driving() {
		
	}
}