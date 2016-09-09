package Fachada;

import Dominio.ContenidosAgregadosInformativos;
import Dominio.ContenidosAgregadosGenerales;
import java.util.ArrayList;

/**
 * @author Luis Fernando Gomez Alejandre
 * @version 1.0
 * @created 08-sep.-2016 11:45:25 p. m.
 */
public class ContenidosAgregados{

    private ArrayList<ContenidosAgregadosGenerales> contenidosAgregadosGenerales;
    private ContenidosAgregadosInformativos contenidosAgregadosInformativos;
    private String fechaInicio = " ";
    private String nombreCompletoDocente = " ";
    private int numeroSecuencia = 0;
    private int numeroSesiones = 0;
    private String periodoEscolar = " ";
    public ContenidosAgregadosGenerales m_ContenidosAgregadosGenerales;
    public ContenidosAgregadosInformativos m_ContenidosAgregadosInformativos;

    public ContenidosAgregados(){

    }

    public void finalize() throws Throwable{

    }

    public ArrayList<ContenidosAgregadosGenerales> getContenidosGenerales(){
        return null;
    }

    public ContenidosAgregadosInformativos getContenidosInformativos(){
        return null;
    }

    public String getFechaInicio(){
        return "";
    }

    public String getNombreCompletoDocente(){
        return "";
    }

    public int getNumeroSecuencia(){
        return 0;
    }

    public int getNumeroSesiones(){
        return 0;
    }

    public int getPeriodoEscolar(){
        return 0;
    }

    /**
     *
     * @param aprendizaje
     * @param ensenianza
     */
    public int setContenidosAgregadosCierre(String aprendizaje, String ensenianza){
        return 0;
    }

    /**
     *
     * @param aprendizaje
     * @param ensenianza
     */
    public int setContenidosAgregadosDesarrollo(String aprendizaje, String ensenianza){
        return 0;
    }

    /**
     *
     * @param aprendizaje
     * @param ensenianza
     */
    public int setContenidosAgregadosInicio(String aprendizaje, String ensenianza){
        return 0;
    }

    /**
     *
     * @param listaAsignaturasRelacionadas
     * @param listaFuentesInformacion
     * @param listaObservaciones
     * @param propositoSecuencia
     * @param recursosMateriales
     */
    public int setContenidosInformativos(String listaAsignaturasRelacionadas, String listaFuentesInformacion, String listaObservaciones, String propositoSecuencia, String recursosMateriales){
        return 0;
    }

    /**
     *
     * @param fecha
     */
    public int setFechaInicio(String fecha){
        return 0;
    }

    /**
     *
     * @param nombre
     */
    public int setNombreCompletoDocente(int nombre){
        return 0;
    }

    /**
     *
     * @param numero
     */
    public int setNumeroSecuencia(int numero){
        return 0;
    }

    /**
     *
     * @param numeroSesiones
     */
    public int setNumeroSesiones(int numeroSesiones){
        return 0;
    }

    /**
     *
     * @param periodo
     */
    public int setPeriodoEscolar(String periodo){
        return 0;
    }

}
