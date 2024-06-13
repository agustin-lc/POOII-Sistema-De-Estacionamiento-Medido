package ar.edu.unq.po2.tpFinal;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Inspector;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;
import ar.edu.unq.po2.tpFinal.ZonaDeEstacionamiento;

public class ZonaDeEstacionamientoTestCase {

	private ZonaDeEstacionamiento zona;  // SUT
	
    private Inspector inspectorMock; 	   // DOC
    private PuntoDeVenta puntoDeVentaMock; // DOC
    private SistemaDeEstacionamientoMedido sem;
    @BeforeEach
    void setUp() {
        inspectorMock = mock(Inspector.class);
        puntoDeVentaMock = mock(PuntoDeVenta.class);
        sem = new SistemaDeEstacionamientoMedido();
        zona = new ZonaDeEstacionamiento(inspectorMock, sem);
    }

    @Test
    void testPuntosDeVenta() {
    	assertEquals(sem.getPuntosDeVentas().size(),1);
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
