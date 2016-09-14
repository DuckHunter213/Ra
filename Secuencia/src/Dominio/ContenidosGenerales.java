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
public class ContenidosGenerales {

    private GestorFichero gestorFichero;

    public ContenidosGenerales() {

    }

    public ArrayList<String> listarCompetencias(String tipoCompetencia, String nombreCompetencia) {
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = new ArrayList<>();
        contenidos = gestorFichero.getCompetenciasGenerales(tipoCompetencia, nombreCompetencia);
        return contenidos;
    }

    public ArrayList<String> listarOtrosContenidos(String tipoContenido) {
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = new ArrayList<>();
        contenidos = gestorFichero.getContenidosGenerales(tipoContenido);
        return contenidos;
    }

    /**
     * Enlista los contenidos que fueron elegidos entre los distintos tipos de
     * competencia y competencias
     *
     * @param contenidosSeleccionados Un ArrayList de Integers con contenidos
     * seleccionados a partir de 0
     * @param tipoCompetencia el tipo, puede se Disciplinar o genérico
     * @param nombreCompetencia el nombre de la competencia, ciencias sociales,
     * matemáticas, etc.
     * @return Un ArrayList con lo que se seleccionó
     */
    public ArrayList<String> getCompetenciasElegidas(ArrayList<Integer> contenidosSeleccionados, String tipoCompetencia, String nombreCompetencia) {
        ArrayList<String> contenidos = new ArrayList<>();
        if (contenidosSeleccionados.isEmpty()) {
            contenidos.add(" ");
            return contenidos;
        }
        ArrayList<String> listaContenidos;
        listaContenidos = listarCompetencias(tipoCompetencia, nombreCompetencia);
        gestorFichero = new GestorFichero();
        try{
            contenidos = seleccionarContenidos(contenidosSeleccionados, listaContenidos);            
        }catch(IndexOutOfBoundsException){
            contenidos.add(" ");
        }
        return contenidos;
    }

    /**
     * Enlista las evidencias de aprendizaje e instrumentos de evaluación
     *
     * @param contenidosSeleccionados Un ArrayList de Integers con contenidos
     * seleccionados a partir de 0
     * @param tipoContenido
     * @return Un ArrayList con lo que se seleccionó
     */
    public ArrayList<String> getOtrosContenidos(ArrayList<Integer> contenidosSeleccionados, String tipoContenido) throws IndexOutOfBoundsException{
        ArrayList<String> contenidos = new ArrayList<>();
        if (contenidosSeleccionados.isEmpty()) {
            contenidos.add(" ");
            return contenidos;
        }
        ArrayList<String> listaContenidos;
        listaContenidos = listarOtrosContenidos(tipoContenido);
        gestorFichero = new GestorFichero();
        try{
            contenidos = seleccionarContenidos(contenidosSeleccionados, listaContenidos);            
        }catch (IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException("límites erroneos");            
        }
        return contenidos;
    }

    private ArrayList<String> seleccionarContenidos(ArrayList<Integer> contenidosSeleccionados, ArrayList<String> listaContenidos) throws IndexOutOfBoundsException{
        ArrayList<String> contenidos = new ArrayList<>();
        try {
            for (Integer contenidoSeleccionado : contenidosSeleccionados) {
                contenidos.add(listaContenidos.get(contenidoSeleccionado));
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("límites erroneos");
        }
        return contenidos;
    }

}
