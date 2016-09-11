package Dominio;

import DAO.GestorFichero;
import java.util.ArrayList;

/**
 * Lo que compartiran todas las materias
 *
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:44:30 p. m.
 */
public class ContenidosGenerales{
    private GestorFichero gestorFichero;

    public ContenidosGenerales(){

    }

    public ArrayList<String> getContenidosGenerales(){
        return null;
    }

    public ArrayList<String> listarCompetencias(String tipoCompetencia, String nombreCompetencia){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales(tipoCompetencia, nombreCompetencia);
        return contenidos;
    }
    public ArrayList<String> listarOtrosContenidos(String contenido){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getContenidosGenerales(contenido);
        return contenidos;
    }

    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetencias(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }

    /**
     *
     * @param evidencias
     * @return
     */
    public int setEvidencias(ArrayList<String> evidencias){
        return 0;
    }

    /**
     *
     * @param instrumentos
     * @return
     */
    public int setInstrumentos(ArrayList<String> instrumentos){
        return 0;
    }

}
