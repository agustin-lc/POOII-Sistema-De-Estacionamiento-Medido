package ar.edu.unq.po2.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.Estacionamiento;
import ar.edu.unq.po2.tpFinal.EstacionamientoCompraPuntual;
import ar.edu.unq.po2.tpFinal.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.SistemaDeEstacionamientoMedido;

public class PuntoDeVentaTestCase {

	private PuntoDeVenta puntoDeVenta;
    private SistemaDeEstacionamientoMedido sem; 

    @BeforeEach
    void setUp() {
        sem = new SistemaDeEstacionamientoMedido();
        puntoDeVenta = new PuntoDeVenta(sem);
        //semMock.
    }

  
    @Test
    void testNuevaCompraRegistrada() {
    	puntoDeVenta.registrarCompraPuntual(4, "ABC 157");

    	assertFalse(sem.getEstacionamientosRegistrados().isEmpty());
    	assertEquals(sem.getEstacionamientosRegistrados().getFirst().getPatente(),"ABC 157");
  
    }
    
    @Test
    void testNuevaCompraPierdeVigencia() {
    	sem.avanzarHorario(10);
    	puntoDeVenta.registrarCompraPuntual(4, "ABC 157");
    	Estacionamiento est = sem.getEstacionamientosRegistrados().getFirst();
    	sem.avanzarHorario(4);
    	assertFalse(est.estaVigente());
    	
    }
}
