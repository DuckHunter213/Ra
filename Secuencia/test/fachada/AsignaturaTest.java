/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

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
public class AsignaturaTest {

    public AsignaturaTest() {
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
     * Test of listarAsignaturas method, of class Asignatura.
     */
    @Test
    public void testListarAsignaturas() {
        System.out.println("listarAsignaturas");
        Asignatura instance = new Asignatura();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Física");
        expResult.add("Matemáticas");
        ArrayList<String> result = instance.listarAsignaturas();
        assertEquals(expResult, result);
    }

    /**
     * Test of listarBloques method, of class Asignatura.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testListarBloques() {
        System.out.println("listarBloques");
        String nombreAsignatura = "";
        int semestre = 0;
        Asignatura instance = new Asignatura();
        instance.setAsignatura("Física");
        instance.setSemestre(1);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Bloque 1");
        expResult.add("Bloque 2");
        expResult.add("Bloque 3");
        expResult.add("Bloque 4");
        ArrayList<String> result = instance.listarBloques();
        assertEquals(expResult, result);
    }

    /**
     * Test of listarSemestres method, of class Asignatura.
     */
    @Test
    public void testListarSemestres() {
        System.out.println("listarSemestres");
        Asignatura instance = new Asignatura();
        instance.setAsignatura("Física");
        instance.setBloque("1");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("3");
        ArrayList<String> result = instance.listarSemestres();
        assertEquals(expResult, result);
    }

}
