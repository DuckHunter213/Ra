/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Fachada.Asignatura;
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
public class ContenidosEspecificosTest {
    
    public ContenidosEspecificosTest() {
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

    @Test
    public void testGetContEspecProcedimentalBloque3Semestre3() throws Exception{
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 1;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(3);
        asignatura.setBloque(3);
        int result = instance.listarContenidosEspecificosProcedimental(asignatura).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContEspecProcedimentalBloque1Semestre1() throws Exception{
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 4;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque(1);
        int result = instance.listarContenidosEspecificosProcedimental(asignatura).size();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetContEspecDeclarativoBloque3Semestre3() throws Exception{
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 3;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(3);
        asignatura.setBloque(3);
        int result = instance.listarContenidosEspecificosDeclarativo(asignatura).size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContEspecDeclarativoBloque1Semestre1() throws Exception{
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 5;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque(1);
        int result = instance.listarContenidosEspecificosDeclarativo(asignatura).size();
        assertEquals(expResult, result);
    }
}
