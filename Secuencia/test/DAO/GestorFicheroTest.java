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
public class GestorFicheroTest {

    public GestorFicheroTest() {
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
    public void testGetAsignaturas() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Física");
        expResult.add("Matemáticas");
        ArrayList<String> result = instance.getAsignaturas();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignatura() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("3");
        ArrayList<String> result = instance.getSemestresAsignatura("Física");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignaturaVacio() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay semestres disponibles :(");
        ArrayList<String> result = instance.getSemestresAsignatura("");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSemestresAsignaturaIncorrecto() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay semestres disponibles :(");
        ArrayList<String> result = instance.getSemestresAsignatura(" nada ");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBloquesAsignatura() throws Exception {
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
    public void testGetBloquesAsignaturaErroneoAsignatura() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay bloques disponibles :(");
        ArrayList<String> result = instance.getBloquesAsignatura("nada", 1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBloquesAsignaturaErroneoNumero() throws Exception {
        GestorFichero instance = new GestorFichero();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("No hay bloques disponibles :(");
        ArrayList<String> result = instance.getBloquesAsignatura("Física", 6);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesEvidencias() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 13;
        int result = instance.getContenidosGenerales("evidencias").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesInstrumentos() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 12;
        int result = instance.getContenidosGenerales("instrumentosDeEvaluación").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaDisciplinarMatematicas() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 8;
        int result = instance.getCompetenciasGenerales("Disciplinar", "Matemáticas").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaDisciplinarCienciasExperimentales() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 31;
        int result = instance.getCompetenciasGenerales("Disciplinar", "Ciencias experimentales").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaDisciplinarComunicacion() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 23;
        int result = instance.getCompetenciasGenerales("Disciplinar", "Comunicación").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaDisciplinarCienciasSociales() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 18;
        int result = instance.getCompetenciasGenerales("Disciplinar", "Ciencias sociales").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaAutodetermina() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 12;
        int result = instance.getCompetenciasGenerales("Genéricas", "Se autodetermina y cuida de sí").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaExpresa() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 5;
        int result = instance.getCompetenciasGenerales("Genéricas", "Se expresa y comunica").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaPiensa() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 10;
        int result = instance.getCompetenciasGenerales("Genéricas", "Piensa crítica y reflexivamente").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaAprende() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 3;
        int result = instance.getCompetenciasGenerales("Genéricas", "Aprende de forma autónoma").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaTrabaja() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 3;
        int result = instance.getCompetenciasGenerales("Genéricas", "Trabaja en forma colaborativa").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosGeneralesCompetenciaGenericaParticipa() throws Exception {
        GestorFichero instance = new GestorFichero();
        int expResult = 12;
        int result = instance.getCompetenciasGenerales("Genéricas", "Participa con responsabilidad en la sociedad").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosDeclarativosBloque1() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque("1");
        int expResult = 5;
        int result = instance.getContenidosEspecificos(asignatura, "declarativo").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosDeclarativosBloque3() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque("3");
        int expResult = 3;
        int result = instance.getContenidosEspecificos(asignatura, "declarativo").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosDeclarativosSemestre3() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(3);
        asignatura.setBloque("3");
        int expResult = 3;
        int result = instance.getContenidosEspecificos(asignatura, "declarativo").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosDeclarativosFallido() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(4);
        asignatura.setBloque("3");
        int expResult = 1;
        int result = instance.getContenidosEspecificos(asignatura, "declarativo").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosProcedimentalesBloque1() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque("1");
        int expResult = 4;
        int result = instance.getContenidosEspecificos(asignatura, "procedimentales").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosProcedimentalesBloque3() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(1);
        asignatura.setBloque("3");
        int expResult = 4;
        int result = instance.getContenidosEspecificos(asignatura, "procedimentales").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosProcedimentalesSemestre3() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("Física");
        asignatura.setSemestre(3);
        asignatura.setBloque("3");
        int expResult = 1;
        int result = instance.getContenidosEspecificos(asignatura, "procedimentales").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContenidosEspecificosProcedimentalesFallido() throws Exception {
        GestorFichero instance = new GestorFichero();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura("asd");
        asignatura.setSemestre(4);
        asignatura.setBloque("3");
        int expResult = 1;
        int result = instance.getContenidosEspecificos(asignatura, "declarativo").size();
        assertEquals(expResult, result);
    }
}
