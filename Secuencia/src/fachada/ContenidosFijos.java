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
public class ContenidosFijos{
    
    public final int ASIGNATURA_VALIDA = 1;
    public final int ASIGNATURA_INVALIDA = 0;

    private Asignatura asignatura;
    private ContenidosEspecificos contenidosEspecificos;
    private ContenidosGenerales contenidosGeneralesCierre;
    private ContenidosGenerales contenidosGeneralesDesarrollo;
    private ContenidosGenerales contenidosGeneralesInicio;
    public ContenidosGenerales m_ContenidosGenerales;
    public ContenidosEspecificos m_ContenidosEspecificos;
    
    private ArrayList<String> listarContenidosGenericos(String tipoListado){
        ArrayList<String> contenidos = new ArrayList<>();
        contenidosEspecificos = new ContenidosEspecificos();
        ContenidosGenerales misContenidosGenerales;
        if (isAsignaturaValida(asignatura) == 1){
            switch(tipoListado){
                case "declarativos":   
                    contenidos = contenidosEspecificos.listarContenidosEspecificos(this.asignatura, enumContenidosEspecificos.CONTENIDO_DECLARATIVO.toString());
                    break;
                case "procedimentales":
                    contenidos = contenidosEspecificos.listarContenidosEspecificos(asignatura, enumContenidosEspecificos.CONTENIDO_PROCEDIMENTAL.toString());                    
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
        }else{
            contenidos.add("No hay contenidos que listar");
        }
        return contenidos;        
    }
    private ArrayList<String> listarCompetencias(String contenidoDisciplinar, String tipoContenido){
        ArrayList<String> contenidos = new ArrayList<>();
        if (isAsignaturaValida(asignatura) == 1){
            ContenidosGenerales misContenidosGenerales = new ContenidosGenerales();
            contenidos = misContenidosGenerales.listarCompetencias(contenidoDisciplinar, tipoContenido);
        }else{
            contenidos.add(" ");
        }
        return contenidos;      
    }
    private int isAsignaturaValida(Asignatura asignatura){
        if (asignatura.getAsignatura().isEmpty() || asignatura.getAsignatura().equals("")){
            return ASIGNATURA_INVALIDA;
        } else if (asignatura.getBloque() <= 0){
            return ASIGNATURA_INVALIDA;
        } else if (asignatura.getSemestre() <= 0 ){
            return ASIGNATURA_INVALIDA;
        }
            return ASIGNATURA_VALIDA;
    }
    public int setAsignatura(Asignatura asignatura){
        if (isAsignaturaValida(asignatura) == ASIGNATURA_VALIDA){
            this.asignatura = asignatura;
            return ASIGNATURA_VALIDA;
        }
        else
            this.asignatura = new Asignatura();
            return ASIGNATURA_INVALIDA;
    }
    public Asignatura getAsignatura(){
        return this.asignatura;
    }

    /**
     * En la sección "Saberes necesarios para el desarrollo de competencias" de la rúbrica, enlista los contenidos que irán dentro del espacio "Contenidos Declarativos"
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de contenidos declarativos, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarContenidosDeclarativos(){
        ArrayList<String> contenidos = listarContenidosGenericos("declarativos");
        return contenidos;
    }
    /**
     * En la sección "Saberes necesarios para el desarrollo de competencias" de la rúbrica, enlista los contenidos  que irán dentro del espacio "Contenidos Procedimentales"
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de contenidos procedimentales, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarContenidosProcedimentales(){
        ArrayList<String> contenidos = listarContenidosGenericos("procedimentales");
        return contenidos;
    }
    
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos Disciplinares de la sección matemáticas
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES DEL ÁREA DE MATEMÁTICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresMatematicas(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_MATEMATICAS.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos Disciplinares de la sección ciencias experimentales
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES DEL ÁREA DE CIENCIAS EXPERIMENTALES, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasExperimentales(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_EXPERIMENTALES.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos Disciplinares de la sección ciencias sociales
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES DEL ÁREA DE CIENCIAS SOCIALES, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresCienciasSociales(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_CIENCIAS_SOCIALES.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos Disciplinares de la sección comunicación
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS DISCIPLINARES DEL ÁREA DE COMUNICACIÓN, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasDisciplinaresComunicaciones(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_DISCIPLINAR.toString(), enumContenidosGenerales.TIPO_CONT_DISCIPLINAR_COMUNICACION.toString() );
        return contenidos;
    }
    
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE APRENDIZAJE
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasAprende(){
        ArrayList<String> contenidos = new ArrayList<>();
        if (isAsignaturaValida(asignatura) == 1){
            ContenidosGenerales misContenidosGenerales = new ContenidosGenerales();
            contenidos = misContenidosGenerales.listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_APRENDE.toString());
        }else{
            contenidos.add("No hay contenidos que listar");
        }
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE AUTODETERMINA
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasAutodetermina(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_AUTODETERMINA.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE EXPRESA
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseExpresa(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_EXPRESA.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE PARTICIPA
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseParticipa(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PARTICIPA.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE PIENSA
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericasePiensa(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_PIENSA.toString() );
        return contenidos;
    }
    /**
     * En la sección "Actividades para el desarrollo de competencias" de la rúbrica, en "Competencias a las que contribuye", enlista los contenidos genericos  DE TRABAJA
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarCompetenciasGenericaseTrabaja(){
        ArrayList<String> contenidos = listarCompetencias(enumContenidosGenerales.CONTENIDO_GENERICO.toString(), enumContenidosGenerales.TIPO_CONT_GENERICO_TRABAJA.toString() );
        return contenidos;
    }
    
    
    /**
     * En la sección "Evidencias de aprendizaje" de la rúbrica,enlista los contenidos INSTRUMENTOS DE EVALUACIÓN
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarInstrumentosDeEvaluacion(){
        ArrayList<String> contenidos = listarContenidosGenericos("instrumentos");
        return contenidos;
    }
    /**
     * En la sección "Evidencias de aprendizaje" de la rúbrica,enlista los contenidos EVIDENCIAS DE APRENDIZAJE
     * @param asignatura Recibe una asignatura válida
     * @return Regresa un ArrayList con uns lista de COMPETENCIAS GENERICAS, en caso de que no existan contenidos, regresa una lista de un solo elemento
     */
    public ArrayList<String> listarEvidenciasDeAprendizaje(){
        ArrayList<String> contenidos = listarContenidosGenericos("evidencias");
        return contenidos;
    }
    
    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasCierre(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }
    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasDesarrollo(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }
    /**
     *
     * @param disciplinaresElegidas
     * @param genericasElegidas
     * @return
     */
    public int setCompetenciasInicio(ArrayList<String> disciplinaresElegidas, ArrayList<String> genericasElegidas){
        return 0;
    }
    /**
     *
     * @param actitudinalesElegidos
     * @param declarativosElegidos
     * @param procedimentalesElegidos
     * @return
     */
    public int setContenidosEspecificos(ArrayList<String> actitudinalesElegidos, ArrayList<String> declarativosElegidos, ArrayList<String> procedimentalesElegidos){
        return 0;
    }
    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasCierre(ArrayList<String> evidenciasElegidas){
        return 0;
    }
    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasDesarrollo(ArrayList<String> evidenciasElegidas){
        return 0;
    }

    /**
     *
     * @param evidenciasElegidas
     * @return
     */
    public int setEvidenciasInicio(ArrayList<String> evidenciasElegidas){
        return 0;
    }
    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosCierre(ArrayList<String> instrumentosElegidos){
        return 0;
    }
    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosDesarrollo(ArrayList<String> instrumentosElegidos){
        return 0;
    }
    /**
     *
     * @param instrumentosElegidos
     * @return
     */
    public int setInstrumentosInicio(ArrayList<String> instrumentosElegidos){
        return 0;
    }

}
