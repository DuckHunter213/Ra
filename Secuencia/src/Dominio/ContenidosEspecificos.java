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
    private GestorFichero gestorFichero;

    public ContenidosEspecificos(){

    }


    public ArrayList<String> getContenidosEspecificos(){
        return null;
    }

    /**
     *
     * @param asignatura
     * @return 
     */
    public ArrayList<String> listarContenidosEspecificos(Asignatura asignatura, String tipoContenido){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
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
