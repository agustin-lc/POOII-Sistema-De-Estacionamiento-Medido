package ar.edu.unq.po2.tpFinal;
public abstract class EstadoMovimiento {

	public AppEstacionamiento app;
	public abstract void walking();

	public abstract void driving();

	public void setApp(AppEstacionamiento app) {
		// TODO Auto-generated method stub
		this.app = app;
	}

//	public abstract void driving(AppEstacionamiento app);
//	public abstract void walking(AppEstacionamiento app);
}