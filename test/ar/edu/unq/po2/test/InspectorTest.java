package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import ar.edu.unq.po2.tpFinal.Infraccion;
import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

class InspectorTest {

	private SistemaDeEstacionamientoMedido sem;
	private String patente;
	private ZonaDeEstacionamiento zona;
	private Inspector inspector;
	private int numero;

	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SistemaDeEstacionamientoMedido.class);
		zona = mock(ZonaDeEstacionamiento.class);
		patente = "AB123CD";
		numero = 12345678;
		inspector = new Inspector(numero, zona, sem);
	}

	@Test
	void testGetSistemaAsignado() {
		assertEquals(sem, inspector.getSistema());
	}

	@Test
	void testGetZonaAsignada() {
		assertEquals(zona, inspector.getZonaAsignada());
	}

	@Test
	void testGetNumero() {
		assertEquals(numero, inspector.getCelular());
	}

	@Test
	void testSetSistemaAsignado() {
		SistemaDeEstacionamientoMedido sistemaNuevo = mock(SistemaDeEstacionamientoMedido.class);
		inspector.setSem(sistemaNuevo);
		assertEquals(sistemaNuevo, inspector.getSistema());
	}

	@Test
	void testSetNumeroTelefono() {
		int numeroNuevo = 11223344;
		inspector.setCelular(numeroNuevo);
		assertEquals(numeroNuevo, inspector.getCelular());
	}

	@Test
	void testSetZonaAsignada() {
		ZonaDeEstacionamiento zonaNueva = mock(ZonaDeEstacionamiento.class);
		inspector.setZonaAsignada(zonaNueva);
		assertEquals(zonaNueva, inspector.getZonaAsignada());
	}

	@Test
	void testInspectorConsultaEstacionamientoVigenteCorrectamente() {
		when(sem.poseeEstacionamientoVigente(patente)).thenReturn(true);
		
		boolean resultadoConsulta = inspector.validarEstacionamientoVigente(patente);
		
		assertTrue(resultadoConsulta);
	
	}

	@Test
	void testInspectorConsultaEstacionamientoVigenteYNoSeEncuentra() {
		when(sem.poseeEstacionamientoVigente(patente)).thenReturn(false);		
		boolean resultadoConsulta = inspector.validarEstacionamientoVigente(patente);
		
		assertFalse(resultadoConsulta);
	}

	@Test
	void testInspectorConsultaEstacionamientoNoVigenteYGeneraInfraccion() {

		inspector.validarEstacionamientoVigente(patente);

		verify(sem).añadirInfraccion(patente, inspector);
	}

	@Test
	void testInspectorConsultaEstacionamientoVigenteYNoNotificaInfraccion() {
		when(sem.poseeEstacionamientoVigente(patente)).thenReturn(true);
    	
    	inspector.validarEstacionamientoVigente(patente);
    	
    	verify(sem, never()).añadirInfraccion(patente, inspector);
	}
}
