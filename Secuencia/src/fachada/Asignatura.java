package Fachada;

import DAO.GestorFichero;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:45:17 p. m.
 */
public class Asignatura {

    private int bloque = 0;
    private GestorFichero gestorFichero;
    private String nombreAsignatura = " ";
    private String nombreCompletoMaestro = " ";
    private int semestre = 0;

    public Asignatura() {

    }

    public void finalize() throws Throwable {

    }

    public String getAsignatura() {
        return nombreAsignatura;
    }

    public int getBloque() {
        return bloque;
    }

    public int getSemestre() {
        return semestre;
    }

    public ArrayList<String> listarAsignaturas() throws IOException {
        gestorFichero = new GestorFichero();
        ArrayList<String> asignaturas = gestorFichero.getAsignaturas();
        return asignaturas;
    }

    public ArrayList<String> listarBloques(String nombreAsignatura, int semestre) throws IOException {
        gestorFichero = new GestorFichero();
        ArrayList<String> bloques = gestorFichero.getBloquesAsignatura(nombreAsignatura, semestre);
        return bloques;
    }

    public ArrayList<String> listarSemestres(String asignatura) {
        gestorFichero = new GestorFichero();
        ArrayList<String> semestres = new ArrayList<>();
        semestres = (ArrayList<String>) gestorFichero.getSemestresAsignatura(asignatura).clone();
        return semestres;
    }

    /**
     *
     * @param asignatura
     * @return
     */
    public int setAsignatura(String asignatura) {
        if (asignatura.isEmpty() || asignatura == null) {
            return 0;
        } else {
            this.nombreAsignatura = asignatura;
            return 1;
        }
    }

    /**
     *
     * @param bloque
     * @return
     */
    public int setBloque(int bloque) {
        if (bloque < 0 || bloque > 15) {
            return 0;
        } else {
            this.bloque = bloque;
            return 1;
        }
    }

    /**
     *
     * @param semestre
     * @return
     */
    public int setSemestre(int semestre) {
        if (semestre < 0 || semestre > 20) {
            return 0;
        } else {
            this.semestre = semestre;
            return 1;
        }
    }

    /**
     * @return the nombreCompletoMaestro
     */
    public String getNombreCompletoMaestro() {
        return nombreCompletoMaestro;
    }

    /**
     * @param nombreCompletoMaestro the nombreCompletoMaestro to set
     * @return 
     */
    public int setNombreCompletoMaestro(String nombreCompletoMaestro) {
        if (nombreCompletoMaestro.isEmpty() || nombreCompletoMaestro == null) {
            return 0;
        } else {
        this.nombreCompletoMaestro = nombreCompletoMaestro;
            return 1;
        }
    }

}
