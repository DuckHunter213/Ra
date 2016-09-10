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

    private String competenciasDisciplinares;
    private String competenciasGenericas;
    private String evidenciasDeAprendizaje;
    private GestorFichero gestorFichero;
    private String instrumentosDeEvaluacion;

    public ContenidosGenerales(){

    }

    public void finalize() throws Throwable{

    }

    public ArrayList<String> getContenidosGenerales(){
        return null;
    }

    /**
     *
     * @param asignatura
     * @param bloques
     * @param semestre
     */
    public ArrayList<String> listarCompetenciasDisciplinaresMatematicas(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Disciplinar", "Matemáticas");
        return contenidos;
    }
    /**
     *
     * @return 
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasExperimentales(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Disciplinar", "Ciencias experimentales");
        return contenidos;
    }
    /**
     *
     * @return 
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasSociales(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Disciplinar", "Ciencias sociales");
        return contenidos;
    }
    /**
     *
     * @return 
     */
    public ArrayList<String> listarCompetenciasDisciplinaresComunicacion(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Disciplinar", "Comunicación");
        return contenidos;
    }
    
    
    public ArrayList<String> listarCompetenciasGenericasAutodetermina(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Se autodetermina y cuida de sí");
        return contenidos;
    }
    public ArrayList<String> listarCompetenciasGenericasExpresa(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Se expresa y comunica");
        return contenidos;
    }
    public ArrayList<String> listarCompetenciasGenericasPiensa(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Piensa crítica y reflexivamente");
        return contenidos;
    }
    public ArrayList<String> listarCompetenciasGenericasAprende(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Aprende de forma autónoma");
        return contenidos;
    }
    public ArrayList<String> listarCompetenciasGenericasTrabaja(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Trabaja en forma colaborativa");
        return contenidos;
    }
    public ArrayList<String> listarCompetenciasGenericasParticipa(){
        gestorFichero = new GestorFichero();
        ArrayList<String> contenidos = gestorFichero.getCompetenciasGenerales("Genéricas", "Participa con responsabilidad en la sociedad");
        return contenidos;
    }
    
    
    /**
     *
     * @param asignatura
     * @param bloques
     * @param semestre
     */
    private int listarContenidosGenerales(String asignatura, ArrayList<String> bloques, String semestre){
        return 0;
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
