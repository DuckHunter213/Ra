package Fachada;

import Dominio.ContenidosEspecificos;
import Dominio.ContenidosGenerales;
import java.util.ArrayList;
import util.enumContenidosEspecificos;
import util.enumContenidosGenerales;

/**
 * @author DARKENSES
 * @version 1.0
 * @created 08-sep.-2016 11:45:03 p. m.
 */
public class ContenidosFijos {

    public final int ASIGNATURA_VALIDA = 1;
    public final int ASIGNATURA_INVALIDA = 0;

    private Asignatura asignatura;
    private ContenidosEspecificos contenidosEspecificos;
    private ContenidosGenerales contenidosGenerales;
    
    private ArrayList<String> competenciasDisciplinaresMatematicasInicio;
    private ArrayList<String> competenciasDisciplinaresComunicacionInicio;
    private ArrayList<String> competenciasDisciplinaresCienciasSocialesInicio;
    private ArrayList<String> competenciasDisciplinaresCienciasExperimentalesInicio;
    private ArrayList<String> competenciasDisciplinaresMatematicasDesarrollo;
    private ArrayList<String> competenciasDisciplinaresComunicacionDesarrollo;
    private ArrayList<String> competenciasDisciplinaresCienciasSocialesDesarrollo;
    private ArrayList<String> competenciasDisciplinaresCienciasExperimentalesDesarrollo;
    private ArrayList<String> competenciasDisciplinaresMatematicasCierre;
    private ArrayList<String> competenciasDisciplinaresComunicacionCierre;
    private ArrayList<String> competenciasDisciplinaresCienciasSocialesCierre;
    private ArrayList<String> competenciasDisciplinaresCienciasExperimentalesCierre;
    
    private ArrayList<String> competenciasGenericasAprendeInicio;
    private ArrayList<String> competenciasGenericasAutodeterminaInicio;
    private ArrayList<String> competenciasGenericasExpresaInicio;
    private ArrayList<String> competenciasGenericasParticipaInicio;
    private ArrayList<String> competenciasGenericasPiensaInicio;
    private ArrayList<String> competenciasGenericasTrabajaInicio;
    private ArrayList<String> competenciasGenericasAprendeDesarrollo;
    private ArrayList<String> competenciasGenericasAutodeterminaDesarrollo;
    private ArrayList<String> competenciasGenericasExpresaDesarrollo;
    private ArrayList<String> competenciasGenericasParticipaDesarrollo;
    private ArrayList<String> competenciasGenericasPiensaDesarrollo;
    private ArrayList<String> competenciasGenericasTrabajaDesarrollo;
    private ArrayList<String> competenciasGenericasAprendeCierre;
    private ArrayList<String> competenciasGenericasAutodeterminaCierre;
    private ArrayList<String> competenciasGenericasExpresaCierre;
    private ArrayList<String> competenciasGenericasParticipaCierre;
    private ArrayList<String> competenciasGenericasPiensaCierre;
    private ArrayList<String> competenciasGenericasTrabajaCierre;

    private ArrayList<String> listarContenidosGenericos(String tipoListado) {
        ArrayList<String> contenidos = new ArrayList<>();
        contenidosEspecificos = new ContenidosEspecificos();
        ContenidosGenerales misContenidosGenerales;
        if (isAsignaturaValida(asignatura) == 1) {
            switch (tipoListado) {
                case "declarativo":
                    contenidos = contenidosEspecificos.listarContenidosEspecificos(this.asignatura, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
                    break;
                case "procedimentales":
                    contenidos = contenidosEspecificos.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());
                    break;
                case "actitudinales":
                    contenidos = contenidosEspecificos.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_ACTITUDINAL.toString());
                    break;
                case "instrumentos":
                    misContenidosGenerales = new ContenidosGenerales();
                    contenidos = misContenidosGenerales.listarOtrosContenidos(enumContenidosGenerales.TIPO_CONT_GENERICO_INSTRUMENTOS.toString());
                    break;
                case "evidencias":
                    misContenidosGenerales = new ContenidosGenerales();
                    contenidos = misContenidosGenerales.listarOtrosContenidos(enumContenidosGenerales.TIPO_CONT_GENERICO_EVIDENCIAS.toString());
                    break;
                default:
                    contenidos.add("hubo un error en la matrix X(");
            }
        } else {
            contenidos.add("No hay contenidos que listar");
        }
        return contenidos;
    }
    private ArrayList<String> listarCompetencias(String contenidoDisciplinar, String tipoContenido) {
        ArrayList<String> contenidos = new ArrayList<>();
        if (isAsignaturaValida(asignatura) == 1) {
            ContenidosGenerales misContenidosGenerales = new ContenidosGenerales();
            contenidos = misContenidosGenerales.listarCompetencias(contenidoDisciplinar, tipoContenido);
        } else {
            contenidos.add(" ");
        }
        return contenidos;
    }
    private int isAsignaturaValida(Asignatura asignatura) {
        if (asignatura.getAsignatura().isEmpty() || asignatura.getAsignatura().equals("")) {
            return ASIGNATURA_INVALIDA;
        } else if (asignatura.getBloque() <= 0) {
            return ASIGNATURA_INVALIDA;
        } else if (asignatura.getSemestre() <= 0) {
            return ASIGNATURA_INVALIDA;
        }
        return ASIGNATURA_VALIDA;
    }
    public int setAsignatura(Asignatura asignatura) {
        if (isAsignaturaValida(asignatura) == ASIGNATURA_VALIDA) {
            this.asignatura = asignatura;
            return ASIGNATURA_VALIDA;
        } else {
            this.asignatura = new Asignatura();
        }
        return ASIGNATURA_INVALIDA;
    }
    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    /**
     * En la sección "Saberes necesarios para el desarrollo de competencias" de
     * la rúbrica, enlista los contenidos que irán dentro del espacio
     * "Contenidos Declarativos"
     *
     * @return Regresa un ArrayList con uns lista de contenidos declarativos, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarContenidosDeclarativos() {
        ArrayList<String> contenidos = listarContenidosGenericos(enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
        return contenidos;
    }
    /**
     * En la sección "Saberes necesarios para el desarrollo de competencias" de
     * la rúbrica, enlista los contenidos que irán dentro del espacio
     * "Contenidos Procedimentales"
     *
     * @return Regresa un ArrayList con uns lista de contenidos procedimentales,
     * en caso de que no existan contenidos, regresa una lista de un solo
     * elemento
     */
    public ArrayList<String> listarContenidosProcedimentales() {
        ArrayList<String> contenidos = listarContenidosGenericos(enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());
        return contenidos;
    }
    /**
     * En la sección "Saberes necesarios para el desarrollo de competencias" de
     * la rúbrica, enlista los contenidos que irán dentro del espacio
     * "Contenidos Actitudinales"
     *
     * @return Regresa un ArrayList con uns lista de contenidos procedimentales,
     * en caso de que no existan contenidos, regresa una lista de un solo
     * elemento
     */
    public ArrayList<String> listarContenidosActitudinales() {
        ArrayList<String> contenidos = listarContenidosGenericos(enumContenidosEspecificos.CONTENIDO_ACTITUDINAL.toString());
        return contenidos;
    }

    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * Disciplinares de la sección matemáticas
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES
     * DEL ÁREA DE MATEMÁTICAS, en caso de que no existan contenidos, regresa
     * una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresMatematicas() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * Disciplinares de la sección ciencias experimentales
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES
     * DEL ÁREA DE CIENCIAS EXPERIMENTALES, en caso de que no existan
     * contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasExperimentales() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * Disciplinares de la sección ciencias sociales
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES
     * DEL ÁREA DE CIENCIAS SOCIALES, en caso de que no existan contenidos,
     * regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasSociales() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * Disciplinares de la sección comunicación
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES
     * DEL ÁREA DE COMUNICACIÓN, en caso de que no existan contenidos, regresa
     * una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresComunicaciones() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());
        return contenidos;
    }
    
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE APRENDIZAJE
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasAprende() {
        ArrayList<String> contenidos = new ArrayList<>();
        if (isAsignaturaValida(asignatura) == 1) {
            ContenidosGenerales misContenidosGenerales = new ContenidosGenerales();
            contenidos = misContenidosGenerales.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
        } else {
            contenidos.add("No hay contenidos que listar");
        }
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE AUTODETERMINA
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasAutodetermina() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE EXPRESA
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseExpresa() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE PARTICIPA
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseParticipa() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE PIENSA
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasePiensa() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la
     * rúbrica, en "Competencias a las que contribuye", enlista los contenidos
     * genericos DE TRABAJA
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseTrabaja() {
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
        return contenidos;
    }

    /**
     * En la sección "Evidencias de aprendizaje" de la rúbrica,enlista los
     * contenidos INSTRUMENTOS DE EVALUACIÓN
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarInstrumentosDeEvaluacion() {
        ArrayList<String> contenidos = listarContenidosGenericos("instrumentos");
        return contenidos;
    }   
    /**
     * En la sección "Evidencias de aprendizaje" de la rúbrica,enlista los
     * contenidos EVIDENCIAS DE APRENDIZAJE
     *
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en
     * caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarEvidenciasDeAprendizaje() {
        ArrayList<String> contenidos = listarContenidosGenericos("evidencias");
        return contenidos;
    }

    
    
    private int setContenidosParaDesarrollo(ArrayList<Integer> contenidosSeleccionados, String tipoContenido) {
        int resultado;
        contenidosEspecificos = new ContenidosEspecificos();
        if (contenidosSeleccionados.isEmpty()) {
            return resultado = 0;
        } else {
            resultado = contenidosEspecificos.setContenidosEspecificos(asignatura, contenidosSeleccionados, tipoContenido);
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Saberes Necesarios para el desarrollo" de la rúbrica,
     * captura todos los contenidos DECLARATIVOS
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setContenidosDeclarativos(ArrayList<Integer> contenidosSeleccionados) {
        int resultado = setContenidosParaDesarrollo(contenidosSeleccionados, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
        return resultado;
    }
    /**
     * En la sección "Saberes Necesarios para el desarrollo" de la rúbrica,
     * captura todos los contenidos PROCEDIMENTALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setContenidosProcedimentales(ArrayList<Integer> contenidosSeleccionados) {
        int resultado = setContenidosParaDesarrollo(contenidosSeleccionados, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());
        return resultado;
    }
    /**
     * En la sección "Saberes Necesarios para el desarrollo" de la rúbrica,
     * captura todos los contenidos ACTITUDINALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setContenidosActitudinales(ArrayList<Integer> contenidosSeleccionados) {
        int resultado = setContenidosParaDesarrollo(contenidosSeleccionados, enumContenidosEspecificos.CONTENIDO_ACTITUDINAL.toString());
        return resultado;
    }
    
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE MATEMÁTICAS
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresMatematicasInicio(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresMatematicasInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresMatematicasInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasInicio = new ArrayList<>();
                competenciasDisciplinaresMatematicasInicio.add(" ");
                resultado = -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE COMUNICACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresComunicacionInicio(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresComunicacionInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresComunicacionInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionInicio = new ArrayList<>();
                competenciasDisciplinaresComunicacionInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS SOCIALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasSocialesInicio(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasSocialesInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasSocialesInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesInicio = new ArrayList<>();
                competenciasDisciplinaresCienciasSocialesInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS EXPERIMENTALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasExperimentalesInicio(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasExperimentalesInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasExperimentalesInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesInicio = new ArrayList<>();
                competenciasDisciplinaresCienciasExperimentalesInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE MATEMÁTICAS
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresMatematicasDesarrollo(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresMatematicasDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresMatematicasDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasDesarrollo = new ArrayList<>();
                competenciasDisciplinaresMatematicasDesarrollo.add(" ");
                resultado = -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE COMUNICACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresComunicacionDesarrollo(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresComunicacionDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresComunicacionDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionDesarrollo = new ArrayList<>();
                competenciasDisciplinaresComunicacionDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS SOCIALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasSocialesDesarrollo(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasSocialesDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasSocialesDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesDesarrollo = new ArrayList<>();
                competenciasDisciplinaresCienciasSocialesDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS EXPERIMENTALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasExperimentalesDesarrollo(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasExperimentalesDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasExperimentalesDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesDesarrollo = new ArrayList<>();
                competenciasDisciplinaresCienciasExperimentalesDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE MATEMÁTICAS
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresMatematicasCierre(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresMatematicasCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresMatematicasCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasCierre = new ArrayList<>();
                competenciasDisciplinaresMatematicasCierre.add(" ");
                resultado = -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de Cierre, GUARDA LOS CONTENIDOS SELECCIONADOS DE COMUNICACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresComunicacionCierre(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresComunicacionCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresComunicacionCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionCierre = new ArrayList<>();
                competenciasDisciplinaresComunicacionCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS SOCIALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasSocialesCierre(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasSocialesCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasSocialesCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesCierre = new ArrayList<>();
                competenciasDisciplinaresCienciasSocialesCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS DISCIPLINARES,
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE CIENCIAS EXPERIMENTALES
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0 lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasDisciplinaresCienciasExperimentalesCierre(ArrayList<Integer> contenidosSeleccionados) {
        int resultado;
        competenciasDisciplinaresCienciasExperimentalesCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasDisciplinaresCienciasExperimentalesCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesCierre = new ArrayList<>();
                competenciasDisciplinaresCienciasExperimentalesCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }

    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE APRENDE DE FORMA AUTÓNOMA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAprendeInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAprendeInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAprendeInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeInicio = new ArrayList<>();
                competenciasGenericasAprendeInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE AUTODETERMINA Y CUIDAD DE SÍ
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAutodeterminaInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAutodeterminaInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAutodeterminaInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaInicio = new ArrayList<>();
                competenciasGenericasAutodeterminaInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE EXPRESA Y COMUNICA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasExpresaInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasExpresaInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasExpresaInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaInicio = new ArrayList<>();
                competenciasGenericasExpresaInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE PARTICIPA CON RESPONSABILIDAD
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasParticipaInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasParticipaInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasParticipaInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaInicio = new ArrayList<>();
                competenciasGenericasParticipaInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE PIENSA CRÍTICA Y REFLEXIVAMENTE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasPiensaInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasPiensaInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasPiensaInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaInicio = new ArrayList<>();
                competenciasGenericasPiensaInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE TRABAJA EN FORMA COLABORATIVA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasTrabajaInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasTrabajaInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasTrabajaInicio.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaInicio = new ArrayList<>();
                competenciasGenericasTrabajaInicio.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE APRENDE DE FORMA AUTÓNOMA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAprendeDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAprendeDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAprendeDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeDesarrollo = new ArrayList<>();
                competenciasGenericasAprendeDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE AUTODETERMINA Y CUIDAD DE SÍ
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAutodeterminaDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAutodeterminaDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAutodeterminaDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaDesarrollo = new ArrayList<>();
                competenciasGenericasAutodeterminaDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE EXPRESA Y COMUNICA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasExpresaDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasExpresaDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasExpresaDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaDesarrollo = new ArrayList<>();
                competenciasGenericasExpresaDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE PARTICIPA CON RESPONSABILIDAD
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasParticipaDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasParticipaDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasParticipaDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaDesarrollo = new ArrayList<>();
                competenciasGenericasParticipaDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE PIENSA CRÍTICA Y REFLEXIVAMENTE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasPiensaDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasPiensaDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasPiensaDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaDesarrollo = new ArrayList<>();
                competenciasGenericasPiensaDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE TRABAJA EN FORMA COLABORATIVA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasTrabajaDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasTrabajaDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasTrabajaDesarrollo.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaDesarrollo = new ArrayList<>();
                competenciasGenericasTrabajaDesarrollo.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE APRENDE DE FORMA AUTÓNOMA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAprendeCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAprendeCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAprendeCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeCierre = new ArrayList<>();
                competenciasGenericasAprendeCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE AUTODETERMINA Y CUIDAD DE SÍ
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasAutodeterminaCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasAutodeterminaCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasAutodeterminaCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaCierre = new ArrayList<>();
                competenciasGenericasAutodeterminaCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE SE EXPRESA Y COMUNICA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasExpresaCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasExpresaCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasExpresaCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaCierre = new ArrayList<>();
                competenciasGenericasExpresaCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE PARTICIPA CON RESPONSABILIDAD
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasParticipaCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasParticipaCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasParticipaCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaCierre = new ArrayList<>();
                competenciasGenericasParticipaCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE PIENSA CRÍTICA Y REFLEXIVAMENTE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasPiensaCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasPiensaCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasPiensaCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaCierre = new ArrayList<>();
                competenciasGenericasPiensaCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
    /**
     * En la sección "Actividades para el desarrollo...", dentro de las COMPETENCIAS GENERICAS;
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE TRABAJA EN FORMA COLABORATIVA
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setCompetenciasGenericasTrabajaCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        competenciasGenericasTrabajaCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            competenciasGenericasTrabajaCierre.add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaCierre = new ArrayList<>();
                competenciasGenericasTrabajaCierre.add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }
}
