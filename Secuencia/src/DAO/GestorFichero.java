package DAO;

import Fachada.Asignatura;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Luis Fernando Gomez Alejandre
 * @version 1.0
 * @created 08-sep.-2016 11:42:18 p. m.
 */
public class GestorFichero {

    public GestorFichero() {

    }


    private static String crearPathInicial() {
        String path = System.getProperty("user.dir")
                + System.getProperty("file.separator") + "src"
                + System.getProperty("file.separator") + "Archivos"
                + System.getProperty("file.separator") + "Asignaturas";
        return path;
    }

    private static String crearPathContenidosEspecificos(Asignatura asignatura) {
        String path = crearPathInicial()
                + System.getProperty("file.separator") + asignatura.getAsignatura()
                + System.getProperty("file.separator") + Integer.toString(asignatura.getSemestre()) + ".csv";
        return path;
    }

    private static String crearPathContenidosGenerales(String tipoContenido) {
        String path = System.getProperty("user.dir")
                + System.getProperty("file.separator") + "src"
                + System.getProperty("file.separator") + "Archivos"
                + System.getProperty("file.separator") + "contenidosGenerales"
                + System.getProperty("file.separator") + tipoContenido + ".csv";
        return path;
    }

    private static ArrayList<String> cargarContenidosEspecificos(Asignatura asignatura, CsvReader archivo, String tipoContenido) throws IOException {
        ArrayList<String> contenidosGenerales = new ArrayList<>();
        while (archivo.readRecord()) {
            String bloqueBuscado = asignatura.getBloque() + " " + tipoContenido;
            String bloqueRecibido = archivo.get(0);
            if (bloqueRecibido.indexOf(bloqueBuscado) >= 0) {
                for (String contenido : archivo.getValues()) {
                    if (!(contenido.indexOf(bloqueBuscado) >= 0) && contenido.length() > 2) {
                        contenidosGenerales.add(contenido);
                    }
                }
            }
        }
        return contenidosGenerales;
    }

    private static ArrayList<String> cargarContenidosGenerales(CsvReader archivo) throws IOException {
        ArrayList<String> contenidosGenerales = new ArrayList<>();
        while (archivo.readRecord()) {
            contenidosGenerales.addAll(Arrays.asList(archivo.getValues()));
        }
        return contenidosGenerales;
    }

    private static ArrayList<String> cargarCompetenciaDisciplinar(CsvReader archivo, String tipoCompetencia) throws IOException {
        ArrayList<String> contenidosGenerales = new ArrayList<>();
        while (archivo.readRecord()) {
            if (archivo.get(0).indexOf(tipoCompetencia) + 1 > 0) {
                for (String contenido : archivo.getValues()) {
                    if (!(contenido.indexOf(tipoCompetencia) + 1 > 0) && contenido.length() > 2) {
                        contenidosGenerales.add(contenido);
                    }
                }
            }
        }
        return contenidosGenerales;
    }

    public ArrayList<String> getAsignaturas() throws IOException {
        ArrayList<String> archivos = new ArrayList<>();
        String pathCarpeta = crearPathInicial();
        try {
            File directorio = new File(pathCarpeta);
            String[] arregloArchivos = directorio.list();
            for (String file : arregloArchivos) {
                if (file != null) {
                    archivos.add(file);
                }
            }
        } catch (Exception ex) {
            archivos.add("No hay materias disponibles :(");
        }
        return archivos;
    }

    /**
     *
     * @param nombreAsignatura
     * @param semestreAsignatura
     * @return 
     */
    public ArrayList<String> getBloquesAsignatura(String nombreAsignatura, int semestreAsignatura){
        ArrayList<String> archivos = new ArrayList<>();
        String pathCarpeta = crearPathInicial()
                + System.getProperty("file.separator") + nombreAsignatura
                + System.getProperty("file.separator") + Integer.toString(semestreAsignatura) + ".csv";

        if (nombreAsignatura.isEmpty() || " ".equals(nombreAsignatura)) {
            archivos.add("No hay bloques disponibles :(");
        } else {
            try {
                CsvReader archivo = new CsvReader(pathCarpeta);
                archivo.setDelimiter(';');
                int contador = 0;
                while (archivo.readRecord()) {
                    contador += 1;
                    if (contador % 2 == 0) {
                        archivos.add(archivo.get(0).substring(0, 8));
                    }
                }
            } catch (Exception ex) {
                archivos.add("No hay bloques disponibles :(");
            }
        }
        return archivos;
    }

    /**
     *
     * @param nombreAsignatura
     * @return
     */
    public ArrayList<String> getSemestresAsignatura(String nombreAsignatura) {
        ArrayList<String> archivos = new ArrayList<>();
        String pathCarpeta = crearPathInicial()
                + System.getProperty("file.separator") + nombreAsignatura;
        if (nombreAsignatura.isEmpty() || " ".equals(nombreAsignatura)) {
            archivos.add("No hay semestres disponibles :(");
        } else {
            try {
                File directorio = new File(pathCarpeta);
                String[] arregloArchivos = directorio.list();
                for (String file : arregloArchivos) {
                    if (file != null) {
                        archivos.add(file.substring(0, 1));
                    }
                }
            } catch (Exception ex) {
                archivos.add("No hay semestres disponibles :(");
            }
        }
        return archivos;
    }

    /**
     *
     * @param tipoContenido
     * @return 
     */
    public ArrayList<String> getContenidosGenerales(String tipoContenido) {
        ArrayList<String> contenidosGenerales = new ArrayList<>();
        try {
        String pathCarpeta = crearPathContenidosGenerales(tipoContenido);
            CsvReader archivo = new CsvReader(pathCarpeta);
            archivo.setDelimiter(';');
            contenidosGenerales = cargarContenidosGenerales(archivo);
        } catch (Exception ex) {
            contenidosGenerales.add("No hay bloques disponibles :(");
        }
        return contenidosGenerales;
    }

    /**
     *
     * @param asignatura
     * @param tipoContenido
     * @return 
     */
    public ArrayList<String> getContenidosEspecificos(Asignatura asignatura, String tipoContenido) {
        ArrayList<String> contenidosEspecificos = new ArrayList<>();
        String pathCarpeta = crearPathContenidosEspecificos(asignatura);

        if (asignatura.getAsignatura().isEmpty() || asignatura.getAsignatura().equals(" ")) {
            contenidosEspecificos.add("No hay bloques disponibles :(");
        } else {
            try {
                CsvReader archivo = new CsvReader(pathCarpeta);
                archivo.setDelimiter(';');
                contenidosEspecificos = cargarContenidosEspecificos(asignatura, archivo, tipoContenido);
            } catch (Exception ex) {
                contenidosEspecificos.add("No hay bloques disponibles :(");
            }
        }
        return contenidosEspecificos;
    }

    /**
     *
     * @param competencia
     * @param tipoCompetencia
     * @return 
     */
    public ArrayList<String> getCompetenciasGenerales(String competencia, String tipoCompetencia) {
        ArrayList<String> contenidosGenerales = new ArrayList<>();
        String pathCarpeta = crearPathContenidosGenerales(competencia);
        try {
            CsvReader archivo = new CsvReader(pathCarpeta);
            archivo.setDelimiter(';');
            contenidosGenerales = cargarCompetenciaDisciplinar(archivo, tipoCompetencia);
        } catch (Exception ex) {
            contenidosGenerales.add("No hay bloques disponibles :(");
        }
        return contenidosGenerales;
    }
}
