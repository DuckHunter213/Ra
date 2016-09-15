package Fachada;

import DAO.GestorFichero;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:45:17 p. m.
 */
public class Asignatura{

    private String bloque = " ";
    private GestorFichero gestorFichero;
    private String nombreAsignatura = " ";
    private String nombreCompletoMaestro = " ";
    private int semestre = 0;

    public Asignatura(){

    }

    public void finalize() throws Throwable{

    }

    public String getAsignatura(){
        return nombreAsignatura;
    }

    public String getBloque(){
        return bloque;
    }

    public int getSemestre(){
        return semestre;
    }

    public ArrayList<String> listarAsignaturas(){
        gestorFichero = new GestorFichero();
        ArrayList<String> asignaturas;
        try{
            asignaturas = gestorFichero.getAsignaturas();
        }catch (IOException ex){
            asignaturas = new ArrayList<>();
        }
        return asignaturas;
    }

    public ArrayList<String> listarBloques(){
        gestorFichero = new GestorFichero();
        ArrayList<String> bloques = gestorFichero.getBloquesAsignatura(this.nombreAsignatura, this.semestre);
        return bloques;
    }

    public ArrayList<String> listarSemestres(){
        gestorFichero = new GestorFichero();
        ArrayList<String> semestres = new ArrayList<>();
        semestres = (ArrayList<String>) gestorFichero.getSemestresAsignatura(this.nombreAsignatura).clone();
        return semestres;
    }

    /**
     *
     * @param asignatura
     * @return
     */
    public int setAsignatura(String asignatura){
        if (asignatura.isEmpty() || asignatura == null){
            return 0;
        }else{
            this.nombreAsignatura = asignatura;
            return 1;
        }
    }

    /**
     *
     * @param bloque
     * @return
     */
    public int setBloque(String bloque){
        if (bloque.isEmpty() || bloque == null){
            return 0;
        }else{
            this.bloque = bloque;
            return 1;
        }
    }

    /**
     *
     * @param semestre
     * @return
     */
    public int setSemestre(int semestre){
        if (semestre < 0 || semestre > 20){
            return 0;
        }else{
            this.semestre = semestre;
            return 1;
        }
    }

    /**
     * @return the nombreCompletoMaestro
     */
    public String getNombreCompletoMaestro(){
        return nombreCompletoMaestro;
    }

    /**
     * @param nombreCompletoMaestro the nombreCompletoMaestro to set
     * @return
     */
    public int setNombreCompletoMaestro(String nombreCompletoMaestro){
        try{
            if (nombreCompletoMaestro.isEmpty()){
                return -1;
            }
            if (nombreCompletoMaestro.length() > 450){
                return 0;
            }
            this.nombreCompletoMaestro = nombreCompletoMaestro;
            return 1;

        }catch (NullPointerException ex){
            return -1;
        }
    }

}
