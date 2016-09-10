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


    
}
