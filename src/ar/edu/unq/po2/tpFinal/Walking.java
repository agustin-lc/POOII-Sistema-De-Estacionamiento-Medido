package ar.edu.unq.po2.tpFinal;

public class Walking extends EstadoMovimiento {

	@Override
	public void walking(AppEstacionamiento app) {
		// TODO Auto-generated method stub

	}

	@Override
	public void driving(AppEstacionamiento app) {
		// TODO Auto-generated method stub
		//Finalizar estacionamietno
		if(app.getAsistencia()) {
			//notificar
			System.out.print("Alerta de fin de estacionamiento");
			//app.hacer algo ---> modo.iniciar/finaliozar
			terminarEstacionamiento(app);
		}
		app.setMovimientoE(new Driving());
	}

	private void terminarEstacionamiento(AppEstacionamiento app) {
		// TODO Auto-generated method stub
		EstacionamientoViaApp est = app.getEstacionamiento();
		est.finalizar(app.getSem().getHorario());
		
// if (est.estaVigente()) {
			//		est.setEstaVigente(false);
			//.setHoraFin(est.getSem().getHorario());
//					est.descontarMontoPorEstacionamiento(est
//							.getMontoPorTiempoUtilizado( est.getHoraFin()));
//					app.getSem().notificarFinEstacionamiento();
		est.descontarMontoPorEstacionamiento(est.getMontoPorTiempoUtilizado(est.getHoraFin()));
		est.getSem().notificarFinEstacionamiento();
				}
	

}