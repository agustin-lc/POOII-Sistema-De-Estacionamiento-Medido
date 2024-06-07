package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

class InspectorTest {

	private SistemaDeEstacionamientoMedido sem;
	private String patente;
	private ZonaDeEstacionamiento zona;
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SistemaDeEstacionamientoMedido.class);
		zona = mock(ZonaDeEstacionamiento.class);
		patente = "AB123CD";
		inspector = new Inspector(1122334455, zona, sem);
	}

	@Test
	void tesGetSistemaAsignado() {
		assertEquals(sem, inspector.getSistema());
	}

}
