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
        int result = instance.listarCompetenciasDisciplinaresMatematicas().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresCienciasExperimentales() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 31;
        int result = instance.listarCompetenciasDisciplinaresCienciasExperimentales().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresCienciasSociales() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 18;
        int result = instance.listarCompetenciasDisciplinaresCienciasSociales().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of getContenidosGenerales method, of class ContenidosGenerales.
     */
    @Test
    public void testListarContenidosDisciplinaresComunicacion() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 23;
        int result = instance.listarCompetenciasDisciplinaresComunicacion().size();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testCompetenciasGenericasAutodetermina() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 12;
        int result = instance.listarCompetenciasGenericasAutodetermina().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasExpresa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 5;
        int result = instance.listarCompetenciasGenericasExpresa().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasPiensa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 10;
        int result = instance.listarCompetenciasGenericasPiensa().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasAprende() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 3;
        int result = instance.listarCompetenciasGenericasAprende().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasTrabaja() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 3;
        int result = instance.listarCompetenciasGenericasTrabaja().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testCompetenciasGenericasParticipa() {
        ContenidosGenerales instance = new ContenidosGenerales();
        int expResult = 12;
        int result = instance.listarCompetenciasGenericasParticipa().size();
        assertEquals(expResult, result);
    }

}
