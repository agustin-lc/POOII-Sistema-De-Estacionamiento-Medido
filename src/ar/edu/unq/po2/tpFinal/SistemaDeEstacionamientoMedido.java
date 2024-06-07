package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeEstacionamientoMedido {

	private List<ZonaDeEstacionamiento> zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
	private int inicioFranja;
	private int cierreFranja;
	private List<ISuscriptor> suscriptores;
	
	public List<Inspector> getInspectores() {
		return zonasDeEstacionamiento.stream().map(zona -> zona.getInspector()).toList();
	}
	
	public List<List<PuntoDeVenta>> getPuntosDeVentas(){
		return zonasDeEstacionamiento.stream().map(zona -> zona.getPuntoDeVenta()).toList();
	}
	
	public List<ZonaDeEstacionamiento> getZonasDeEstacionamientos(){
		return zonasDeEstacionamiento;
	}
	
	public List<Integer> getCreditosDeCelulares(){
		return null;
		//realizar un map sobre lista de estacionamientos realizados
	}
	
	public void añadirSuscriptor(ISuscriptor suscriptor){
		this.suscriptores.add(suscriptor);
	}
	
	public void removerSuscriptor(ISuscriptor suscriptor) {
		if (suscriptores.contains(suscriptor)){
			suscriptores.remove(suscriptor);
		}
	}
	
	public void notificarSuscriptores() {
		suscriptores.forEach(sub -> sub.notificar());
	}

	public int getInicioFranja() {
		return inicioFranja;
	}

	public int getCierreFranja() {
		return cierreFranja;
	}

}
