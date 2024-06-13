package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.EstacionamientoCompraPuntual;

class EstacionamientoCompraPuntualTest {
	private EstacionamientoCompraPuntual estacionamiento;
	private String patente;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int cantidadHoras;

	@BeforeEach
	void setUp() throws Exception {
		horaInicio = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(7, 0));
		horaFin = horaInicio.plusHours(cantidadHoras);
		estacionamiento = new EstacionamientoCompraPuntual(patente, horaInicio, horaFin, cantidadHoras);
	}

	@Test
	void testGetPatente() {
		assertEquals(estacionamiento.getPatente(), patente);

	}

	@Test
	void testSetPatente() {
		String patente2 = "AB123111";
		estacionamiento.setPatente(patente2);
		assertEquals(estacionamiento.getPatente(), patente2);
	}

	@Test
	void testGetHoraInicio() {
		assertEquals(horaInicio, estacionamiento.getHoraInicio());

	}

	@Test
	void testSetHoraInicio() {
		LocalDateTime horaNueva = LocalDateTime.now().plusHours(3);
		estacionamiento.setHoraInicio(horaNueva);
		assertEquals(estacionamiento.getHoraInicio(), horaNueva);
	}

	@Test
	void testGetHoraFin() {
		assertEquals(horaFin, estacionamiento.getHoraFin());
	}

	@Test
	void testSetHoraFin() {
		LocalDateTime horaFinNueva = LocalDateTime.now().plusHours(1);
		estacionamiento.setHoraFin(horaFinNueva);
		assertEquals(horaFinNueva, estacionamiento.getHoraFin());
	}

	@Test
	void getCantidadHoras() {
		assertEquals(cantidadHoras, estacionamiento.getCantidadHoras());
	}

	@Test
	void setCantidadHoras() {
		int cantidadNueva = 3;
		estacionamiento.setCantidadHoras(cantidadNueva);
		assertEquals(cantidadNueva, estacionamiento.getCantidadHoras());
	}

	@Test
	void testFinalizar() {
		assertEquals(true, estacionamiento.estaVigente());
		horaFin = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(20, 0));
		estacionamiento.finalizar(horaFin);
		assertEquals(estacionamiento.getHoraFin(), horaFin);
		assertTrue(estacionamiento.estaVigente());
	}
}
