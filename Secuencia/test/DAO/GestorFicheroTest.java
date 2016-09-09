/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class GestorFicheroTest{

    public GestorFicheroTest(){
    }

    @BeforeClass
    public static void setUpClass(){
    }

    @AfterClass
    public static void tearDownClass(){
    }

    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testGetAsignaturas() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Física");
        expResult.add("Matemáticas");
        ArrayList<String> result = instance.getAsignaturas();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignatura() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1.csv");
        expResult.add("3.csv");
        ArrayList<String> result = instance.getSemestresAsignatura("Física");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignaturaVacio() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay semestres disponibles :(");
        ArrayList<String> result = instance.getSemestresAsignatura("");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignaturaIncorrecto() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay semestres disponibles :(");
        ArrayList<String> result = instance.getSemestresAsignatura(" nada ");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBloquesAsignatura() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Bloque 1");
        expResult.add("Bloque 2");
        expResult.add("Bloque 3");
        expResult.add("Bloque 4");
        ArrayList<String> result = instance.getBloquesAsignatura("Física", 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBloquesAsignaturaErroneoAsignatura() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay bloques disponibles :(");
        ArrayList<String> result = instance.getBloquesAsignatura("nada", 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBloquesAsignaturaErroneoNumero() throws Exception{
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay bloques disponibles :(");
        ArrayList<String> result = instance.getBloquesAsignatura("Física", 6);
        assertEquals(expResult, result);
    }

}
