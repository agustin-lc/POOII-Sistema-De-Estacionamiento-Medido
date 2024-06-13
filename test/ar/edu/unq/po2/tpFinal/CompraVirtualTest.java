package ar.edu.unq.po2.tpFinal;

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
		punto.recargarCredito(celular.getNumero(), 1000);
		sem.setHorario(8);
	}

	@Test
	void testCompraEstacionamientoPor3HorasEnManual() {

		sem.avanzarHorario(3);
		System.out.print(sem.getHorario());
		System.out.print(" " + sem.getPrecioTotalDeFranja());
		celular.inicioDeEstacionamiento();
		System.out.print("  "+ celular.getEstacionamiento().getHoraFin());
		assertEquals(sem.getEstacionamientosRegistrados().size(), 1);
		//assertEquals(sem.getEstacionamientosVigentes().size(), 1);

	}

}

