package Fachada;

import DAO.GestorFichero;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:45:17 p. m.
 */
public class Asignatura{

    private int bloque = 0;
    private GestorFichero gestorFichero;
    private String nombreAsignatura = " ";
    private int semestre = 0;

    public Asignatura(){

    }

    public void finalize() throws Throwable{

    }

    public String getAsignatura(){
        return nombreAsignatura;
    }

    public int getBloque(){
        return bloque;
    }

    public int getSemestre(){
        return semestre;
    }

    public ArrayList<String> listarAsignaturas() throws IOException{
        gestorFichero = new GestorFichero();
        ArrayList<String> asignaturas = gestorFichero.getAsignaturas();
        return asignaturas;
    }

    public ArrayList<String> listarBloques(String nombreAsignatura, int semestre) throws IOException{
        gestorFichero = new GestorFichero();
        ArrayList<String> bloques = gestorFichero.getBloquesAsignatura(nombreAsignatura, semestre);
        return bloques;
    }

    public ArrayList<String> listarSemestres(String asignatura){
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
    public int setAsignatura(String asignatura){
        return 0;
    }

    /**
     *
     * @param bloque
     * @return
     */
    public int setBloque(int bloque){
        return 0;
    }

    /**
     *
     * @param semestre
     * @return
     */
    public int setSemestre(int semestre){
        return 0;
    }

}
