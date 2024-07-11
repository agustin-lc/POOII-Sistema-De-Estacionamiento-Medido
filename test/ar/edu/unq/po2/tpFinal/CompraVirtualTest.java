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
		celular = new AppEstacionamiento("axz 990", "12121212", sem);
		punto = new PuntoDeVenta(sem, zona);

		sem.setHorario(8);
	}

	@Test
	void testCompraEstacionamientoPor3HorasEnManual() {
		punto.recargarCredito(celular.getNumero(), 200);
		sem.avanzarHorario(1);// reloj 9:00
		celular.inicioDeEstacionamiento();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 1);

		sem.avanzarHorario(3);
		celular.finEstacionamiento();

		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);

		// System.out.print("total consumido es " +
		// celular.getEstacionamiento().getMontoPorTiempoUtilizado(sem.getHorario()));

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

		System.out.print(
				"total consumido es " + celular.getEstacionamiento().getMontoPorTiempoUtilizado(sem.getHorario()));
	}

	@Test
	void testQuiereCOmprarManualPeroNoTieneCredito() {
		punto.recargarCredito(celular.getNumero(), 10);
		celular.inicioDeEstacionamiento();
		assertFalse(celular.getEstacionamiento().estaVigente());
		assertTrue(sem.getEstacionamientosRegistrados().size() == 0);
	}

	@Test
	void testCambiaAModoAutomatico() {
		// EstadoMovimiento estado = new Driving();
		// estado = new Driving();
		punto.recargarCredito(celular.getNumero(), 5000);
		celular.cambiarModo(new ModoAutomatico());
		celular.alternarAsistencia();
		// celular.setMovimientoE(estado);
		celular.driving();
		celular.driving();
		celular.driving();
		celular.driving();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 0);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);
		celular.walking();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 1);
		celular.driving();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);
		assertFalse(celular.getEstacionamiento().estaVigente());
	}
	@Test
	void testNoCambiaModoYReciveAlerta() {
		celular.alternarAsistencia();
		celular.driving();
		celular.walking();
		celular.driving();
		assertTrue(celular.getAsistencia());
	}

	@Test
	void testModoAutomaticoYNoHaySaldoMasDe2Horas() {
		punto.recargarCredito(celular.getNumero(), 80);
		celular.cambiarModo(new ModoAutomatico());
		celular.alternarAsistencia();
		celular.driving();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 0);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);
		celular.walking();
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 1);
		assertEquals(celular.getEstacionamiento().getHoraFin().getHour(), 10);
		sem.avanzarHorario(3);
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		assertEquals(sem.getEstacionamientosVigentes().size(), 0);
	}
}
