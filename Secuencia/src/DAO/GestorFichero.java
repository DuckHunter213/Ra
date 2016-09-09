package DAO;

import Fachada.Asignatura;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Fernando Gomez Alejandre
 * @version 1.0
 * @created 08-sep.-2016 11:42:18 p. m.
 */
public class GestorFichero {

	public GestorFichero(){

	}

	public void finalize() throws Throwable {

	}

	public ArrayList<String> getAsignaturas() throws IOException{
            ArrayList<String> archivos = new ArrayList<>();
            String pathCarpeta = System.getProperty("user.dir") + 
                    System.getProperty("file.separator") + "src" +
                    System.getProperty("file.separator") + "Archivos" +
                    System.getProperty("file.separator") + "Asignaturas";
            File directorio = new File(pathCarpeta);
            String[] arregloArchivos = directorio.list();
            for (String file : arregloArchivos) {
                if (file != null){
                    System.out.println(file);
                    archivos.add(file);
                }
            }
            return archivos;
	}

	/**
	 * 
	 * @param nombreAsignatura
	 * @param semestreAsignatura
	 */
	public int getBloquesAsignatura(String nombreAsignatura, int semestreAsignatura){
		return 0;
	}

	/**
	 * 
	 * @param asignatura
	 */
	public ArrayList<String> getContenidosEspecificos(Asignatura asignatura){
		return null;
	}

	/**
	 * 
	 * @param asignatura
	 */
	public ArrayList<String> getContenidosGenerales(Asignatura asignatura){
		return null;
	}

	/**
	 * 
	 * @param nombreAsignatura
        * @return 
	 */
	public ArrayList<String> getSemestresAsignatura(String nombreAsignatura){
            ArrayList<String> archivos = new ArrayList<>();
            String pathCarpeta = System.getProperty("user.dir") + 
                    System.getProperty("file.separator") + "src" +
                    System.getProperty("file.separator") + "Archivos" +
                    System.getProperty("file.separator") + "Asignaturas" +
                    System.getProperty("file.separator") + nombreAsignatura;
            File directorio = new File(pathCarpeta);
            String[] arregloArchivos = directorio.list();
            for (String file : arregloArchivos) {
                if (file != null){
                    System.out.println(file);
                    archivos.add(file);
                }
            }
            return archivos;
	}

}