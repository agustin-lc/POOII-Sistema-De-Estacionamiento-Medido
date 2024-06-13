package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;

public class PuntoDeVentaTestCase {

	private PuntoDeVenta puntoDeVenta; // SUT
    private SistemaDeEstacionamientoMedido semMock; //DOC

    @BeforeEach
    void setUp() {
        semMock = mock(SistemaDeEstacionamientoMedido.class);

        puntoDeVenta = new PuntoDeVenta(semMock);
    }

    @Test
    void testGetNumeroTicketRandom() {
        double numeroTicket = puntoDeVenta.getNumeroTicketRandom();

        assertTrue(numeroTicket >= 0 && numeroTicket <= 1);
    }
}
