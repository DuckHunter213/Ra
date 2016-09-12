/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.enumContenidosGenerales;

/**
 *
 * @author gerar
 */
public class ContenidosGeneralesTest {
    
    public ContenidosGeneralesTest() {
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
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresMatematicas() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 8;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(),enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString()).size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresCienciasExperimentales() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 31;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(),enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString()).size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresCienciasSociales() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 18;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(),enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString()).size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresComunicacion() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 23;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(),enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString()).size();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCompetenciasGenericasAutodetermina() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 12;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasExpresa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 5;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasPiensa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 10;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasAprende() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 3;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasTrabaja() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 3;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasParticipa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 12;
        int result = instance.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString()).size();
        assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testEvidencias() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 13;
        int result = instance.listarOtrosContenidos(enumContenidosGenerales.TIPO_CONT_GENERICO_EVIDENCIAS.toString()).size();
        assertEquals(expResult, result);
    } 
    @Test
    public void testInstrumentos() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 12;
        int result = instance.listarOtrosContenidos(enumContenidosGenerales.TIPO_CONT_GENERICO_INSTRUMENTOS.toString()).size();
        assertEquals(expResult, result);
    }
    
    
    
    @Test
    public void testGetCompetenciasElegidasValido(){
        ContenidosGenerales instance = new ContenidosGenerales();
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);        
        int expResult = 3;
        int result = instance.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCompetenciasElegidasVacio(){
        ContenidosGenerales instance = new ContenidosGenerales();
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();     
        int expResult = 1;
        int result = instance.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCompetenciasElegidasErrorLimiteSuperior(){
        ContenidosGenerales instance = new ContenidosGenerales();
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(13);
        int expResult = 1;
        int result = instance.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString()).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCompetenciasElegidasErrorLimiteInferior(){
        ContenidosGenerales instance = new ContenidosGenerales();
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-1);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 1;
        int result = instance.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString()).size();
        assertEquals(expResult, result);
    }
}
