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
        asignatura.setBloque(enumContenidosEspecificos.BLOQUE_1.toString());
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
        asignatura2.setBloque(enumContenidosEspecificos.BLOQUE_1.toString());
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
    public void testGetContenidosDeclarativos() {
        int expResult = 2;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        instance.setContenidosDeclarativos(listaSeleccion);
        int result = instance.getContenidosDeclarativos().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosDeclarativosLimitesErroneosSuperior() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(10);
        instance.setContenidosDeclarativos(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosDeclarativos();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosDeclarativosLimitesErroneosInferior() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(-2);
        listaSeleccion.add(2);
        instance.setContenidosDeclarativos(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosDeclarativos();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosDeclarativosVacio() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        instance.setContenidosDeclarativos(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosDeclarativos();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosProcedimentales() {
        int expResult = 2;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(2);
        instance.setContenidosProcedimentales(listaSeleccion);
        int result = instance.getContenidosProcedimentales().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosProcedimentalesLimitesErroneosSuperior() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(0);
        listaSeleccion.add(10);
        instance.setContenidosProcedimentales(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosProcedimentales();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosProcedimentalesLimitesErroneosInferior() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        listaSeleccion.add(-2);
        listaSeleccion.add(2);
        instance.setContenidosProcedimentales(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosProcedimentales();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetContenidosProcedimentalesVacio() {
        int expResult = 1;
        ArrayList<Integer> listaSeleccion = new ArrayList<>();
        instance.setContenidosProcedimentales(listaSeleccion);
        ArrayList<String> resultados = instance.getContenidosProcedimentales();
        int result = 0;
        if (resultados.size() == 1 && resultados.get(0).equals(" "))
            result = 1;
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
    public void testGetDisciplinaresMatematicasIniElegidasValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 3;
        instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        int result = instance.getCompetenciasDisciplinaresMatematicasInicio().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresMatematicasIniElegidasVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = 1;
        instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        int result = instance.getCompetenciasDisciplinaresMatematicasInicio().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresMatematicasIniElegidasFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(13);
        int expResult = 1;
        instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        int result = instance.getCompetenciasDisciplinaresMatematicasInicio().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresMatematicasIniElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        instance.setCompetenciasDisciplinaresMatematicasInicio(contenidosSeleccionados);
        int result = instance.getCompetenciasDisciplinaresMatematicasInicio().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresCienciasSocialesDesElegidasValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(3);
        int expResult = 3;
        instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        int result = instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().size();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresCienciasSocialesDesElegidasVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = 1;
        instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        int result = 0;
        if (instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().size() == 1 && instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresCienciasSocialesDesElegidasFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = 1;
        instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        int result = 0;
        if (instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().size() == 1 && instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().get(0).equals(" "))
            result = 1;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDisciplinaresCienciasSocialesDesElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        instance.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(contenidosSeleccionados);
        int result = 0;
        if (instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().size() == 1 && instance.getCompetenciasDisciplinaresCienciasSocialesDesarrollo().get(0).equals(" "))
            result = 1;
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
        int expResult = 1;
        int result = instance.setCompetenciasDisciplinaresComunicacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetDisciplinaresComunicacionCieElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
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
        int expResult = 1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeIniElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasAprendeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaExpresaDesValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasExpresaDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaExpresaDesVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasGenericasExpresaDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaExpresaDesFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasExpresaDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaExpresaDesElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasExpresaDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }    
    @Test
    public void testSetGenericaAprendeCieValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasParticipaCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeCieVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setCompetenciasGenericasParticipaCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeCieFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasParticipaCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetGenericaAprendeCieElegidasFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = 1;
        int result = instance.setCompetenciasGenericasParticipaCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetInstrumentosDeEvaluacionIniValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(4);
        int expResult = 1;
        int result = instance.setInstrumentosDeEvaluacionInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionIniVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionIniFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionIniFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }    
    @Test
    public void testSetInstrumentosDeEvaluacionDesValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(4);
        int expResult = 1;
        int result = instance.setInstrumentosDeEvaluacionDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionDesVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionDesFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionDesFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionDesarrollo(contenidosSeleccionados);
        assertEquals(expResult, result);
    }    
    @Test
    public void testSetInstrumentosDeEvaluacionCieValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(4);
        int expResult = 1;
        int result = instance.setInstrumentosDeEvaluacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionCieVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionCieFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetInstrumentosDeEvaluacionCieFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setInstrumentosDeEvaluacionCierre(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSetEvidenciasIniValido() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(4);
        int expResult = 1;
        int result = instance.setEvidenciasDeAprendizajeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetEvidenciasIniVacio() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        int expResult = -1;
        int result = instance.setEvidenciasDeAprendizajeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetEvidenciasIniFueraLimiteSuperior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(0);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(23);
        int expResult = -1;
        int result = instance.setEvidenciasDeAprendizajeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetEvidenciasIniFueraLimiteInferior() {
        ArrayList<Integer> contenidosSeleccionados = new ArrayList<>();
        contenidosSeleccionados.add(-3);
        contenidosSeleccionados.add(2);
        contenidosSeleccionados.add(1);
        int expResult = -1;
        int result = instance.setEvidenciasDeAprendizajeInicio(contenidosSeleccionados);
        assertEquals(expResult, result);
    }
}