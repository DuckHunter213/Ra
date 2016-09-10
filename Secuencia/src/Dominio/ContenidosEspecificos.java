package Dominio;

import DAO.GestorFichero;
import Fachada.Asignatura;
import java.util.ArrayList;

/**
 * @author DARKENSES
 * @version 1.0
 * @created 08-sep.-2016 11:43:47 p. m.
 */
public class ContenidosEspecificos{

    private String contenidosActitudinales;
    private String contenidosDeclarativos;
    private String contenidosProcedimentales;
    private GestorFichero gestorFichero;

    public ContenidosEspecificos(){

    }

    public void finalize() throws Throwable{

    }

    public ArrayList<String> getContenidosEspecificos(){
        return null;
    }

    /**
     *
     * @param asignatura
     * @return 
     */
    public ArrayList<String> listarContenidosEspecificosProcedimental(Asignatura asignatura){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getContenidosEspecificos(asignatura, "procedimentales");
        return contenidos;
    }
    
    /**
     *
     * @param asignatura
     * @return 
     */
    public ArrayList<String> listarContenidosEspecificosDeclarativo(Asignatura asignatura){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getContenidosEspecificos(asignatura, "declarativo");
        return contenidos;
    }

    /**
     *
     * @param actitudinalesElegidos
     * @param declarativosElegidos
     * @param prodecimentalesElegidos
     * @return
     */
    public int setContenidosEspecificos(ArrayList<String> actitudinalesElegidos, ArrayList<String> declarativosElegidos, ArrayList<String> prodecimentalesElegidos){
        return 0;
    }

}
