package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Infraccion;
import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

class InfraccionesTest {
	private ZonaDeEstacionamiento zona;
	private String patente;
	private Inspector inspector;
	private LocalDateTime fechaYHora;
	private Infraccion infraccion;

	@BeforeEach
	void setUp() throws Exception {
		patente = "AB123CD";
		zona = mock(ZonaDeEstacionamiento.class);
		inspector = mock(Inspector.class);
		fechaYHora = LocalDateTime.now();
		infraccion = new Infraccion(patente, fechaYHora, inspector, zona);
	}

	@Test
	void testGetZona() {
		assertEquals(zona, infraccion.getZonaInfraccion());
	}

	@Test
	void testSetZonaInfraccion() {
		ZonaDeEstacionamiento zonaNueva = mock(ZonaDeEstacionamiento.class);
		infraccion.setZonaInfraccion(zonaNueva);
		assertEquals(zonaNueva, infraccion.getZonaInfraccion());
	}

	@Test
	void testGetPatente() {
		assertEquals(patente, infraccion.getPatente());
	}

	@Test
	void testSetPatente() {
		String patenteNueva = "AB345DE";
		infraccion.setPatente(patenteNueva);
		assertEquals(patenteNueva, infraccion.getPatente());
	}

	@Test
	void testGetInspector() {
		assertEquals(inspector, infraccion.getInspector());
	}

	@Test
	void testSetInspector() {
		Inspector inspectorNuevo = mock(Inspector.class);
		infraccion.setInspector(inspectorNuevo);
		assertEquals(inspectorNuevo, infraccion.getInspector());
	}

	@Test
	void testGetZFechaYHora() {
		assertEquals(fechaYHora, infraccion.getFechaInfraccion());
	}

	@Test
	void testSetFechaYHora() {
		LocalDateTime fechaNueva = LocalDateTime.now();
		infraccion.setFechaInfraccion(fechaNueva);
		assertEquals(fechaNueva, infraccion.getFechaInfraccion());
	}

}
