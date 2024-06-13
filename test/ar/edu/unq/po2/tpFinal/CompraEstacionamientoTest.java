package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.CompraEstacionamiento;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;

class CompraEstacionamientoTest {
	private CompraEstacionamiento compra;
	private PuntoDeVenta punto;
	private double ticket;
	private LocalDateTime fechayhora;
	private int horas;

	@BeforeEach
	void setUp() throws Exception {
		punto = mock(PuntoDeVenta.class);
		ticket = 1234;
		fechayhora = LocalDateTime.now();
		horas = 5;
		compra = new CompraEstacionamiento(ticket, punto, fechayhora, horas);
	}

	@Test
	void testNumeroTicket() {
		assertEquals(ticket, compra.getNroTicket());
	}

	@Test
	void testSetNumeroTicket() {
		double ticketNuevo = 0303456;
		compra.setNroTicket(ticketNuevo);
		assertEquals(ticketNuevo, compra.getNroTicket());
	}

	@Test
	void testGetFechaYhora() {
		assertEquals(fechayhora, compra.getFechaYHora());
	}

	@Test
	void testSetFechaYhora() {
		LocalDateTime fechaNueva = LocalDateTime.now().minusHours(5);
		compra.setFechaYHora(fechaNueva);
		assertEquals(fechaNueva, compra.getFechaYHora());
	}

	@Test
	void getPuntoDeVenta() {
		assertEquals(punto, compra.getPuntoDeCompra());
	}

	@Test
	void testSetPuntoDeVenta() {
		PuntoDeVenta punto2 = mock(PuntoDeVenta.class);
		compra.setPuntoDeCompra(punto2);
		assertEquals(punto2, compra.getPuntoDeCompra());
	}
	
	@Test
	void testGetCantidadHoras() {
		assertEquals(horas, compra.getCantHoras());
	}
	
	@Test
	void testSetCantidadHoras() {
		int horasNuevas = 6;
		compra.setCantHoras(horasNuevas);
		assertEquals(horasNuevas, compra.getCantHoras());
	}
}
