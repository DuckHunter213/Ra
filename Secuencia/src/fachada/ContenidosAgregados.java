package Fachada;

/**
 * @author Mares Solano Francisco Gerardo
 * @version 1.0
 * @created 08-sep.-2016 11:45:25 p. m.
 */
public class ContenidosAgregados {

    private String contenidosGeneralesAprendizajeInicio = " ";
    private String contenidosGeneralesEnsenianzaInicio = " ";
    private String contenidosGeneralesAprendizajeDesarrollo = " ";
    private String contenidosGeneralesEnsenianzaDesarrollo = " ";
    private String contenidosGeneralesAprendizajeCierre = " ";
    private String contenidosGeneralesEnsenianzaCierre = " ";
    private String fechaInicio = " ";
    private int numeroSecuencia = 0;
    private int numeroSesiones = 0;
    private String periodoEscolar = " ";
    private String asignaturasRelacionadas = " ";
    private String fuentesInformacion = " ";
    private String observaciones = " ";
    private String propositoSecuencia = " ";
    private String recursosMateriales = " ";

    
    private int valirCadena(String texto){
        try{
            if (texto.isEmpty())
                return -1;
            if (texto.length() > 450)
                return 0;
            return 1;            
        }catch(NullPointerException ex){
            return -1;
        }
    }
    private int valirEnteros(int numero){
        try{
            if (numero < 0)
                return 0;
            return 1;          
        }catch(NullPointerException ex){
            return -1;
        }
    }

    /**
     * @param contenidosGeneralesAprendizajeInicio the contenidosGeneralesAprendizajeInicio to set
     * @return 
     */
    public int setContenidosGeneralesAprendizajeInicio(String contenidosGeneralesAprendizajeInicio) {
        int resultado = valirCadena(contenidosGeneralesAprendizajeInicio);
        if (valirCadena(contenidosGeneralesAprendizajeInicio) == 1)
            this.contenidosGeneralesAprendizajeInicio = contenidosGeneralesAprendizajeInicio;
        else
            this.contenidosGeneralesAprendizajeInicio = " ";
        return resultado;
    }

    /**
     * @param contenidosGeneralesEnsenianzaInicio the contenidosGeneralesEnsenianzaInicio to set
     * @return 
     */
    public int setContenidosGeneralesEnsenianzaInicio(String contenidosGeneralesEnsenianzaInicio) {
        int resultado = valirCadena(getContenidosGeneralesAprendizajeInicio());
        if (valirCadena(getContenidosGeneralesAprendizajeInicio()) == 1)
            this.contenidosGeneralesEnsenianzaInicio = contenidosGeneralesEnsenianzaInicio;
        else
            this.contenidosGeneralesAprendizajeInicio = " ";
        return resultado;
    }

    /**
     * @param contenidosGeneralesAprendizajeDesarrollo the contenidosGeneralesAprendizajeDesarrollo to set
     * @return 
     */
    public int setContenidosGeneralesAprendizajeDesarrollo(String contenidosGeneralesAprendizajeDesarrollo) {
        int resultado = valirCadena(contenidosGeneralesAprendizajeDesarrollo);
        if (valirCadena(contenidosGeneralesAprendizajeDesarrollo) == 1)
            this.contenidosGeneralesAprendizajeDesarrollo = contenidosGeneralesAprendizajeDesarrollo;
        else
            this.contenidosGeneralesAprendizajeDesarrollo = " ";
        return resultado;
    }

    /**
     * @param contenidosGeneralesEnsenianzaDesarrollo the contenidosGeneralesEnsenianzaDesarrollo to set
     * @return 
     */
    public int setContenidosGeneralesEnsenianzaDesarrollo(String contenidosGeneralesEnsenianzaDesarrollo) {
        int resultado = valirCadena(contenidosGeneralesEnsenianzaDesarrollo);
        if (valirCadena(contenidosGeneralesEnsenianzaDesarrollo) == 1)
            this.contenidosGeneralesEnsenianzaDesarrollo = contenidosGeneralesEnsenianzaDesarrollo;
        else
            this.contenidosGeneralesEnsenianzaDesarrollo = " ";
        return resultado;
    }

    /**
     * @param contenidosGeneralesAprendizajeCierre the contenidosGeneralesAprendizajeCierre to set
     * @return 
     */
    public int setContenidosGeneralesAprendizajeCierre(String contenidosGeneralesAprendizajeCierre) {
        int resultado = valirCadena(contenidosGeneralesAprendizajeCierre);
        if (valirCadena(contenidosGeneralesAprendizajeCierre) == 1)
            this.contenidosGeneralesAprendizajeCierre = contenidosGeneralesAprendizajeCierre;
        else
            this.contenidosGeneralesAprendizajeCierre = " ";
        return resultado;
    }

    /**
     * @param contenidosGeneralesEnsenianzaCierre the contenidosGeneralesEnsenianzaCierre to set
     * @return 
     */
    public int setContenidosGeneralesEnsenianzaCierre(String contenidosGeneralesEnsenianzaCierre) {
        int resultado = valirCadena(contenidosGeneralesEnsenianzaCierre);
        if (valirCadena(contenidosGeneralesEnsenianzaCierre) == 1)
            this.contenidosGeneralesEnsenianzaCierre = contenidosGeneralesEnsenianzaCierre;
        else
            this.contenidosGeneralesEnsenianzaCierre = " ";
        return resultado;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     * @return 
     */
    public int setFechaInicio(String fechaInicio) {
        int resultado = valirCadena(fechaInicio);
        if (valirCadena(fechaInicio) == 1)
            this.fechaInicio = fechaInicio;
        else
            this.fechaInicio = " ";
        return resultado;
    }

    /**
     * @param numeroSecuencia the numeroSecuencia to set
     * @return 
     */
    public int setNumeroSecuencia(int numeroSecuencia) {
        int resultado = valirEnteros(numeroSecuencia);
        if (valirEnteros(numeroSecuencia) == 1)
            this.numeroSecuencia = numeroSecuencia;
        else
            this.numeroSecuencia = 1;
        return resultado;
    }

    /**
     * @param numeroSesiones the numeroSesiones to set
     * @return 
     */
    public int setNumeroSesiones(int numeroSesiones) {
        int resultado = valirEnteros(numeroSesiones);
        if (valirEnteros(numeroSesiones) == 1)
            this.numeroSesiones = numeroSesiones;
        else
            this.numeroSesiones = 1;
        return resultado;
    }

    /**
     * @param periodoEscolar the periodoEscolar to set
     * @return 
     */
    public int setPeriodoEscolar(String periodoEscolar) {
        int resultado = valirCadena(periodoEscolar);
        if (valirCadena(periodoEscolar) == 1)
            this.periodoEscolar = periodoEscolar;
        else
            this.periodoEscolar = " ";
        return resultado;
    }

    /**
     * @param asignaturasRelacionadas the asignaturasRelacionadas to set
     * @return 
     */
    public int setAsignaturasRelacionadas(String asignaturasRelacionadas) {
        int resultado = valirCadena(asignaturasRelacionadas);
        if (valirCadena(asignaturasRelacionadas) == 1)
            this.asignaturasRelacionadas = asignaturasRelacionadas;
        else
            this.asignaturasRelacionadas = " ";
        return resultado;
    }

    /**
     * @param fuentesInformacion the fuentesInformacion to set
     * @return 
     */
    public int setFuentesInformacion(String fuentesInformacion) {
        int resultado = valirCadena(fuentesInformacion);
        if (valirCadena(fuentesInformacion) == 1)
            this.fuentesInformacion = fuentesInformacion;
        else
            this.fuentesInformacion = " ";
        return resultado;
    }

    /**
     * @param observaciones the observaciones to set
     * @return 
     */
    public int setObservaciones(String observaciones) {
        int resultado = valirCadena(observaciones);
        if (valirCadena(observaciones) == 1)
            this.observaciones = observaciones;
        else
            this.observaciones = " ";
        return resultado;
    }

    /**
     * @param propositoSecuencia the propositoSecuencia to set
     * @return 
     */
    public int setPropositoSecuencia(String propositoSecuencia) {
        int resultado = valirCadena(propositoSecuencia);
        if (valirCadena(propositoSecuencia) == 1)
            this.propositoSecuencia = propositoSecuencia;
        else
            this.propositoSecuencia = " ";
        return resultado;
    }

    /**
     * @param recursosMateriales the recursosMateriales to set
     * @return 
     */
    public int setRecursosMateriales(String recursosMateriales) {
        int resultado = valirCadena(recursosMateriales);
        if (valirCadena(recursosMateriales) == 1)
            this.recursosMateriales = recursosMateriales;
        else
            this.recursosMateriales = " ";
        return resultado;
    }

    /**
     * @return the contenidosGeneralesAprendizajeInicio
     */
    public String getContenidosGeneralesAprendizajeInicio() {
        return contenidosGeneralesAprendizajeInicio;
    }

    /**
     * @return the contenidosGeneralesEnsenianzaInicio
     */
    public String getContenidosGeneralesEnsenianzaInicio() {
        return contenidosGeneralesEnsenianzaInicio;
    }

    /**
     * @return the contenidosGeneralesAprendizajeDesarrollo
     */
    public String getContenidosGeneralesAprendizajeDesarrollo() {
        return contenidosGeneralesAprendizajeDesarrollo;
    }

    /**
     * @return the contenidosGeneralesEnsenianzaDesarrollo
     */
    public String getContenidosGeneralesEnsenianzaDesarrollo() {
        return contenidosGeneralesEnsenianzaDesarrollo;
    }

    /**
     * @return the contenidosGeneralesAprendizajeCierre
     */
    public String getContenidosGeneralesAprendizajeCierre() {
        return contenidosGeneralesAprendizajeCierre;
    }

    /**
     * @return the contenidosGeneralesEnsenianzaCierre
     */
    public String getContenidosGeneralesEnsenianzaCierre() {
        return contenidosGeneralesEnsenianzaCierre;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return the numeroSecuencia
     */
    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }

    /**
     * @return the numeroSesiones
     */
    public int getNumeroSesiones() {
        return numeroSesiones;
    }

    /**
     * @return the periodoEscolar
     */
    public String getPeriodoEscolar() {
        return periodoEscolar;
    }

    /**
     * @return the asignaturasRelacionadas
     */
    public String getAsignaturasRelacionadas() {
        return asignaturasRelacionadas;
    }

    /**
     * @return the fuentesInformacion
     */
    public String getFuentesInformacion() {
        return fuentesInformacion;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @return the propositoSecuencia
     */
    public String getPropositoSecuencia() {
        return propositoSecuencia;
    }

    /**
     * @return the recursosMateriales
     */
    public String getRecursosMateriales() {
        return recursosMateriales;
    }

}
