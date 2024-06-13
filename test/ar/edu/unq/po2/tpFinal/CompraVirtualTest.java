package ar.edu.unq.po2.tpFinal;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CompraVirtualTest {

	SistemaDeEstacionamientoMedido sem;
	PuntoDeVenta punto;
	ZonaDeEstacionamiento zona;
	Inspector inspector;
	AppEstacionamiento celular;
	@BeforeEach
	void setUp() throws Exception {
		sem = new SistemaDeEstacionamientoMedido();
		inspector = new Inspector("123423441", zona, sem);
		zona = new ZonaDeEstacionamiento(inspector, sem);
		celular = new AppEstacionamiento("axz 990","12121212", sem);
		punto = new PuntoDeVenta(sem, zona);
		
		sem.setHorario(8);
	}

	@Test
	void testCompraEstacionamientoPor3HorasEnManual() {
		punto.recargarCredito(celular.getNumero(), 200);
		sem.avanzarHorario(1);//reloj 9:00
		celular.inicioDeEstacionamiento();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 1);
		
		sem.avanzarHorario(3);
		celular.finEstacionamiento();

		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);

	//	System.out.print("total consumido es " + celular.getEstacionamiento().getMontoPorTiempoUtilizado(sem.getHorario()));
	
	
	}
	
	@Test
	void testCompraEstacionamientoHastaFin() {
		punto.recargarCredito(celular.getNumero(), 700);
		sem.setHorario(7);
		celular.inicioDeEstacionamiento();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 1);
		
		sem.avanzarHorario(13);

		sem.finalizarEstacionamientos();

		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);

		System.out.print("total consumido es " + celular.getEstacionamiento().getMontoPorTiempoUtilizado(sem.getHorario()));
	}

	@Test
	void testQuiereCOmprarManualPeroNoTieneCredito() {
		punto.recargarCredito(celular.getNumero(), 10);
		celular.inicioDeEstacionamiento();
		assertFalse(celular.getEstacionamiento().estaVigente());
		assertTrue(sem.getEstacionamientosRegistrados().size() == 0);
	}
}

