package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.EstacionamientoCompraPuntual;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;

class EstacionamientoCompraPuntualTest {
	private EstacionamientoCompraPuntual estacionamiento;
	private String patente;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int cantidadHoras;
	private SistemaDeEstacionamientoMedido sem;

	@BeforeEach
	void setUp() throws Exception {
		horaInicio = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(7, 0));
		horaFin = horaInicio.plusHours(cantidadHoras);
		sem = mock(SistemaDeEstacionamientoMedido.class);
		estacionamiento = new EstacionamientoCompraPuntual(patente, horaInicio, horaFin, cantidadHoras, sem);
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
		when(sem.getInicioFranja()).thenReturn(LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 0)));
		when(sem.getCierreFranja()).thenReturn(LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 0)));
		horaFin = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(20, 0));
		estacionamiento.finalizar(horaFin);
		assertEquals(estacionamiento.getHoraFin(), horaFin);
		assertFalse(estacionamiento.estaVigente());
	}
	
	@Test
	void testGetSem() {
		assertEquals(sem,estacionamiento.getSem());
	}
	
	@Test
	void testSetSEM() {
		SistemaDeEstacionamientoMedido sem2 =  mock(SistemaDeEstacionamientoMedido.class);
		estacionamiento.setSem(sem2);
		assertEquals(sem2, estacionamiento.getSem());
	}
	
	@Test
	void testEstaVigente() {
		when(sem.getInicioFranja()).thenReturn(LocalDateTime.of(LocalDate.now(), LocalTime.of(7, 0)));
		when(sem.getCierreFranja()).thenReturn(LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 0)));
		horaFin = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(17, 0));
		horaInicio = LocalDateTime.now().of(LocalDate.now(), LocalTime.of(15, 0));
		assertTrue(estacionamiento.getHoraFin().isBefore(sem.getCierreFranja()));
		assertFalse(estacionamiento.getHoraInicio().isAfter(sem.getInicioFranja()));
	}
}
