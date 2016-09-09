package Dominio;

import DAO.GestorFichero;
import java.util.ArrayList;


/**
 * Lo que compartir�n todas las materias
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:44:30 p. m.
 */
public class ContenidosGenerales {

	private String competenciasDisciplinares;
	private String competenciasGenericas;
	private String evidenciasDeAprendizaje;
	private GestorFichero gestorFichero;
	private String instrumentosDeEvaluacion;

	public ContenidosGenerales(){

	}

	public void finalize() throws Throwable {

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
	private int listarContenidosGenerales(String asignatura, ArrayList<int> bloques, String semestre){
		return 0;
	}

	/**
	 * 
	 * @param disciplinaresElegidas
	 * @param genericasElegidas
     * @return 
	 */
	public int setCompetencias(ArrayList<int> disciplinaresElegidas, ArrayList<int> genericasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param evidencias
     * @return 
	 */
	public int setEvidencias(ArrayList<int> evidencias){
		return 0;
	}

	/**
	 * 
	 * @param instrumentos
     * @return 
	 */
	public int setInstrumentos(ArrayList<int> instrumentos){
		return 0;
	}

}