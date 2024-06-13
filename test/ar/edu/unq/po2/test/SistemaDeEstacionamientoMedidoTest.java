package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
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

    Estacionamiento estacionamientoMock;
    @BeforeEach
    void setUp() {
        sistema = new SistemaDeEstacionamientoMedido();
        suscriptorMock = mock(ISuscriptor.class);
         estacionamientoMock = mock(Estacionamiento.class);
    }

    @Test
    void testAñadirSuscriptor() {
        
        sistema.añadirSuscriptor(suscriptorMock);
        
        assertTrue(sistema.getSuscriptores().contains(suscriptorMock));
    }
    
    @Test
    void testPoseeEstacionamientoVigente() {
        
        when(estacionamientoMock.getPatente()).thenReturn("ABC123");
        when(estacionamientoMock.estaVigente()).thenReturn(true);

        sistema.añadirEstacionamiento(estacionamientoMock);

        boolean resultado = sistema.poseeEstacionamientoVigente("ABC123");

        assertTrue(resultado);
    }

    
    @Test
    void testNoPoseeEstacionamientoVigente() {
      
        when(estacionamientoMock.getPatente()).thenReturn("XYZ789");
        when(estacionamientoMock.estaVigente()).thenReturn(false);

        sistema.añadirEstacionamiento(estacionamientoMock);

        boolean resultado = sistema.poseeEstacionamientoVigente("ABC123");

        assertFalse(resultado);
    }
    
    @Test
    void testFinalizarEstacionamientos() {
        
        SistemaDeEstacionamientoMedido sistema = new SistemaDeEstacionamientoMedido();
        ISuscriptor suscriptorMock = mock(ISuscriptor.class);
        Estacionamiento estacionamiento1 = mock(Estacionamiento.class);
        Estacionamiento estacionamiento2 = mock(Estacionamiento.class);

        when(estacionamiento1.getPatente()).thenReturn("ABC123");
        when(estacionamiento1.getHoraInicio()).thenReturn(LocalDateTime.now().minusHours(1));
        when(estacionamiento1.getHoraFin()).thenReturn(LocalDateTime.now().plusHours(1));

        when(estacionamiento2.getPatente()).thenReturn("XYZ789");
        when(estacionamiento2.getHoraInicio()).thenReturn(LocalDateTime.now().minusHours(2));
        when(estacionamiento2.getHoraFin()).thenReturn(LocalDateTime.now().plusHours(2));

        sistema.añadirSuscriptor(suscriptorMock);
        sistema.añadirEstacionamiento(estacionamiento1);
        sistema.añadirEstacionamiento(estacionamiento2);

        
        sistema.finalizarEstacionamientos();

        assertFalse(sistema.getEstacionamientosVigentes().contains(estacionamiento1));
        assertFalse(sistema.getEstacionamientosVigentes().contains(estacionamiento2));
        verify(suscriptorMock, times(1)).notificarFinEstacionamiento();
    }

    //hacer test todos celulares
    @Test
    void testTodosLosCelulares() {
    	AppEstacionamiento cel1 = mock(AppEstacionamiento.class);
    	AppEstacionamiento cel2 = mock(AppEstacionamiento.class);
    	AppEstacionamiento cel3 = mock(AppEstacionamiento.class);
    	
    	//when(cel1.getNumero())
    	sistema.agregarCelular(cel3);sistema.agregarCelular(cel1);sistema.agregarCelular(cel2);
    	assertEquals(sistema.getCelulares().size(),3);
    	
    }
    @Test
    void testGetCierreFranja() {
    	sistema.setCierreFranja(LocalDateTime.now());;
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
    void testGetPrecioPorHora() {
    	double precioXH = 50;
    	sistema.setPrecioPorHora(precioXH);
    	assertEquals(sistema.getPrecioPorHora(), precioXH);
    }
    
}
