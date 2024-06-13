package ar.edu.unq.po2.test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

public class ZonaDeEstacionamientoTestCase {

	private ZonaDeEstacionamiento zona;  // SUT
	
    private Inspector inspectorMock; 	   // DOC
    private PuntoDeVenta puntoDeVentaMock; // DOC

    @BeforeEach
    void setUp() {
        inspectorMock = mock(Inspector.class);
        puntoDeVentaMock = mock(PuntoDeVenta.class);
        
        zona = new ZonaDeEstacionamiento(inspectorMock);
    }

    @Test
    void testConstructorAndGetInspector() {
        assertEquals(inspectorMock, zona.getInspector());
    }

    @Test
    void testGetPuntoDeVenta() {
        List<PuntoDeVenta> puntosDeVenta = zona.getPuntoDeVenta();
        assertNotNull(puntosDeVenta);
        assertTrue(puntosDeVenta.isEmpty()); // inicialmente vacia
    }

    @Test
    void testAñadirPuntoVenta() {
        zona.añadirPuntoVenta(puntoDeVentaMock);
        List<PuntoDeVenta> puntosDeVenta = zona.getPuntoDeVenta();
        assertEquals(1, puntosDeVenta.size());
        assertTrue(puntosDeVenta.contains(puntoDeVentaMock));
    }
}
