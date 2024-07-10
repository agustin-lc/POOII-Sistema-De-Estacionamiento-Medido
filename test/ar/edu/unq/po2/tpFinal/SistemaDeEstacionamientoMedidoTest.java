package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.AppEstacionamiento;
import ar.edu.unq.po2.tpFinal.Compra;
import ar.edu.unq.po2.tpFinal.CompraRecargaSaldo;
import ar.edu.unq.po2.tpFinal.Estacionamiento;
import ar.edu.unq.po2.tpFinal.ISuscriptor;
import ar.edu.unq.po2.tpFinal.Infraccion;
import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

class SistemaDeEstacionamientoMedidoTest {
	private SistemaDeEstacionamientoMedido sistema;
	private ISuscriptor suscriptorMock;
	private Estacionamiento estacionamiento1;
	private Estacionamiento estacionamiento2;
	private Estacionamiento estacionamientoMock;
	private AppEstacionamiento celular1;
	private AppEstacionamiento celular2;
	private AppEstacionamiento celular3;

	@BeforeEach
	void setUp() {
		sistema = new SistemaDeEstacionamientoMedido();
		suscriptorMock = mock(ISuscriptor.class);
		estacionamientoMock = mock(Estacionamiento.class);
		estacionamiento1 = mock(Estacionamiento.class);
		estacionamiento2 = mock(Estacionamiento.class);
		celular1 = new AppEstacionamiento("s", "1212123", sistema);
		celular2 = new AppEstacionamiento("1f", "4", sistema);
		celular3 = new AppEstacionamiento("j3", "1414", sistema);
	}

	@Test
	void testCelulares() {

		ZonaDeEstacionamiento zona = new ZonaDeEstacionamiento(null, sistema);
		PuntoDeVenta p = new PuntoDeVenta(sistema, zona);
		p.recargarCredito("1212123", 300);
		p.recargarCredito("4", 800);
		p.recargarCredito("1414", 100);
		assertEquals(sistema.creditoDeTodos(), 1200);
	}

	@Test
	void testAñadirSuscriptor() {

		sistema.añadirSuscriptor(suscriptorMock);

		assertTrue(sistema.getSuscriptores().contains(suscriptorMock));

	}

	@Test
	void testQuitarSuscriptor() {
		sistema.removerSuscriptor(suscriptorMock);
		assertFalse(sistema.getSuscriptores().contains(suscriptorMock));
	}

	@Test
	void testPoseeEstacionamientoVigente() {
		sistema.añadirEstacionamiento(estacionamientoMock);
		when(estacionamientoMock.getPatente()).thenReturn("ABC123");
		when(estacionamientoMock.estaVigente()).thenReturn(true);

		assertTrue(sistema.poseeEstacionamientoVigente("ABC123"));
	}

	@Test
    void testNoPoseeEstacionamientoVigente() {
      
        when(estacionamientoMock.getPatente()).thenReturn("XYZ789");
        when(estacionamientoMock.estaVigente()).thenReturn(false);
        
        assertFalse(sistema.poseeEstacionamientoVigente("XYZ789"));
    }

	@Test
	void testFinalizarEstacionamientos() {
		sistema.añadirSuscriptor(suscriptorMock);

		sistema.añadirEstacionamiento(estacionamiento1);
		sistema.añadirEstacionamiento(estacionamiento2);
		verify(suscriptorMock, times(1)).notificarInicioEstacionamiento(estacionamiento1);
		verify(suscriptorMock, times(1)).notificarInicioEstacionamiento(estacionamiento2);
		sistema.finalizarEstacionamientos();
		assertFalse(sistema.getEstacionamientosVigentes().contains(estacionamiento1));
		assertFalse(sistema.getEstacionamientosVigentes().contains(estacionamiento2));

	}

	// hacer test todos celulares
	@Test
	void testTodosLosCelulares() {
		// when(cel1.getNumero())
		assertEquals(sistema.getCelulares().size(), 3);
		// añadidos inicialmente al setearse
	}

	@Test
	void testGetCierreFranja() {
		sistema.setCierreFranja(LocalDateTime.now());
		assertEquals(LocalDateTime.now(), sistema.getCierreFranja());
	}

	@Test
	void testGetInfracciones() {
		Infraccion infraccion = mock(Infraccion.class);
		Inspector inspect = mock(Inspector.class);
		when(infraccion.getPatente()).thenReturn("654ABC");
		when(infraccion.getInspector()).thenReturn(inspect);
		sistema.añadirInfraccion(infraccion.getPatente(), infraccion.getInspector());
		assertFalse(sistema.getInfracciones().isEmpty());
	}

	@Test
	void testGetComprasRegistradas() {
		Compra compra = mock(Compra.class);
		sistema.añadirCompra(compra);
		assertFalse(sistema.getComprasRegistradas().isEmpty());
	}

	@Test
	void testGetInspectores() {
		Inspector inspect = mock(Inspector.class);
		ZonaDeEstacionamiento zona = mock(ZonaDeEstacionamiento.class);
		when(zona.getInspector()).thenReturn(inspect);

		sistema.añadirZonaEstacionamiento(zona);
		assertTrue(sistema.getInspectores().contains(inspect));
	}

	@Test
	void testCambioDePrecioPorHora() {
		double precioXH = 50;
		sistema.setPrecioPorHora(precioXH);
		assertEquals(sistema.getPrecioPorHora(), precioXH);
	}
}
