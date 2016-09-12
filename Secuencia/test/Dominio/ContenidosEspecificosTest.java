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
import util.enumContenidosEspecificos;

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
    public void testListarContEspecProcedimentalBloque3Semestre3() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 1;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_3.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_3.toString()));
        int result = instance.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString()).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testListarContEspecProcedimentalBloque1Semestre1() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 4;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        int result = instance.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString()).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testListarContEspecDeclarativoBloque3Semestre3() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 3;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_3.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_3.toString()));
        int result = instance.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString()).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testListarContEspecDeclarativoBloque1Semestre1() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 5;
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        int result = instance.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString()).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetContenidoEspecificoFisicaBloque1Semestre1() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        listaSeleccion.add(3);
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        int result = instance.setContenidosEspecificos(asignatura, listaSeleccion, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
        assertEquals(expResult, result);
    }

    @Test
    public void testSetContenidoEspecificoFisicaBloque3Semestre3() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_3.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_3.toString()));
        int result = instance.setContenidosEspecificos(asignatura, listaSeleccion, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
        assertEquals(expResult, result);
    }

    @Test
    public void testSetContenidoEspecificoFisicaBloque1Semestre1Error() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = -1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(-1);
        listaSeleccion.add(5);
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        int result = instance.setContenidosEspecificos(asignatura, listaSeleccion, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());
        assertEquals(expResult, result);
    }

    @Test
    public void testSetContenidoEspecificoFisicaBloque1Semestre1Vacio() throws Exception {
        ContenidosEspecificos instance = new ContenidosEspecificos();
        int expResult = 0;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        Asignatura asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        int result = instance.setContenidosEspecificos(asignatura, listaSeleccion, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());
        assertEquals(expResult, result);
    }

}
