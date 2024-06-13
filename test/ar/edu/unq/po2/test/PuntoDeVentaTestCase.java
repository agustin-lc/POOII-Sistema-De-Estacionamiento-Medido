package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.AppEstacionamiento;
import ar.edu.unq.po2.tpFinal.Estacionamiento;
import ar.edu.unq.po2.tpFinal.EstacionamientoCompraPuntual;
import ar.edu.unq.po2.tpFinal.EstacionamientoViaApp;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;

public class PuntoDeVentaTestCase {

	private PuntoDeVenta puntoDeVenta;
	private SistemaDeEstacionamientoMedido sem;
	private AppEstacionamiento celular;

	@BeforeEach
	void setUp() {
		sem = new SistemaDeEstacionamientoMedido();
		puntoDeVenta = new PuntoDeVenta(sem);
		celular = new AppEstacionamiento("GGG 777", "123456789", sem);
	}
/*
	@Test
	void testNuevaCompraRegistrada() {
		puntoDeVenta.registrarCompraPuntual(4, "ABC 157");

		assertFalse(sem.getEstacionamientosRegistrados().isEmpty());
		assertEquals(sem.getEstacionamientosRegistrados().getFirst().getPatente(), "ABC 157");
		assertFalse(sem.getComprasRegistradas().isEmpty());
	}

	@Test
	void testNuevaCompraPierdeVigencia() {
		sem.avanzarHorario(10);
		puntoDeVenta.registrarCompraPuntual(4, "ABC 157");
		Estacionamiento est = sem.getEstacionamientosRegistrados().getFirst();
		sem.avanzarHorario(4);
		assertFalse(est.estaVigente());

	}
*/
	@Test
	void testRecargarCredito() {
		puntoDeVenta.recargarCredito(celular.getNumero(), 500);
		assertEquals(celular.getSaldo(), 500);
	}
	// finalizar estacionamiento pasadas las 8
}
