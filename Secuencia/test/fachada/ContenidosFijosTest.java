/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import Fachada.Asignatura;
import Fachada.ContenidosFijos;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.enumContenidosEspecificos;
import util.enumContenidosGenerales;

/**
 *
 * @author gerar
 */
public class ContenidosFijosTest {

    Asignatura asignatura;
    ContenidosFijos instance;

    public ContenidosFijosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        asignatura = new Asignatura();
        asignatura.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));
        instance = new ContenidosFijos();
        instance.setAsignatura(asignatura);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAsignatura method, of class ContenidosFijos.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testSetAsignatura() {
        Asignatura asignatura2 = new Asignatura();
        asignatura2.setAsignatura(enumContenidosEspecificos.MATERIA_FISICA.toString());
        asignatura2.setSemestre(Integer.parseInt(enumContenidosEspecificos.SEMESTRE_1.toString()));
        asignatura2.setBloque(Integer.parseInt(enumContenidosEspecificos.BLOQUE_1.toString()));;
        int expResult = 0;
        if (asignatura2.getAsignatura().equals(asignatura.getAsignatura())) {
            if (asignatura2.getSemestre() == asignatura.getSemestre()) {
                if (asignatura2.getBloque() == asignatura.getBloque()) {
                    expResult = 1;
                }
            }
        }
        assertEquals(expResult, 1);
    }

    @Test
    public void testSetContenidosDeclarativos() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        int result = instance.setContenidosDeclarativos(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosDeclarativosLimitesErroneosSuperior() {
        int expResult = -1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(10);
        int result = instance.setContenidosDeclarativos(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosDeclarativosLimitesErroneosInferior() {
        int expResult = -1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(-2);
        listaSeleccion.add(2);
        int result = instance.setContenidosDeclarativos(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosDeclarativosVacio() {
        int expResult = 0;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        int result = instance.setContenidosDeclarativos(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosProcedimentales() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        int result = instance.setContenidosProcedimentales(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosProcedimentalesLimitesErroneosSuperior() {
        int expResult = -1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(10);
        int result = instance.setContenidosProcedimentales(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosProcedimentalesLimitesErroneosInferior() {
        int expResult = -1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(-2);
        listaSeleccion.add(2);
        int result = instance.setContenidosProcedimentales(listaSeleccion);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetContenidosProcedimentalesVacio() {
        int expResult = 0;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        int result = instance.setContenidosProcedimentales(listaSeleccion);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of listarContenidosDeclarativos method, of class ContenidosFijos.
     */
    @Test
    public void testListarContenidosDeclarativos() {
        int expResult = 5;
        int result = instance.listarContenidosDeclarativos().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarContenidosProcedimentales method, of class ContenidosFijos.
     */
    @Test
    public void testListarContenidosProcedimentales() {
        int expResult = 4;
        int result = instance.listarContenidosProcedimentales().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasDisciplinaresMatematicas method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasDisciplinaresMatematicas() {
        int expResult = 8;
        int result = instance.listarCompetenciasDisciplinaresMatematicas().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasDisciplinaresCienciasExperimentales method, of
     * class ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasDisciplinaresCienciasExperimentales() {
        int expResult = 31;
        int result = instance.listarCompetenciasDisciplinaresCienciasExperimentales().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasDisciplinaresCienciasSociales method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasDisciplinaresCienciasSociales() {
        int expResult = 18;
        int result = instance.listarCompetenciasDisciplinaresCienciasSociales().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasDisciplinaresComunicaciones method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasDisciplinaresComunicaciones() {
        int expResult = 23;
        int result = instance.listarCompetenciasDisciplinaresComunicaciones().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericasAprende method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericasAprende() {
        int expResult = 3;
        int result = instance.listarCompetenciasGenericasAprende().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericasAutodetermina method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericasAutodetermina() {
        int expResult = 12;
        int result = instance.listarCompetenciasGenericasAutodetermina().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericaseExpresa method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericaseExpresa() {
        int expResult = 5;
        int result = instance.listarCompetenciasGenericaseExpresa().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericaseParticipa method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericaseParticipa() {
        int expResult = 12;
        int result = instance.listarCompetenciasGenericaseParticipa().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericasePiensa method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericasePiensa() {
        int expResult = 10;
        int result = instance.listarCompetenciasGenericasePiensa().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarCompetenciasGenericaseTrabaja method, of class
     * ContenidosFijos.
     */
    @Test
    public void testListarCompetenciasGenericaseTrabaja() {
        int expResult = 3;
        int result = instance.listarCompetenciasGenericaseTrabaja().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarInstrumentosDeEvaluacion method, of class ContenidosFijos.
     */
    @Test
    public void testListarInstrumentosDeEvaluacion() {
        int expResult = 12;
        int result = instance.listarInstrumentosDeEvaluacion().size();
        assertEquals(expResult, result);
    }
    /**
     * Test of listarEvidenciasDeAprendizaje method, of class ContenidosFijos.
     */
    @Test
    public void testListarEvidenciasDeAprendizaje() {
        int expResult = 13;
        int result = instance.listarEvidenciasDeAprendizaje().size();
        assertEquals(expResult, result);
    }    
    
    
    @Test
    public void testSetDisciplinaresMatematicasIniElegidasValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 1;
        int result = instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresMatematicasIniElegidasVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresMatematicasIniElegidasFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(13);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresMatematicasIniElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDisciplinaresCienciasSocialesDesElegidasValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 1;
        int result = instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresCienciasSocialesDesElegidasVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresCienciasSocialesDesElegidasFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresCienciasSocialesDesElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }


    @Test
    public void testSetDisciplinaresComunicacionCieElegidasValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 1;
        int result = instance.setCompetenciasDisciplinaresComunicacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresComunicacionCieElegidasVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresComunicacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresComunicacionCieElegidasFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresComunicacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresComunicacionCieElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setCompetenciasDisciplinaresComunicacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetGenericaAprendeIniValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeIniVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeIniFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeIniElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }

}
