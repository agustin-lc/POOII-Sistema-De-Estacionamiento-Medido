package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.CompraRecargaSaldo;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;

class CompraRecargaCelularTest {
	private CompraRecargaSaldo compra;
	private PuntoDeVenta punto;
	private double ticket;
	private LocalDateTime fechayhora;
	private int monto;
	private int nroCelular;

	@BeforeEach
	void setUp() throws Exception {
		punto = mock(PuntoDeVenta.class);
		ticket = 1234;
		fechayhora = LocalDateTime.now();
		nroCelular = 1144556677;
		monto = 2000;
		compra = new CompraRecargaSaldo(ticket, punto, fechayhora, nroCelular, monto);
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
	void testMontoARecargar() {
		assertEquals(monto, compra.getMontoARecargar());
	}

	@Test
	void testSetMontoARecargar() {
		int montoNuevo = 44444;
		compra.setMontoARecargar(montoNuevo);
		assertEquals(montoNuevo, compra.getMontoARecargar());
	}

	@Test
	void testGetNroCelular() {
		assertEquals(nroCelular, compra.getNroCelular());
	}

	@Test
	void testSetNroCelular() {
		int nroNuevo = 1122334455;
		compra.setNroCelular(nroNuevo);
		assertEquals(nroNuevo, compra.getNroCelular());
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
}
