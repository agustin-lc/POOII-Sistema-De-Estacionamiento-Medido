package ar.edu.unq.po2.tpFinal;

public class Driving extends EstadoMovimiento {

	@Override
	public void walking() {

		this.app.cambioACaminar();
		//this.app.setMovimientoE(new Walking());
		app.setMovimientoE(new Walking());
	}

	@Override
	public void driving() {
		
	}
}