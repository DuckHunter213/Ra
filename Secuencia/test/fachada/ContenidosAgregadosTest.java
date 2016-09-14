/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import Fachada.ContenidosAgregados;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gerar
 */
public class ContenidosAgregadosTest {
    
    public ContenidosAgregadosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setContenidosGeneralesAprendizajeInicio method, of class ContenidosAgregados.
     */
    @Test
    public void testSetContenidosGeneralesAprendizajeInicioVacio() {
        String contenidosGeneralesAprendizajeInicio = "";
        int expResult = -1;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        assertEquals(expResult, resultado);
    }
    @Test
    public void testSetContenidosGeneralesAprendizajeInicioNulo() {
        String contenidosGeneralesAprendizajeInicio = null;
        int expResult = -1;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        assertEquals(expResult, resultado);
    }
    @Test
    public void testSetContenidosGeneralesAprendizajeInicioLargo() {
        String contenidosGeneralesAprendizajeInicio = "asdfmdsgnrtnfsq235r7gywabhweyg3rq7yf3bqy7it6fbwygñqñ3w3q4u3y.ñ";
        int expResult = 1;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        assertEquals(expResult, resultado);
    }
    @Test
    public void testSetContenidosGeneralesAprendizajeInicioOtrosCarcateres() {
        String contenidosGeneralesAprendizajeInicio = "|°¬^`~[]P*¨¡?=)(/&%$#!\"\t\n";
        int expResult = 1;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        assertEquals(expResult, resultado);
    }
    
    
    
    @Test
    public void testGetContenidosGeneralesAprendizajeInicioVacio() {
        String contenidosGeneralesAprendizajeInicio = "";
        String expResult = " ";
        ContenidosAgregados instance = new ContenidosAgregados();
        instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        String resultado = instance.getContenidosGeneralesAprendizajeInicio();
        assertEquals(expResult, resultado);
    }
    @Test
    public void testGetContenidosGeneralesAprendizajeInicioNulo() {
        String contenidosGeneralesAprendizajeInicio = null;
        String expResult = " ";
        ContenidosAgregados instance = new ContenidosAgregados();
        instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        String resultado = instance.getContenidosGeneralesAprendizajeInicio();
        assertEquals(expResult, resultado);
    }
    @Test
    public void testGetContenidosGeneralesAprendizajeInicioLargo() {
        String contenidosGeneralesAprendizajeInicio = "asdfmdsgnrtnfsq235r7gywabhweyg3rq7yf3bqy7it6fbwygñqñ3w3q4u3y.ñ";
        String expResult = "asdfmdsgnrtnfsq235r7gywabhweyg3rq7yf3bqy7it6fbwygñqñ3w3q4u3y.ñ";
        ContenidosAgregados instance = new ContenidosAgregados();
        instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        String resultado = instance.getContenidosGeneralesAprendizajeInicio();
        assertEquals(expResult, resultado);
    }
    @Test
    public void testGetContenidosGeneralesAprendizajeInicioOtrosCarcateres() {
        String contenidosGeneralesAprendizajeInicio = "|°¬^`~[]P*¨¡?=)(/&%$#!\"\t\n";
        String expResult = "|°¬^`~[]P*¨¡?=)(/&%$#!\"\t\n";
        ContenidosAgregados instance = new ContenidosAgregados();
        instance.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicio);
        String resultado = instance.getContenidosGeneralesAprendizajeInicio();
        assertEquals(expResult, resultado);
    }
    
    
    @Test
    public void testSetContenidosGeneralesNumeroSesionesInicioNegativo() {
        int numeroSesiones = -4;
        int expResult = 0;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setNumeroSesiones(numeroSesiones);
        assertEquals(expResult, resultado);
    }
    @Test
    public void testSetContenidosGeneralesNumeroSesionesInicioValido() {
        int numeroSesiones = 4;
        int expResult = 1;
        ContenidosAgregados instance = new ContenidosAgregados();
        int resultado = instance.setNumeroSesiones(numeroSesiones);
        assertEquals(expResult, resultado);
    }
    
    

}
