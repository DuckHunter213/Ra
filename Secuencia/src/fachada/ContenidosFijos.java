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
    
    private ArrayList<String> instrumentosDeEvaluacionInicio;
    private ArrayList<String> instrumentosDeEvaluacionDesarrollo;
    private ArrayList<String> instrumentosDeEvaluacionCierre;
    private ArrayList<String> evidenciasDeAprendizajeInicio;
    private ArrayList<String> evidenciasDeAprendizajeDesarrollo;
    private ArrayList<String> evidenciasDeAprendizajeCierre;

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
        resultado = contenidosEspecificos.setContenidosEspecificos(asignatura, contenidosSeleccionados, tipoContenido);
        if (resultado > 1) {
            resultado = 1;
        }
        if (contenidosSeleccionados.isEmpty()) {
            resultado = 0;
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
            getCompetenciasDisciplinaresMatematicasInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasInicio = new ArrayList<>();
                getCompetenciasDisciplinaresMatematicasInicio().add(" ");
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
            getCompetenciasDisciplinaresComunicacionInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionInicio = new ArrayList<>();
                getCompetenciasDisciplinaresComunicacionInicio().add(" ");
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
            getCompetenciasDisciplinaresCienciasSocialesInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesInicio = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasSocialesInicio().add(" ");
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
            getCompetenciasDisciplinaresCienciasExperimentalesInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesInicio = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasExperimentalesInicio().add(" ");
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
            getCompetenciasDisciplinaresMatematicasDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasDesarrollo = new ArrayList<>();
                getCompetenciasDisciplinaresMatematicasDesarrollo().add(" ");
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
            getCompetenciasDisciplinaresComunicacionDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionDesarrollo = new ArrayList<>();
                getCompetenciasDisciplinaresComunicacionDesarrollo().add(" ");
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
            getCompetenciasDisciplinaresCienciasSocialesDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesDesarrollo = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasSocialesDesarrollo().add(" ");
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
            getCompetenciasDisciplinaresCienciasExperimentalesDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesDesarrollo = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasExperimentalesDesarrollo().add(" ");
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
            getCompetenciasDisciplinaresMatematicasCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresMatematicasCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString());
            }catch(IndexOutOfBoundsException ex){
                competenciasDisciplinaresMatematicasCierre = new ArrayList<>();
                getCompetenciasDisciplinaresMatematicasCierre().add(" ");
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
            getCompetenciasDisciplinaresComunicacionCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                resultado = 1;
                competenciasDisciplinaresComunicacionCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString());                
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresComunicacionCierre = new ArrayList<>();
                getCompetenciasDisciplinaresComunicacionCierre().add(" ");
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
            getCompetenciasDisciplinaresCienciasSocialesCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasSocialesCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasSocialesCierre = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasSocialesCierre().add(" ");
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
            getCompetenciasDisciplinaresCienciasExperimentalesCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasDisciplinaresCienciasExperimentalesCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasDisciplinaresCienciasExperimentalesCierre = new ArrayList<>();
                getCompetenciasDisciplinaresCienciasExperimentalesCierre().add(" ");
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
            getCompetenciasGenericasAprendeInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeInicio = new ArrayList<>();
                getCompetenciasGenericasAprendeInicio().add(" ");
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
            getCompetenciasGenericasAutodeterminaInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaInicio = new ArrayList<>();
                getCompetenciasGenericasAutodeterminaInicio().add(" ");
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
            getCompetenciasGenericasExpresaInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaInicio = new ArrayList<>();
                getCompetenciasGenericasExpresaInicio().add(" ");
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
            getCompetenciasGenericasParticipaInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaInicio = new ArrayList<>();
                getCompetenciasGenericasParticipaInicio().add(" ");
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
            getCompetenciasGenericasPiensaInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaInicio = new ArrayList<>();
                getCompetenciasGenericasPiensaInicio().add(" ");
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
            getCompetenciasGenericasTrabajaInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaInicio = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaInicio = new ArrayList<>();
                getCompetenciasGenericasTrabajaInicio().add(" ");
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
            getCompetenciasGenericasAprendeDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeDesarrollo = new ArrayList<>();
                getCompetenciasGenericasAprendeDesarrollo().add(" ");
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
            getCompetenciasGenericasAutodeterminaDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaDesarrollo = new ArrayList<>();
                getCompetenciasGenericasAutodeterminaDesarrollo().add(" ");
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
            getCompetenciasGenericasExpresaDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaDesarrollo = new ArrayList<>();
                getCompetenciasGenericasExpresaDesarrollo().add(" ");
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
            getCompetenciasGenericasParticipaDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaDesarrollo = new ArrayList<>();
                getCompetenciasGenericasParticipaDesarrollo().add(" ");
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
            getCompetenciasGenericasPiensaDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaDesarrollo = new ArrayList<>();
                getCompetenciasGenericasPiensaDesarrollo().add(" ");
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
            getCompetenciasGenericasTrabajaDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaDesarrollo = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaDesarrollo = new ArrayList<>();
                getCompetenciasGenericasTrabajaDesarrollo().add(" ");
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
            getCompetenciasGenericasAprendeCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAprendeCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAprendeCierre = new ArrayList<>();
                getCompetenciasGenericasAprendeCierre().add(" ");
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
            getCompetenciasGenericasAutodeterminaCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasAutodeterminaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasAutodeterminaCierre = new ArrayList<>();
                getCompetenciasGenericasAutodeterminaCierre().add(" ");
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
            getCompetenciasGenericasExpresaCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasExpresaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasExpresaCierre = new ArrayList<>();
                getCompetenciasGenericasExpresaCierre().add(" ");
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
            getCompetenciasGenericasParticipaCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasParticipaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasParticipaCierre = new ArrayList<>();
                getCompetenciasGenericasParticipaCierre().add(" ");
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
            getCompetenciasGenericasPiensaCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasPiensaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasPiensaCierre = new ArrayList<>();
                getCompetenciasGenericasPiensaCierre().add(" ");
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
            getCompetenciasGenericasTrabajaCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                competenciasGenericasTrabajaCierre = contenidosGenerales.getCompetenciasElegidas(contenidosSeleccionados, enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                competenciasGenericasTrabajaCierre = new ArrayList<>();
                getCompetenciasGenericasTrabajaCierre().add(" ");
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
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE INSTRUMENTOS DE EVALUACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setInstrumentosDeEvaluacionInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        instrumentosDeEvaluacionInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getInstrumentosDeEvaluacionInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                instrumentosDeEvaluacionInicio = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_INSTRUMENTOS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                instrumentosDeEvaluacionInicio = new ArrayList<>();
                getInstrumentosDeEvaluacionInicio().add(" ");
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
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE INSTRUMENTOS DE EVALUACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setInstrumentosDeEvaluacionDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        instrumentosDeEvaluacionDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getInstrumentosDeEvaluacionDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                instrumentosDeEvaluacionDesarrollo = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_INSTRUMENTOS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                instrumentosDeEvaluacionDesarrollo = new ArrayList<>();
                getInstrumentosDeEvaluacionDesarrollo().add(" ");
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
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE INSTRUMENTOS DE EVALUACIÓN
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setInstrumentosDeEvaluacionCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        instrumentosDeEvaluacionCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getInstrumentosDeEvaluacionCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                instrumentosDeEvaluacionCierre = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_INSTRUMENTOS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                instrumentosDeEvaluacionCierre = new ArrayList<>();
                getInstrumentosDeEvaluacionCierre().add(" ");
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
     * para la sección de INICIO, GUARDA LOS CONTENIDOS SELECCIONADOS DE EVIDENCIAS DE APRENDIZAJE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setEvidenciasDeAprendizajeInicio(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        evidenciasDeAprendizajeInicio = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getEvidenciasDeAprendizajeInicio().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                evidenciasDeAprendizajeInicio = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_EVIDENCIAS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                evidenciasDeAprendizajeInicio = new ArrayList<>();
                getEvidenciasDeAprendizajeInicio().add(" ");
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
     * para la sección de DESARROLLO, GUARDA LOS CONTENIDOS SELECCIONADOS DE EVIDENCIAS DE APRENDIZAJE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setEvidenciasDeAprendizajeCierre(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        evidenciasDeAprendizajeDesarrollo = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getEvidenciasDeAprendizajeDesarrollo().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                evidenciasDeAprendizajeDesarrollo = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_EVIDENCIAS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                evidenciasDeAprendizajeDesarrollo = new ArrayList<>();
                getEvidenciasDeAprendizajeDesarrollo().add(" ");
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
     * para la sección de CIERRE, GUARDA LOS CONTENIDOS SELECCIONADOS DE EVIDENCIAS DE APRENDIZAJE
     *
     * @param contenidosSeleccionados un ArrayList< Integer > empezando desde 0
     * (cero) numerando SOLAMENTE LO QUE SE QUIERE MANTENER
     * @return un número, si es 0, la lista no conserva ningún valor, si es 1,
     * conserva al menos 1 resultado, y si es -1, los límites del contenido
     * elegido son incorrectos
     */
    public int setEvidenciasDeAprendizajeDesarrollo(ArrayList<Integer> contenidosSeleccionados){
        int resultado;
        evidenciasDeAprendizajeCierre = new ArrayList<>();
        contenidosGenerales = new ContenidosGenerales();
        if (contenidosSeleccionados.isEmpty()) {
            getEvidenciasDeAprendizajeCierre().add(" ");
            resultado = -1;
            return resultado;
        } else {
            try{
                evidenciasDeAprendizajeCierre = contenidosGenerales.getOtrosContenidos(contenidosSeleccionados, enumContenidosGenerales.TIPO_CONT_GENERICO_EVIDENCIAS.toString());
                resultado = 1;
            } catch (IndexOutOfBoundsException ex){
                evidenciasDeAprendizajeCierre = new ArrayList<>();
                getEvidenciasDeAprendizajeCierre().add(" ");
                return -1;
            }
        }
        if (resultado > 1) {
            resultado = 1;
        }
        return resultado;
    }

    /**
     * Regresa los contenidos DECLARATIVOS GUARDADOS
     * @return 
     */
    public ArrayList<String> getContenidosDeclarativos(){
        return contenidosEspecificos.getContenidosDeclarativosSeleccionados();
    }
    /**
     * Regresa los contenidos PROCEDIMENTALES GUARDADOS
     * @return 
     */
    public ArrayList<String> getContenidosProcedimentales(){
        return contenidosEspecificos.getContenidosProcedimentalesSeleccionados();
    }
    /**
     * Regresa los contenidos ACTITUDINALES GUARDADOS
     * @return 
     */
    public ArrayList<String> getContenidosActitudinales(){
        return contenidosEspecificos.getContenidosActitudinalesSeleccionados();
    }
    
    /**
     * @return the competenciasDisciplinaresMatematicasInicio
     */
    public ArrayList<String> getCompetenciasDisciplinaresMatematicasInicio() {
        return competenciasDisciplinaresMatematicasInicio;
    }
    /**
     * @return the competenciasDisciplinaresComunicacionInicio
     */
    public ArrayList<String> getCompetenciasDisciplinaresComunicacionInicio() {
        return competenciasDisciplinaresComunicacionInicio;
    }
    /**
     * @return the competenciasDisciplinaresCienciasSocialesInicio
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasSocialesInicio() {
        return competenciasDisciplinaresCienciasSocialesInicio;
    }
    /**
     * @return the competenciasDisciplinaresCienciasExperimentalesInicio
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasExperimentalesInicio() {
        return competenciasDisciplinaresCienciasExperimentalesInicio;
    }
    /**
     * @return the competenciasDisciplinaresMatematicasDesarrollo
     */
    public ArrayList<String> getCompetenciasDisciplinaresMatematicasDesarrollo() {
        return competenciasDisciplinaresMatematicasDesarrollo;
    }
    /**
     * @return the competenciasDisciplinaresComunicacionDesarrollo
     */
    public ArrayList<String> getCompetenciasDisciplinaresComunicacionDesarrollo() {
        return competenciasDisciplinaresComunicacionDesarrollo;
    }
    /**
     * @return the competenciasDisciplinaresCienciasSocialesDesarrollo
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasSocialesDesarrollo() {
        return competenciasDisciplinaresCienciasSocialesDesarrollo;
    }
    /**
     * @return the competenciasDisciplinaresCienciasExperimentalesDesarrollo
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasExperimentalesDesarrollo() {
        return competenciasDisciplinaresCienciasExperimentalesDesarrollo;
    }
    /**
     * @return the competenciasDisciplinaresMatematicasCierre
     */
    public ArrayList<String> getCompetenciasDisciplinaresMatematicasCierre() {
        return competenciasDisciplinaresMatematicasCierre;
    }
    /**
     * @return the competenciasDisciplinaresComunicacionCierre
     */
    public ArrayList<String> getCompetenciasDisciplinaresComunicacionCierre() {
        return competenciasDisciplinaresComunicacionCierre;
    }
    /**
     * @return the competenciasDisciplinaresCienciasSocialesCierre
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasSocialesCierre() {
        return competenciasDisciplinaresCienciasSocialesCierre;
    }
    /**
     * @return the competenciasDisciplinaresCienciasExperimentalesCierre
     */
    public ArrayList<String> getCompetenciasDisciplinaresCienciasExperimentalesCierre() {
        return competenciasDisciplinaresCienciasExperimentalesCierre;
    }
    
    /**
     * @return the competenciasGenericasAprendeInicio
     */
    public ArrayList<String> getCompetenciasGenericasAprendeInicio() {
        return competenciasGenericasAprendeInicio;
    }
    /**
     * @return the competenciasGenericasAutodeterminaInicio
     */
    public ArrayList<String> getCompetenciasGenericasAutodeterminaInicio() {
        return competenciasGenericasAutodeterminaInicio;
    }
    /**
     * @return the competenciasGenericasExpresaInicio
     */
    public ArrayList<String> getCompetenciasGenericasExpresaInicio() {
        return competenciasGenericasExpresaInicio;
    }
    /**
     * @return the competenciasGenericasParticipaInicio
     */
    public ArrayList<String> getCompetenciasGenericasParticipaInicio() {
        return competenciasGenericasParticipaInicio;
    }
    /**
     * @return the competenciasGenericasPiensaInicio
     */
    public ArrayList<String> getCompetenciasGenericasPiensaInicio() {
        return competenciasGenericasPiensaInicio;
    }
    /**
     * @return the competenciasGenericasTrabajaInicio
     */
    public ArrayList<String> getCompetenciasGenericasTrabajaInicio() {
        return competenciasGenericasTrabajaInicio;
    }
    /**
     * @return the competenciasGenericasAprendeDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasAprendeDesarrollo() {
        return competenciasGenericasAprendeDesarrollo;
    }
    /**
     * @return the competenciasGenericasAutodeterminaDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasAutodeterminaDesarrollo() {
        return competenciasGenericasAutodeterminaDesarrollo;
    }
    /**
     * @return the competenciasGenericasExpresaDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasExpresaDesarrollo() {
        return competenciasGenericasExpresaDesarrollo;
    }
    /**
     * @return the competenciasGenericasParticipaDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasParticipaDesarrollo() {
        return competenciasGenericasParticipaDesarrollo;
    }
    /**
     * @return the competenciasGenericasPiensaDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasPiensaDesarrollo() {
        return competenciasGenericasPiensaDesarrollo;
    }
    /**
     * @return the competenciasGenericasTrabajaDesarrollo
     */
    public ArrayList<String> getCompetenciasGenericasTrabajaDesarrollo() {
        return competenciasGenericasTrabajaDesarrollo;
    }
    /**
     * @return the competenciasGenericasAprendeCierre
     */
    public ArrayList<String> getCompetenciasGenericasAprendeCierre() {
        return competenciasGenericasAprendeCierre;
    }
    /**
     * @return the competenciasGenericasAutodeterminaCierre
     */
    public ArrayList<String> getCompetenciasGenericasAutodeterminaCierre() {
        return competenciasGenericasAutodeterminaCierre;
    }
    /**
     * @return the competenciasGenericasExpresaCierre
     */
    public ArrayList<String> getCompetenciasGenericasExpresaCierre() {
        return competenciasGenericasExpresaCierre;
    }
    /**
     * @return the competenciasGenericasParticipaCierre
     */
    public ArrayList<String> getCompetenciasGenericasParticipaCierre() {
        return competenciasGenericasParticipaCierre;
    }
    /**
     * @return the competenciasGenericasPiensaCierre
     */
    public ArrayList<String> getCompetenciasGenericasPiensaCierre() {
        return competenciasGenericasPiensaCierre;
    }
    /**
     * @return the competenciasGenericasTrabajaCierre
     */
    public ArrayList<String> getCompetenciasGenericasTrabajaCierre() {
        return competenciasGenericasTrabajaCierre;
    }
    
    /**
     * @return the instrumentosDeEvaluacionInicio
     */
    public ArrayList<String> getInstrumentosDeEvaluacionInicio() {
        return instrumentosDeEvaluacionInicio;
    }
    /**
     * @return the instrumentosDeEvaluacionDesarrollo
     */
    public ArrayList<String> getInstrumentosDeEvaluacionDesarrollo() {
        return instrumentosDeEvaluacionDesarrollo;
    }
    /**
     * @return the instrumentosDeEvaluacionCierre
     */
    public ArrayList<String> getInstrumentosDeEvaluacionCierre() {
        return instrumentosDeEvaluacionCierre;
    }

    /**
     * @return the evidenciasDeAprendizajeInicio
     */
    public ArrayList<String> getEvidenciasDeAprendizajeInicio() {
        return evidenciasDeAprendizajeInicio;
    }
    /**
     * @return the evidenciasDeAprendizajeDesarrollo
     */
    public ArrayList<String> getEvidenciasDeAprendizajeDesarrollo() {
        return evidenciasDeAprendizajeDesarrollo;
    }
    /**
     * @return the evidenciasDeAprendizajeCierre
     */
    public ArrayList<String> getEvidenciasDeAprendizajeCierre() {
        return evidenciasDeAprendizajeCierre;
    }
}
