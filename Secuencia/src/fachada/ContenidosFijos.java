package Fachada;

import Dominio.ContenidosEspecificos;
import Dominio.ContenidosGenerales;
import java.util.ArrayList;

/**
 * @author DARKENSES
 * @version 1.0
 * @created 08-sep.-2016 11:45:03 p. m.
 */
public class ContenidosFijos{

    private ContenidosEspecificos contenidosEspecificos;
    private ContenidosGenerales contenidosGeneralesCierre;
    private ContenidosGenerales contenidosGeneralesDesarrollo;
    private ContenidosGenerales contenidosGeneralesInicio;
    public ContenidosGenerales m_ContenidosGenerales;
    public ContenidosEspecificos m_ContenidosEspecificos;

    public ContenidosFijos(){

    }

    public void finalize() throws Throwable{

    }

    public ContenidosEspecificos getContenidosEspecificos(){
        return null;
    }

    public ArrayList<ContenidosGenerales> getContenidosGenerales(){
        return null;
    }

    /**
     *
     * @param asignatura
     */
    public ContenidosEspecificos listarContenidosEspecificos(Asignatura asignatura){
        return null;
    }

    /**
     *
     * @param asignatura
     */
    public ContenidosGenerales listarContenidosGenerales(Asignatura asignatura){
        return null;
    }

    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasCierre(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }

    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasDesarrollo(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }

    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasInicio(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }

    /**
     *
     * @param actitudinalesElegidos
     * @param declarativosElegidos
     * @param procedimentalesElegidos
     * @return
     */
    public int setContenidosEspecificos(ArrayList<String> actitudinalesElegidos, ArrayList<String> declarativosElegidos, ArrayList<String> procedimentalesElegidos){
        return 0;
    }

    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasCierre(ArrayList<String> evidenciasElegidas){
        return 0;
    }

    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasDesarrollo(ArrayList<String> evidenciasElegidas){
        return 0;
    }

    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasInicio(ArrayList<String> evidenciasElegidas){
        return 0;
    }

    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosCierre(ArrayList<String> instrumentosElegidos){
        return 0;
    }

    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosDesarrollo(ArrayList<String> instrumentosElegidos){
        return 0;
    }

    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosInicio(ArrayList<String> instrumentosElegidos){
        return 0;
    }

}
