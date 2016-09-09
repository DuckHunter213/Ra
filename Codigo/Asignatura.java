package Fachada;


/**
 * @author Gerardo Mares
 * @version 1.0
 * @created 08-sep.-2016 11:45:17 p. m.
 */
public class Asignatura {

	private int bloque = 0;
	private GeneradorSecuencia gestorSecuencia = GeneradorSecuencia();
	private String nombreAsignatura = " ";
	private int semestre = 0;

	public Asignatura(){

	}

	public void finalize() throws Throwable {

	}

	public String getAsignatura(){
		return "";
	}

	public int getBloque(){
		return 0;
	}

	public int getSemestre(){
		return 0;
	}

	public ArrayList<String> listarAsignaturas(){
		return null;
	}

	public ArrayList<int> listarBloques(){
		return null;
	}

	public ArrayList<int> listarSemestres(){
		return null;
	}

	/**
	 * 
	 * @param asignatura
	 */
	public int setAsignatura(String asignatura){
		return 0;
	}

	/**
	 * 
	 * @param bloque
	 */
	public int setBloque(int bloque){
		return 0;
	}

	/**
	 * 
	 * @param semestre
	 */
	public int setSemestre(int semestre){
		return 0;
	}

}