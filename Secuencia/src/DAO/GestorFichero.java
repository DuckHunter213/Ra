package DAO;

import Fachada.Asignatura;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.FileNotFoundException;
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
	public ArrayList<String> getBloquesAsignatura(String nombreAsignatura, int semestreAsignatura) throws FileNotFoundException, IOException{
            ArrayList<String> archivos = new ArrayList<>();
            String pathCarpeta = System.getProperty("user.dir") + 
                    System.getProperty("file.separator") + "src" +
                    System.getProperty("file.separator") + "Archivos" +
                    System.getProperty("file.separator") + "Asignaturas" +
                    System.getProperty("file.separator") + nombreAsignatura +
                    System.getProperty("file.separator") + Integer.toString(semestreAsignatura) + ".csv";

            CsvReader archivo = new CsvReader(pathCarpeta);
            archivo.setDelimiter(';');
            while (archivo.readRecord()) {
            	System.out.print("Columna 1 :" 	+ archivo.get(1));
                archivos.add(archivo.get(1));
            }
            return archivos;
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