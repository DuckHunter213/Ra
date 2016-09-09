package Fachada;

import Dominio.ContenidosEspecificos;
import Dominio.ContenidosGenerales;

/**
 * @author DARKENSES
 * @version 1.0
 * @created 08-sep.-2016 11:45:03 p. m.
 */
public class ContenidosFijos {

	private ContenidosEspecificos contenidosEspecificos;
	private ContenidosGenerales contenidosGeneralesCierre;
	private ContenidosGenerales contenidosGeneralesDesarrollo;
	private ContenidosGenerales contenidosGeneralesInicio;
	public ContenidosGenerales m_ContenidosGenerales;
	public ContenidosEspecificos m_ContenidosEspecificos;

	public ContenidosFijos(){

	}

	public void finalize() throws Throwable {

	}

	public ContenidosEspecificos getContenidosEspecificos(){
		return null;
	}

	public ArrayList<ContenidosGenerales> getContenidosGenerales(){
		return null;
	}

	/**
	 * 
	 * @param asignatura
	 */
	public ContenidosEspecificos listarContenidosEspecificos(Asignatura asignatura){
		return null;
	}

	/**
	 * 
	 * @param asignatura
	 */
	public ContenidosGenerales listarContenidosGenerales(Asignatura asignatura){
		return null;
	}

	/**
	 * 
	 * @param disciplinaresElegidas
	 * @param genericasElegidas
	 */
	public int setCompetenciasCierre(ArrayList<int> disciplinaresElegidas, ArrayList<int> genericasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param disciplinaresElegidas
	 * @param genericasElegidas
	 */
	public int setCompetenciasDesarrollo(ArrayList<int> disciplinaresElegidas, ArrayList<int> genericasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param disciplinaresElegidas
	 * @param genericasElegidas
	 */
	public int setCompetenciasInicio(ArrayList<int> disciplinaresElegidas, ArrayList<int> genericasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param actitudinalesElegidos
	 * @param declarativosElegidos
	 * @param procedimentalesElegidos
	 */
	public int setContenidosEspecificos(ArrayList<int> actitudinalesElegidos, ArrayList<int> declarativosElegidos, ArrayList<int> procedimentalesElegidos){
		return 0;
	}

	/**
	 * 
	 * @param evidenciasElegidas
	 */
	public int setEvidenciasCierre(ArrayList<int> evidenciasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param evidenciasElegidas
	 */
	public int setEvidenciasDesarrollo(ArrayList<int> evidenciasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param evidenciasElegidas
	 */
	public int setEvidenciasInicio(ArrayList<int> evidenciasElegidas){
		return 0;
	}

	/**
	 * 
	 * @param instrumentosElegidos
	 */
	public int setInstrumentosCierre(ArrayList<int> instrumentosElegidos){
		return 0;
	}

	/**
	 * 
	 * @param instrumentosElegidos
	 */
	public int setInstrumentosDesarrollo(ArrayList<int> instrumentosElegidos){
		return 0;
	}

	/**
	 * 
	 * @param instrumentosElegidos
	 */
	public int setInstrumentosInicio(ArrayList<int> instrumentosElegidos){
		return 0;
	}

}