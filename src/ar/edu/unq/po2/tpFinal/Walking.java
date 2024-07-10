package ar.edu.unq.po2.tpFinal;

public class Walking extends EstadoMovimiento {

	@Override
	public void walking() {
		//this.app.modo.walking();
	}

	@Override
	public void driving() {
		//this.app.modo.driving();
		this.app.cambioAManejar();
	//	this.app.setMovimientoE(new Driving());
		app.setMovimientoE(new Driving());
	}
	
	
}