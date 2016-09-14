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
public class ContenidosEspecificos {

    private GestorFichero gestorFichero;
    private ArrayList<String> contenidosDeclarativosSeleccionados;
    private ArrayList<String> contenidosProcedimentalesSeleccionados;
    private ArrayList<String> contenidosActitudinalesSeleccionados;

    /**
     *
     * @param asignatura
     * @return
     */
    public ArrayList<String> listarContenidosEspecificos(Asignatura asignatura, String tipoContenido) {
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        return contenidos;
    }

    /**
     * Recibe los contenidos pasando una asignatura válida, Un arrayList de
     * Integer con los datos seleccionados y el tipo de contenido procedimental
     * o declarativo
     *
     * @param asignatura
     * @param contenidosSeleccionados
     * @param tipoContenido
     * @return -1 si el límite es inválido, en cualquier otro caso, el número de
     * contenidos selccionados
     */
    public int setContenidosEspecificos(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido) {
        int resultado = 0;
        gestorFichero = new GestorFichero();
        switch (tipoContenido) {
            case ("declarativo"):
                if (contenidosSeleccionados.isEmpty()) {
                    contenidosDeclarativosSeleccionados = new ArrayList<>();
                    contenidosDeclarativosSeleccionados.add(" ");
                    return 0;
                }
                resultado = setContenidosDeclarativos(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            case ("procedimentales"):
                if (contenidosSeleccionados.isEmpty()) {
                    contenidosProcedimentalesSeleccionados = new ArrayList<>();
                    contenidosProcedimentalesSeleccionados.add(" ");
                    return 0;
                }
                resultado = setContenidosProcedimentales(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            case ("actitudinal"):
                if (contenidosSeleccionados.isEmpty()) {
                    contenidosActitudinalesSeleccionados = new ArrayList<>();
                    contenidosActitudinalesSeleccionados.add(" ");
                    return 0;
                }
                resultado = setContenidosActitudinales(asignatura, contenidosSeleccionados, tipoContenido);
                break;
            default:
                resultado = 0;
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    private int setContenidosDeclarativos(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido) {
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosDeclarativosSeleccionados = new ArrayList<>();
        try {
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                getContenidosDeclarativosSeleccionados().add(contenidosDeclarativos.get(contenidoSeleccionado));
            });
        } catch (IndexOutOfBoundsException ex) {
            contenidosDeclarativosSeleccionados = new ArrayList<>();
            contenidosDeclarativosSeleccionados.add(" ");
            return -1;
        }
        return getContenidosDeclarativosSeleccionados().size();
    }
    private int setContenidosProcedimentales(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido) {
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosProcedimentalesSeleccionados = new ArrayList<>();
        try {
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                getContenidosProcedimentalesSeleccionados().add(contenidosDeclarativos.get(contenidoSeleccionado));
            });
        } catch (IndexOutOfBoundsException ex) {
            contenidosProcedimentalesSeleccionados = new ArrayList<>();
            contenidosProcedimentalesSeleccionados.add(" ");
            return -1;
        }
        return getContenidosProcedimentalesSeleccionados().size();
    }
    private int setContenidosActitudinales(Asignatura asignatura, ArrayList<Integer> contenidosSeleccionados, String tipoContenido) {
        int resultado = 0;
        ArrayList<String> contenidosDeclarativos = gestorFichero.getContenidosEspecificos(asignatura, tipoContenido);
        contenidosActitudinalesSeleccionados = new ArrayList<>();
        try {
            contenidosSeleccionados.stream().forEach((Integer contenidoSeleccionado) -> {
                getContenidosActitudinalesSeleccionados().add(contenidosDeclarativos.get(contenidoSeleccionado));
            });
        } catch (IndexOutOfBoundsException ex) {
            contenidosActitudinalesSeleccionados = new ArrayList<>();
            contenidosActitudinalesSeleccionados.add(" ");
            return -1;
        }
        return getContenidosActitudinalesSeleccionados().size();
    }

    /**
     * @return the contenidosDeclarativosSeleccionados
     */
    public ArrayList<String> getContenidosDeclarativosSeleccionados() {
        return contenidosDeclarativosSeleccionados;
    }
    /**
     * @return the contenidosProcedimentalesSeleccionados
     */
    public ArrayList<String> getContenidosProcedimentalesSeleccionados() {
        return contenidosProcedimentalesSeleccionados;
    }
    /**
     * @return the contenidosActitudinalesSeleccionados
     */
    public ArrayList<String> getContenidosActitudinalesSeleccionados() {
        return contenidosActitudinalesSeleccionados;
    }

}
