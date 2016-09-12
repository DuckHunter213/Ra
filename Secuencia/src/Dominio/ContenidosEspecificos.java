package Dominio;

import DAO.GestorFichero;
import Fachada.Asignatura;
import java.util.ArrayList;
import java.util.function.Consumer;
import util.enumContenidosEspecificos;

/**
 * @author DARKENSES
 * @version 1.0
 * @created 08-sep.-2016 11:43:47 p. m.
 */
public class ContenidosEspecificos{
    private GestorFichero gestorFichero;
    private ArrayList<String> contenidosDeclarativosSeleccionados;
    private ArrayList<String> contenidosProcedimentalesSeleccionados;
    private ArrayList<String> contenidosActitudinalesSeleccionados;


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
     * Recibe los contenidos pasando una asignatura válida, Un arrayList de Integer con los datos seleccionados y el tipo de contenido procedimental o declarativo
     * @param asignatura
     * @param contenidosSeleccionados
     * @param tipoContenido
     * @return -1 si el límite es inválido, en cualquier otro caso, el número de contenidos selccionados
     */
    public int setContenidosEspecificos(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido){
        int resultado = 0;
        if (contenidosSeleccionados.isEmpty())
            return 0;
        gestorFichero = new GestorFichero();
        switch(tipoContenido){
            case ("declarativo"):
                resultado = setContenidosDeclarativos(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            case ("procedimentales"):
                resultado = setContenidosProcedimentales(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            case ("actitudinal"):
                resultado = setContenidosActitudinales(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            default:
                resultado = 0;
        }
        if (resultado > 1)
            resultado = 1;
        return resultado;
    }
    
    private int setContenidosDeclarativos(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido){
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosDeclarativosSeleccionados = new ArrayList<>();
        try{
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                contenidosDeclarativosSeleccionados.add(contenidosDeclarativos.get(contenidoSeleccionado));
            });
        } catch (IndexOutOfBoundsException ex){
            return -1;
        }        
        return contenidosDeclarativosSeleccionados.size();
    }
    private int setContenidosProcedimentales(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido){
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosProcedimentalesSeleccionados = new ArrayList<>();
        try{
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                contenidosProcedimentalesSeleccionados.add(contenidosDeclarativos.get(contenidoSeleccionado));
            });            
        } catch (IndexOutOfBoundsException ex){
            return -1;
        }        
        return contenidosProcedimentalesSeleccionados.size();
    }
    private int setContenidosActitudinales(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido){
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosActitudinalesSeleccionados = new ArrayList<>();
        try{
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                contenidosActitudinalesSeleccionados.add(contenidosDeclarativos.get(contenidoSeleccionado));
            });            
        } catch (IndexOutOfBoundsException ex){
            return -1;
        }        
        return contenidosActitudinalesSeleccionados.size();
    }

}
