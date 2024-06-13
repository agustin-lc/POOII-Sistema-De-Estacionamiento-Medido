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
	private String numero;
	ZonaDeEstacionamiento zona2;
	Inspector i;
	SistemaDeEstacionamientoMedido sem2;
	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SistemaDeEstacionamientoMedido.class);
		zona = mock(ZonaDeEstacionamiento.class);
		patente = "AB123CD";
		numero = "12345678";
		inspector = new Inspector(numero, zona, sem);
		 sem2 = new SistemaDeEstacionamientoMedido();
		 zona2 = new ZonaDeEstacionamiento(i,sem2);
		 i = new Inspector("12345555", zona2, sem2);
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
		String numeroNuevo = "11223344";
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
		
		
		i.validarEstacionamientoVigente(patente);
		assertEquals(sem2.getInfracciones().size(),1);
		assertEquals(sem2.getInspectores().size(),1);
	}

	@Test
	void testInspectorConsultaEstacionamientoVigenteYNoNotificaInfraccion() {
		when(sem.poseeEstacionamientoVigente(patente)).thenReturn(true);
    	
    	inspector.validarEstacionamientoVigente(patente);
    	
    	verify(sem, never()).añadirInfraccion(patente, inspector);
	}
}
