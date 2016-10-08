package Interfaz;

import Fachada.*;
import com.itextpdf.text.DocumentException;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Secuencia.Lector;

/**
 *
 * @author DARKENSES
 */
public class Rubrica extends javax.swing.JFrame{
    private static ContenidosFijos contenidosFijos;
    private static ContenidosAgregados contenidosAgregados;
    private static Asignatura asignatura;

    private ArrayList<Integer> pasarArray(int[] array){
        ArrayList<Integer> list = new ArrayList<>(array.length);
        for (int val : array){
            list.add(val);
        }
        return list;
    }

    private int[] setearValores(){
        int[] dato = new int[100];
        dato[0] = contenidosAgregados.setPeriodoEscolar(periodoEscolarTextField.getText());
        try{
            dato[2] = contenidosAgregados.setNumeroSesiones(Integer.parseInt(numeroSesionesTextField.getText()));
        }catch (NumberFormatException e){
            dato[2] = contenidosAgregados.setNumeroSesiones(0);
        }
        try{
            dato[1] = contenidosAgregados.setNumeroSecuencia(Integer.parseInt(numeroSecuenciaTextField.getText()));
        }catch (NumberFormatException e){
            dato[1] = contenidosAgregados.setNumeroSecuencia(0);
        }
        dato[3] = contenidosAgregados.setFechaInicio(fechaInicioTextField.getText());
        dato[4] = contenidosAgregados.setPropositoSecuencia(propositoSecuenciaTextArea.getText());
        dato[5] = contenidosAgregados.setAsignaturasRelacionadas(asignaturasRelacionadasTextArea.getText());
        //Segunda Ventana
        dato[6] = contenidosFijos.setContenidosDeclarativos(pasarArray(contenidoDeclarativoList.getSelectedIndices()));
        dato[7] = contenidosFijos.setContenidosProcedimentales(pasarArray(contenidoProcedimentalList.getSelectedIndices()));
        dato[8] = contenidosFijos.setContenidosActitudinales(pasarArray(contenidoActitudinalList.getSelectedIndices()));
        //Tercera Ventana
        dato[9] = contenidosAgregados.setContenidosGeneralesEnsenianzaInicio(contenidosGeneralesEnsenianzaInicioTextArea.getText());
        dato[10] = contenidosAgregados.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicioTextArea.getText());
        //\\
        dato[11] = contenidosFijos.setCompetenciasGenericasAprendeInicio(pasarArray(competenciasGenericasAprendeInicioList.getSelectedIndices()));
        dato[12] = contenidosFijos.setCompetenciasGenericasAutodeterminaInicio(pasarArray(competenciasGenericasAutodeterminaInicioList.getSelectedIndices()));
        dato[13] = contenidosFijos.setCompetenciasGenericasExpresaInicio(pasarArray(competenciasGenericasExpresaInicioList.getSelectedIndices()));
        dato[14] = contenidosFijos.setCompetenciasGenericasParticipaInicio(pasarArray(competenciasGenericasParticipaInicioList.getSelectedIndices()));
        dato[15] = contenidosFijos.setCompetenciasGenericasPiensaInicio(pasarArray(competenciasGenericasPiensaInicioList.getSelectedIndices()));
        dato[16] = contenidosFijos.setCompetenciasGenericasTrabajaInicio(pasarArray(competenciasGenericasTrabajaInicioList.getSelectedIndices()));
        //\\
        dato[17] = contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesInicio(pasarArray(CompetenciasDisciplinaresCienciasExperimentalesInicioList.getSelectedIndices()));
        dato[18] = contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesInicio(pasarArray(CompetenciasDisciplinaresCienciasSocialesInicioList.getSelectedIndices()));
        dato[19] = contenidosFijos.setCompetenciasDisciplinaresComunicacionInicio(pasarArray(CompetenciasDisciplinaresComunicacionInicioList.getSelectedIndices()));
        dato[20] = contenidosFijos.setCompetenciasDisciplinaresMatematicasInicio(pasarArray(CompetenciasDisciplinaresMatematicasInicioList.getSelectedIndices()));
        //\\
        dato[21] = contenidosFijos.setEvidenciasDeAprendizajeInicio(pasarArray(competenciasInicioEvidenciasList.getSelectedIndices()));
        dato[22] = contenidosFijos.setInstrumentosDeEvaluacionInicio(pasarArray(competenciasInicioInstrumentosList.getSelectedIndices()));
        //Cuarta Ventana (Desarollo)
        dato[23] = contenidosAgregados.setContenidosGeneralesEnsenianzaDesarrollo(contenidosGeneralesEnsenianzaDesarolloTextArea.getText());
        dato[24] = contenidosAgregados.setContenidosGeneralesAprendizajeDesarrollo(contenidosGeneralesAprendizajeDesarolloTextArea.getText());
        //\\
        dato[25] = contenidosFijos.setCompetenciasGenericasAprendeDesarrollo(pasarArray(competenciasGenericasAprendeDesarrolloList.getSelectedIndices()));
        dato[26] = contenidosFijos.setCompetenciasGenericasAutodeterminaDesarrollo(pasarArray(competenciasGenericasAutodeterminaDesarrolloList.getSelectedIndices()));
        dato[27] = contenidosFijos.setCompetenciasGenericasExpresaDesarrollo(pasarArray(competenciasGenericasExpresaDesarrolloList.getSelectedIndices()));
        dato[28] = contenidosFijos.setCompetenciasGenericasParticipaDesarrollo(pasarArray(competenciasGenericasParticipaDesarrolloList.getSelectedIndices()));
        dato[29] = contenidosFijos.setCompetenciasGenericasTrabajaDesarrollo(pasarArray(competenciasGenericasTrabajaDesarrolloList.getSelectedIndices()));
        //\\
        dato[30] = contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesDesarrollo(pasarArray(competenciasDisciplinaresCienciasExperimentalesDesarrolloList.getSelectedIndices()));
        dato[31] = contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesDesarrollo(pasarArray(competenciasDisciplinaresCienciasSocialesDesarrolloList.getSelectedIndices()));
        dato[32] = contenidosFijos.setCompetenciasDisciplinaresComunicacionDesarrollo(pasarArray(competenciasDisciplinaresComunicacionDesarrolloList.getSelectedIndices()));
        dato[33] = contenidosFijos.setCompetenciasDisciplinaresMatematicasDesarrollo(pasarArray(competenciasDisciplinaresMatematicasDesarrolloList.getSelectedIndices()));
        //\\
        dato[34] = contenidosFijos.setEvidenciasDeAprendizajeDesarrollo(pasarArray(evidenciasDeAprendizajeDesarrolloList.getSelectedIndices()));
        dato[35] = contenidosFijos.setInstrumentosDeEvaluacionDesarrollo(pasarArray(instrumentosDeEvaluacionDesarrolloList.getSelectedIndices()));
        //Quinta Ventana (Cierre)
        dato[36] = contenidosAgregados.setContenidosGeneralesEnsenianzaCierre(contenidosGeneralesEnsenianzaCierreTextArea.getText());
        dato[37] = contenidosAgregados.setContenidosGeneralesAprendizajeCierre(contenidosGeneralesAprendizajeCierreTextArea.getText());
        //\\
        dato[38] = contenidosFijos.setCompetenciasGenericasAprendeCierre(pasarArray(competenciasGenericasAprendeCierreList.getSelectedIndices()));
        dato[39] = contenidosFijos.setCompetenciasGenericasAutodeterminaCierre(pasarArray(competenciasGenericasAutodeterminaCierreList.getSelectedIndices()));
        dato[40] = contenidosFijos.setCompetenciasGenericasExpresaCierre(pasarArray(competenciasGenericasExpresaCierreList.getSelectedIndices()));
        dato[41] = contenidosFijos.setCompetenciasGenericasParticipaCierre(pasarArray(competenciasGenericasParticipaCierreList.getSelectedIndices()));
        dato[42] = contenidosFijos.setCompetenciasGenericasPiensaCierre(pasarArray(competenciasGenericasPiensaCierreList.getSelectedIndices()));
        dato[43] = contenidosFijos.setCompetenciasGenericasTrabajaCierre(pasarArray(competenciasGenericasTrabajaCierreList.getSelectedIndices()));
        //\\
        dato[44] = contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesCierre(pasarArray(competenciasDisciplinaresCienciasExperimentalesCierreList.getSelectedIndices()));
        dato[45] = contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesCierre(pasarArray(competenciasDisciplinaresCienciasSocialesCierreList.getSelectedIndices()));
        dato[46] = contenidosFijos.setCompetenciasDisciplinaresComunicacionCierre(pasarArray(competenciasDisciplinaresComunicacionCierreList.getSelectedIndices()));
        dato[47] = contenidosFijos.setCompetenciasDisciplinaresMatematicasCierre(pasarArray(competenciasDisciplinaresMatematicasCierreList.getSelectedIndices()));
        //\\
        dato[48] = contenidosFijos.setEvidenciasDeAprendizajeCierre(pasarArray(evidenciasDeAprendizajeCierreList.getSelectedIndices()));
        dato[49] = contenidosFijos.setInstrumentosDeEvaluacionCierre(pasarArray(instrumentosDeEvaluacionCierreList.getSelectedIndices()));
        //Sexta Ventana
        dato[50] = contenidosAgregados.setRecursosMateriales(recursosMaterialesTextArea.getText());
        dato[51] = contenidosAgregados.setFuentesInformacion(fuentesInformacionTextArea.getText());
        dato[52] = contenidosAgregados.setObservaciones(observacionesReflexionesTextArea.getText());

        return dato;
    }

    private int[] validarCampos(){
        int lista[];
        int listaAux[] = new int[100];
        lista = setearValores();
        int i;
        for (i = 0; i < 11; i++){
            listaAux[i] = lista[i];
        }
        for (i = 11; i <= 16; i++){
            if (lista[i] > 1){
                listaAux[12] = 1;
                i = 17;
            }
        }
        for (i = 17; i <= 20; i++){
            if (lista[i] > 1){
                listaAux[13] = 1;
                i = 21;
            }
        }
        listaAux[14] = lista[21];
        listaAux[15] = lista[22];
        listaAux[16] = lista[23];
        listaAux[17] = lista[24];
        for (i = 25; i <= 29; i++){
            if (lista[i] > 1){
                listaAux[18] = 1;
                i = 30;
            }
        }
        for (i = 30; i <= 33; i++){
            if (lista[i] > 1){
                listaAux[19] = 1;
                i = 34;
            }
        }
        listaAux[20] = lista[34];
        listaAux[21] = lista[35];
        listaAux[22] = lista[36];
        listaAux[23] = lista[37];
        for (i = 38; i <= 43; i++){
            if (lista[i] > 1){
                listaAux[24] = 1;
                i = 44;
            }
        }
        for (i = 44; i <= 47; i++){
            if (lista[i] > 1){
                listaAux[25] = 1;
                i = 48;
            }
        }
        for (i = 48; i <= 52; i++){
            listaAux[i - 22] = lista[i];
        }

        return listaAux;
    }

    private void presionarControl(){
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);

        }catch (AWTException ex){
            Logger.getLogger(Rubrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void soltarControl(){
        try{
            Robot robot = new Robot();
            robot.keyRelease(KeyEvent.VK_CONTROL);

        }catch (AWTException ex){
            Logger.getLogger(Rubrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rubrica(Asignatura asignatura, ContenidosAgregados contenidosAgregados, ContenidosFijos contenidosFijos){
        Rubrica.contenidosFijos = contenidosFijos;
        Rubrica.contenidosAgregados = contenidosAgregados;
        Rubrica.asignatura = asignatura;
        contenidosFijos.setAsignatura(asignatura);
        initComponents();
        //contenidoDeclarativoList.set
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyBorder1 = (javax.swing.border.EmptyBorder)javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1);
        jScrollPane30 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        principalTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        semestreLabel = new javax.swing.JLabel();
        asignaturaLabel = new javax.swing.JLabel();
        bloqueLabel = new javax.swing.JLabel();
        docenteLabel = new javax.swing.JLabel();
        periodoEscolarLabel = new javax.swing.JLabel();
        numeroSecuenciaLabel = new javax.swing.JLabel();
        numeroSesionesLabel = new javax.swing.JLabel();
        fechaInicioLabel = new javax.swing.JLabel();
        asignaturaTextField = new javax.swing.JTextField();
        semestreTextField = new javax.swing.JTextField();
        bloqueTextField = new javax.swing.JTextField();
        docenteTextField = new javax.swing.JTextField();
        fechaInicioTextField = new javax.swing.JTextField();
        numeroSesionesTextField = new javax.swing.JTextField();
        numeroSecuenciaTextField = new javax.swing.JTextField();
        periodoEscolarTextField = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        propositoSecuenciaLabel = new javax.swing.JLabel();
        otrasMateriasRelacionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        asignaturasRelacionadasTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        propositoSecuenciaTextArea = new javax.swing.JTextArea();
        contenidoPanel = new javax.swing.JPanel();
        contenidoDeclarativoPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        contenidoDeclarativoList = new javax.swing.JList<>();
        contenidoProcedimentalPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        contenidoProcedimentalList = new javax.swing.JList<>();

        contenidoActitudinalPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        contenidoActitudinalList = new javax.swing.JList<>();
        contenidoDeclarativoLabel = new javax.swing.JLabel();
        contenidoProcedimentalLabel = new javax.swing.JLabel();
        contenidoActitudinalLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        competenciasInicioTabbedPane = new javax.swing.JTabbedPane();
        inicioPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        contenidosGeneralesEnsenianzaInicioTextArea = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        contenidosGeneralesAprendizajeInicioTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresCienciasExperimentalesInicioList = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresCienciasSocialesInicioList = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresComunicacionInicioList = new javax.swing.JList<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresMatematicasInicioList = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane47 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        competenciasGenericasAprendeInicioList = new javax.swing.JList<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        competenciasGenericasAutodeterminaInicioList = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        competenciasGenericasExpresaInicioList = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        competenciasGenericasParticipaInicioList = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        competenciasGenericasPiensaInicioList = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        competenciasGenericasTrabajaInicioList = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        competenciasInicioEvidenciasList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        competenciasInicioInstrumentosList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        competenciasDesarolloTabbedPane = new javax.swing.JTabbedPane();
        desarolloPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        contenidosGeneralesAprendizajeDesarolloTextArea = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        contenidosGeneralesEnsenianzaDesarolloTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane32 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList = new javax.swing.JList<>();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        competenciasDisciplinaresCienciasSocialesDesarrolloList = new javax.swing.JList<>();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        competenciasDisciplinaresComunicacionDesarrolloList = new javax.swing.JList<>();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        competenciasDisciplinaresMatematicasDesarrolloList = new javax.swing.JList<>();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane50 = new javax.swing.JScrollPane();
        jPanel32 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        competenciasGenericasAprendeDesarrolloList = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane52 = new javax.swing.JScrollPane();
        competenciasGenericasAutodeterminaDesarrolloList = new javax.swing.JList<>();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane53 = new javax.swing.JScrollPane();
        competenciasGenericasExpresaDesarrolloList = new javax.swing.JList<>();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane54 = new javax.swing.JScrollPane();
        competenciasGenericasParticipaDesarrolloList = new javax.swing.JList<>();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane55 = new javax.swing.JScrollPane();
        competenciasGenericasPiensaDesarrolloList = new javax.swing.JList<>();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane56 = new javax.swing.JScrollPane();
        competenciasGenericasTrabajaDesarrolloList = new javax.swing.JList<>();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        evidenciasDeAprendizajeDesarrolloList = new javax.swing.JList<>();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        instrumentosDeEvaluacionDesarrolloList = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        competenciasCierreTabbedPane = new javax.swing.JTabbedPane();
        cierrePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        contenidosGeneralesAprendizajeCierreTextArea = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        contenidosGeneralesEnsenianzaCierreTextArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane57 = new javax.swing.JScrollPane();
        jPanel35 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane58 = new javax.swing.JScrollPane();
        competenciasDisciplinaresCienciasExperimentalesCierreList = new javax.swing.JList<>();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane59 = new javax.swing.JScrollPane();
        competenciasDisciplinaresCienciasSocialesCierreList = new javax.swing.JList<>();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane60 = new javax.swing.JScrollPane();
        competenciasDisciplinaresComunicacionCierreList = new javax.swing.JList<>();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane61 = new javax.swing.JScrollPane();
        competenciasDisciplinaresMatematicasCierreList = new javax.swing.JList<>();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane62 = new javax.swing.JScrollPane();
        jPanel38 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane63 = new javax.swing.JScrollPane();
        competenciasGenericasAprendeCierreList = new javax.swing.JList<>();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane64 = new javax.swing.JScrollPane();
        competenciasGenericasAutodeterminaCierreList = new javax.swing.JList<>();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane65 = new javax.swing.JScrollPane();
        competenciasGenericasExpresaCierreList = new javax.swing.JList<>();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane66 = new javax.swing.JScrollPane();
        competenciasGenericasParticipaCierreList = new javax.swing.JList<>();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane67 = new javax.swing.JScrollPane();
        competenciasGenericasPiensaCierreList = new javax.swing.JList<>();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane68 = new javax.swing.JScrollPane();
        competenciasGenericasTrabajaCierreList = new javax.swing.JList<>();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        evidenciasDeAprendizajeCierreList = new javax.swing.JList<>();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        instrumentosDeEvaluacionCierreList = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        recursosPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recursosMaterialesTextArea = new javax.swing.JTextArea();
        recursosMaterialesLabel = new javax.swing.JLabel();
        fuentesInformacionLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fuentesInformacionTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        observacionesReflexionesTextArea = new javax.swing.JTextArea();
        observacionesReflexionesLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        siguienteButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane30.setViewportView(jList4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalTabbedPane.setBackground(new java.awt.Color(238, 238, 238));
        principalTabbedPane.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        principalTabbedPane.setToolTipText("");
        principalTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        semestreLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        semestreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semestreLabel.setText("Semestre");

        asignaturaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        asignaturaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignaturaLabel.setText("Asignatura");

        bloqueLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bloqueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bloqueLabel.setText("Bloque");

        docenteLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        docenteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        docenteLabel.setText("Docente");

        periodoEscolarLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        periodoEscolarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        periodoEscolarLabel.setText("Periodo escolar");

        numeroSecuenciaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numeroSecuenciaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroSecuenciaLabel.setText("Número de secuencia");

        numeroSesionesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numeroSesionesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroSesionesLabel.setText("Número de sesiones");

        fechaInicioLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaInicioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaInicioLabel.setText("Fecha de inicio");

        asignaturaTextField.setEditable(false);
        asignaturaTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        asignaturaTextField.setText(asignatura.getAsignatura());

        semestreTextField.setEditable(false);
        semestreTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        semestreTextField.setText(Integer.toString(asignatura.getSemestre()));

        bloqueTextField.setEditable(false);
        bloqueTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bloqueTextField.setText(asignatura.getBloque());

        docenteTextField.setEditable(false);
        docenteTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        docenteTextField.setText(asignatura.getNombreCompletoMaestro());

        fechaInicioTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fechaInicioTextField.setText("<Rellenar>");
        fechaInicioTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaInicioTextFieldMouseClicked(evt);
            }
        });

        numeroSesionesTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numeroSesionesTextField.setText("<Rellenar>");
        numeroSesionesTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroSesionClick(evt);
            }
        });

        numeroSecuenciaTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numeroSecuenciaTextField.setText("<Rellenar>");
        numeroSecuenciaTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroSecuenciaClick(evt);
            }
        });

        periodoEscolarTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        periodoEscolarTextField.setText("<Rellenar>");
        periodoEscolarTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                periodoEscolarClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asignaturaTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoEscolarLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoEscolarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asignaturaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(semestreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numeroSecuenciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroSecuenciaTextField, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(semestreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numeroSesionesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numeroSesionesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bloqueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bloqueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaInicioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(docenteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(docenteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semestreLabel)
                    .addComponent(asignaturaLabel)
                    .addComponent(bloqueLabel)
                    .addComponent(docenteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignaturaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semestreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloqueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docenteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodoEscolarLabel)
                    .addComponent(numeroSecuenciaLabel)
                    .addComponent(numeroSesionesLabel)
                    .addComponent(fechaInicioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodoEscolarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroSecuenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroSesionesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        propositoSecuenciaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        propositoSecuenciaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        propositoSecuenciaLabel.setText("Propósito de la secuencia");

        otrasMateriasRelacionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        otrasMateriasRelacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        otrasMateriasRelacionLabel.setText("Otras materias con las que se relaciona");

        asignaturasRelacionadasTextArea.setColumns(20);
        asignaturasRelacionadasTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        asignaturasRelacionadasTextArea.setRows(5);
        jScrollPane1.setViewportView(asignaturasRelacionadasTextArea);

        propositoSecuenciaTextArea.setColumns(20);
        propositoSecuenciaTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        propositoSecuenciaTextArea.setRows(5);
        jScrollPane2.setViewportView(propositoSecuenciaTextArea);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(otrasMateriasRelacionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propositoSecuenciaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(propositoSecuenciaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otrasMateriasRelacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        principalTabbedPane.addTab("Inicio", jPanel1);

        contenidoDeclarativoPanel.setBackground(new java.awt.Color(255, 255, 255));
        contenidoDeclarativoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contenidoDeclarativoPanel.setAutoscrolls(true);

        contenidoDeclarativoList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoDeclarativoList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosDeclarativos();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoDeclarativoList.setAutoscrolls(false);
        contenidoDeclarativoList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        contenidoDeclarativoList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoDeclarativoListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoDeclarativoListMouseExited(evt);
            }
        });
        jScrollPane6.setViewportView(contenidoDeclarativoList);
        int tamañoContenidosDeclarativos =contenidoDeclarativoList.getModel().getSize();
        contenidoDeclarativoList.setSelectionInterval(0, tamañoContenidosDeclarativos);

        javax.swing.GroupLayout contenidoDeclarativoPanelLayout = new javax.swing.GroupLayout(contenidoDeclarativoPanel);
        contenidoDeclarativoPanel.setLayout(contenidoDeclarativoPanelLayout);
        contenidoDeclarativoPanelLayout.setHorizontalGroup(
            contenidoDeclarativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoDeclarativoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenidoDeclarativoPanelLayout.setVerticalGroup(
            contenidoDeclarativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoDeclarativoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        contenidoProcedimentalPanel.setBackground(new java.awt.Color(255, 255, 255));
        contenidoProcedimentalPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contenidoProcedimentalPanel.setAutoscrolls(true);

        contenidoProcedimentalList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoProcedimentalList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosProcedimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoProcedimentalList.setAutoscrolls(false);
        contenidoProcedimentalList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        contenidoProcedimentalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoProcedimentalListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoProcedimentalListMouseExited(evt);
            }
        });
        jScrollPane7.setViewportView(contenidoProcedimentalList);
        int tamañoContenidosProcedimentales =contenidoProcedimentalList.getModel().getSize();
        contenidoProcedimentalList.setSelectionInterval(0, tamañoContenidosProcedimentales);

        javax.swing.GroupLayout contenidoProcedimentalPanelLayout = new javax.swing.GroupLayout(contenidoProcedimentalPanel);
        contenidoProcedimentalPanel.setLayout(contenidoProcedimentalPanelLayout);
        contenidoProcedimentalPanelLayout.setHorizontalGroup(
            contenidoProcedimentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoProcedimentalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenidoProcedimentalPanelLayout.setVerticalGroup(
            contenidoProcedimentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoProcedimentalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        contenidoActitudinalPanel.setBackground(new java.awt.Color(255, 255, 255));
        contenidoActitudinalPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contenidoActitudinalPanel.setAutoscrolls(true);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contenidoActitudinalList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoActitudinalList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosActitudinales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoActitudinalList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        contenidoActitudinalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoActitudinalListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoActitudinalListMouseExited(evt);
            }
        });
        jScrollPane9.setViewportView(contenidoActitudinalList);
        int tamañoContenidosActitudinales =contenidoActitudinalList.getModel().getSize();
        contenidoActitudinalList.setSelectionInterval(0, tamañoContenidosActitudinales);

        javax.swing.GroupLayout contenidoActitudinalPanelLayout = new javax.swing.GroupLayout(contenidoActitudinalPanel);
        contenidoActitudinalPanel.setLayout(contenidoActitudinalPanelLayout);
        contenidoActitudinalPanelLayout.setHorizontalGroup(
            contenidoActitudinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoActitudinalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenidoActitudinalPanelLayout.setVerticalGroup(
            contenidoActitudinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoActitudinalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        contenidoDeclarativoLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoDeclarativoLabel.setText("Contenido Declarativo");

        contenidoProcedimentalLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoProcedimentalLabel.setText("Contenido Procedimental");

        contenidoActitudinalLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoActitudinalLabel.setText("Contenido Actitudinal");

        javax.swing.GroupLayout contenidoPanelLayout = new javax.swing.GroupLayout(contenidoPanel);
        contenidoPanel.setLayout(contenidoPanelLayout);
        contenidoPanelLayout.setHorizontalGroup(
            contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoDeclarativoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenidoDeclarativoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoProcedimentalLabel)
                    .addComponent(contenidoProcedimentalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoPanelLayout.createSequentialGroup()
                        .addComponent(contenidoActitudinalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(contenidoActitudinalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        contenidoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {contenidoActitudinalPanel, contenidoDeclarativoPanel, contenidoProcedimentalPanel});

        contenidoPanelLayout.setVerticalGroup(
            contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(contenidoDeclarativoLabel)
                        .addComponent(contenidoProcedimentalLabel))
                    .addComponent(contenidoActitudinalLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contenidoProcedimentalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenidoDeclarativoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenidoActitudinalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contenidoPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {contenidoActitudinalPanel, contenidoDeclarativoPanel, contenidoProcedimentalPanel});

        principalTabbedPane.addTab("Contenidos", contenidoPanel);

        competenciasInicioTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Enseñanza");

        contenidosGeneralesEnsenianzaInicioTextArea.setColumns(20);
        contenidosGeneralesEnsenianzaInicioTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesEnsenianzaInicioTextArea.setRows(5);
        jScrollPane8.setViewportView(contenidosGeneralesEnsenianzaInicioTextArea);

        contenidosGeneralesAprendizajeInicioTextArea.setColumns(20);
        contenidosGeneralesAprendizajeInicioTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesAprendizajeInicioTextArea.setRows(5);
        jScrollPane10.setViewportView(contenidosGeneralesAprendizajeInicioTextArea);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Aprendizaje");

        javax.swing.GroupLayout inicioPanelLayout = new javax.swing.GroupLayout(inicioPanel);
        inicioPanel.setLayout(inicioPanelLayout);
        inicioPanelLayout.setHorizontalGroup(
            inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addGroup(inicioPanelLayout.createSequentialGroup()
                        .addGroup(inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        inicioPanelLayout.setVerticalGroup(
            inicioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        competenciasInicioTabbedPane.addTab("Inicio", inicioPanel);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane27.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane27.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setText("Ciencias Experimentales");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 0, -1, -1));

        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setName(""); // NOI18N
        int i = contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales().size();
        Dimension dimension = new Dimension(i,0);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setPreferredSize(dimension);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setValueIsAdjusting(true);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setVisibleRowCount(10);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseExited(evt);
            }
        });
        jScrollPane28.setViewportView(CompetenciasDisciplinaresCienciasExperimentalesInicioList);

        jPanel8.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 920, 131));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Ciencias Sociales");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 147, -1, -1));

        CompetenciasDisciplinaresCienciasSocialesInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresCienciasSocialesInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasSociales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresCienciasSocialesInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresCienciasSocialesInicioList.setVisibleRowCount(10);
        CompetenciasDisciplinaresCienciasSocialesInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseExited(evt);
            }
        });
        jScrollPane29.setViewportView(CompetenciasDisciplinaresCienciasSocialesInicioList);

        jPanel8.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 920, 131));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Comunicación");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 294, -1, -1));

        CompetenciasDisciplinaresComunicacionInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresComunicacionInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresComunicaciones();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresComunicacionInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresComunicacionInicioList.setVisibleRowCount(10);
        CompetenciasDisciplinaresComunicacionInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseExited(evt);
            }
        });
        jScrollPane15.setViewportView(CompetenciasDisciplinaresComunicacionInicioList);

        jPanel8.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 920, 131));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setText("Matemáticas");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 441, -1, -1));

        CompetenciasDisciplinaresMatematicasInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresMatematicasInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresMatematicas();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresMatematicasInicioList.setVisibleRowCount(10);
        CompetenciasDisciplinaresMatematicasInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CompetenciasDisciplinaresComunicacionInicioListMouseExited(evt);
            }
        });
        jScrollPane31.setViewportView(CompetenciasDisciplinaresMatematicasInicioList);

        jPanel8.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 457, 920, 131));

        jScrollPane27.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        competenciasInicioTabbedPane.addTab("Competencias Disiplinares", jPanel5);

        jScrollPane47.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane47.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel16.setMaximumSize(new java.awt.Dimension(970, 32767));
        jPanel16.setMinimumSize(new java.awt.Dimension(970, 0));
        jPanel16.setPreferredSize(new java.awt.Dimension(970, 1100));
        jPanel16.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel27.setText("Aprende");
        jPanel16.add(jLabel27);
        jLabel27.setBounds(114, 0, 45, 16);

        competenciasGenericasAprendeInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAprendeInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAprende();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAprendeInicioList.setMaximumSize(new java.awt.Dimension(840, 0));
        competenciasGenericasAprendeInicioList.setMinimumSize(new java.awt.Dimension(840, 0));
        competenciasGenericasAprendeInicioList.setPreferredSize(new java.awt.Dimension(840, 0));
        competenciasGenericasAprendeInicioList.setValueIsAdjusting(true);
        competenciasGenericasAprendeInicioList.setVisibleRowCount(10);
        competenciasGenericasAprendeInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasAprendeInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasAprendeInicioListMouseExited(evt);
            }
        });
        jScrollPane24.setViewportView(competenciasGenericasAprendeInicioList);

        jPanel16.add(jScrollPane24);
        jScrollPane24.setBounds(0, 16, 920, 179);

        competenciasGenericasAutodeterminaInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAutodeterminaInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAutodetermina();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAutodeterminaInicioList.setVisibleRowCount(10);
        competenciasGenericasAutodeterminaInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasAutodeterminaInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasAutodeterminaInicioListMouseExited(evt);
            }
        });
        jScrollPane16.setViewportView(competenciasGenericasAutodeterminaInicioList);

        jPanel16.add(jScrollPane16);
        jScrollPane16.setBounds(0, 210, 920, 162);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Expresa");
        jPanel16.add(jLabel10);
        jLabel10.setBounds(130, 370, 40, 16);

        competenciasGenericasExpresaInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasExpresaInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseExpresa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasExpresaInicioList.setVisibleRowCount(10);
        competenciasGenericasExpresaInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasExpresaInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasExpresaInicioListMouseExited(evt);
            }
        });
        jScrollPane23.setViewportView(competenciasGenericasExpresaInicioList);

        jPanel16.add(jScrollPane23);
        jScrollPane23.setBounds(0, 390, 920, 162);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Participa");
        jPanel16.add(jLabel13);
        jLabel13.setBounds(130, 550, 46, 16);

        competenciasGenericasParticipaInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasParticipaInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseParticipa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasParticipaInicioList.setVisibleRowCount(10);
        competenciasGenericasParticipaInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasParticipaInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasParticipaInicioListMouseExited(evt);
            }
        });
        jScrollPane48.setViewportView(competenciasGenericasParticipaInicioList);

        jPanel16.add(jScrollPane48);
        jScrollPane48.setBounds(0, 570, 920, 162);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Piensa");
        jPanel16.add(jLabel11);
        jLabel11.setBounds(140, 730, 34, 16);

        competenciasGenericasPiensaInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasPiensaInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasePiensa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasPiensaInicioList.setVisibleRowCount(10);
        competenciasGenericasPiensaInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaInicioListMouseExited(evt);
            }
        });
        jScrollPane49.setViewportView(competenciasGenericasPiensaInicioList);

        jPanel16.add(jScrollPane49);
        jScrollPane49.setBounds(0, 750, 920, 162);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Trabaja");
        jPanel16.add(jLabel15);
        jLabel15.setBounds(140, 910, 38, 16);

        competenciasGenericasTrabajaInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasTrabajaInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseTrabaja();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasTrabajaInicioList.setVisibleRowCount(10);
        competenciasGenericasTrabajaInicioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaInicioListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaInicioListMouseExited(evt);
            }
        });
        jScrollPane20.setViewportView(competenciasGenericasTrabajaInicioList);

        jPanel16.add(jScrollPane20);
        jScrollPane20.setBounds(0, 930, 920, 162);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Autodetermina");
        jPanel16.add(jLabel12);
        jLabel12.setBounds(120, 190, 80, 20);

        jScrollPane47.setViewportView(jPanel16);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        competenciasInicioTabbedPane.addTab("Competencias Genericas", jPanel11);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        competenciasInicioEvidenciasList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasInicioEvidenciasList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarEvidenciasDeAprendizaje();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasInicioEvidenciasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasInicioEvidenciasListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasInicioEvidenciasListMouseExited(evt);
            }
        });
        jScrollPane17.setViewportView(competenciasInicioEvidenciasList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        competenciasInicioInstrumentosList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasInicioInstrumentosList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarInstrumentosDeEvaluacion();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasInicioInstrumentosList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasInicioInstrumentosListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasInicioInstrumentosListMouseExited(evt);
            }
        });
        jScrollPane18.setViewportView(competenciasInicioInstrumentosList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Evidencias");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Instrumentos de Evaluación");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        competenciasInicioTabbedPane.addTab("Evidencias / Instrumentos", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(competenciasInicioTabbedPane)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(competenciasInicioTabbedPane)
        );

        principalTabbedPane.addTab("Competencias / Inicio", jPanel3);

        competenciasDesarolloTabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        competenciasDesarolloTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Aprendizaje");

        contenidosGeneralesAprendizajeDesarolloTextArea.setColumns(20);
        contenidosGeneralesAprendizajeDesarolloTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesAprendizajeDesarolloTextArea.setRows(5);
        jScrollPane11.setViewportView(contenidosGeneralesAprendizajeDesarolloTextArea);

        contenidosGeneralesEnsenianzaDesarolloTextArea.setColumns(20);
        contenidosGeneralesEnsenianzaDesarolloTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesEnsenianzaDesarolloTextArea.setRows(5);
        jScrollPane12.setViewportView(contenidosGeneralesEnsenianzaDesarolloTextArea);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Enseñanza");

        javax.swing.GroupLayout desarolloPanelLayout = new javax.swing.GroupLayout(desarolloPanel);
        desarolloPanel.setLayout(desarolloPanelLayout);
        desarolloPanelLayout.setHorizontalGroup(
            desarolloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desarolloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desarolloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                    .addGroup(desarolloPanelLayout.createSequentialGroup()
                        .addGroup(desarolloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        desarolloPanelLayout.setVerticalGroup(
            desarolloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desarolloPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        competenciasDesarolloTabbedPane.addTab("Desarollo", desarolloPanel);

        jScrollPane32.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane32.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel22.setMinimumSize(new java.awt.Dimension(900, 750));
        jPanel22.setPreferredSize(new java.awt.Dimension(900, 750));
        jPanel22.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel24.setText("Ciencias Experimentales");
        jPanel22.add(jLabel24);
        jLabel24.setBounds(76, 0, 127, 16);

        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setAutoscrolls(false);
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setName(""); // NOI18N
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setPreferredSize(dimension);
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setValueIsAdjusting(true);
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.setVisibleRowCount(10);
        competenciasDisciplinaresCienciasExperimentalesDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane33.setViewportView(competenciasDisciplinaresCienciasExperimentalesDesarrolloList);

        jPanel22.add(jScrollPane33);
        jScrollPane33.setBounds(0, 16, 910, 162);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setText("Ciencias Sociales");
        jPanel22.add(jLabel22);
        jLabel22.setBounds(76, 178, 89, 16);

        competenciasDisciplinaresCienciasSocialesDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresCienciasSocialesDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasSociales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresCienciasSocialesDesarrolloList.setAutoscrolls(false);
        competenciasDisciplinaresCienciasSocialesDesarrolloList.setVisibleRowCount(10);
        competenciasDisciplinaresCienciasSocialesDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane34.setViewportView(competenciasDisciplinaresCienciasSocialesDesarrolloList);

        jPanel22.add(jScrollPane34);
        jScrollPane34.setBounds(0, 194, 910, 162);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setText("Comunicación");
        jPanel22.add(jLabel25);
        jLabel25.setBounds(76, 356, 78, 16);

        competenciasDisciplinaresComunicacionDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresComunicacionDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresComunicaciones();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresComunicacionDesarrolloList.setAutoscrolls(false);
        competenciasDisciplinaresComunicacionDesarrolloList.setVisibleRowCount(10);
        competenciasDisciplinaresComunicacionDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane19.setViewportView(competenciasDisciplinaresComunicacionDesarrolloList);

        jPanel22.add(jScrollPane19);
        jScrollPane19.setBounds(0, 372, 910, 162);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel26.setText("Matemáticas");
        jPanel22.add(jLabel26);
        jLabel26.setBounds(76, 534, 68, 16);

        competenciasDisciplinaresMatematicasDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresMatematicasDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresMatematicas();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresMatematicasDesarrolloList.setVisibleRowCount(10);
        competenciasDisciplinaresMatematicasDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane46.setViewportView(competenciasDisciplinaresMatematicasDesarrolloList);

        jPanel22.add(jScrollPane46);
        jScrollPane46.setBounds(0, 550, 910, 162);

        jScrollPane32.setViewportView(jPanel22);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane32, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        competenciasDesarolloTabbedPane.addTab("Competencias Disiplinares", jPanel17);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane50.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane50.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel32.setMinimumSize(new java.awt.Dimension(950, 1100));
        jPanel32.setPreferredSize(new java.awt.Dimension(956, 1100));
        jPanel32.setLayout(null);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setText("Aprende");
        jPanel32.add(jLabel28);
        jLabel28.setBounds(115, 0, 45, 16);

        competenciasGenericasAprendeDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAprendeDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAprende();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAprendeDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasAprendeDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane51.setViewportView(competenciasGenericasAprendeDesarrolloList);

        jPanel32.add(jScrollPane51);
        jScrollPane51.setBounds(0, 16, 920, 162);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Autodetermina");
        jPanel32.add(jLabel16);
        jLabel16.setBounds(115, 178, 80, 16);

        competenciasGenericasAutodeterminaDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAutodeterminaDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAutodetermina();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAutodeterminaDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasAutodeterminaDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane52.setViewportView(competenciasGenericasAutodeterminaDesarrolloList);

        jPanel32.add(jScrollPane52);
        jScrollPane52.setBounds(0, 194, 920, 162);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel39.setText("Expresa");
        jPanel32.add(jLabel39);
        jLabel39.setBounds(115, 356, 40, 16);

        competenciasGenericasExpresaDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasExpresaDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseExpresa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasExpresaDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasExpresaDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane53.setViewportView(competenciasGenericasExpresaDesarrolloList);

        jPanel32.add(jScrollPane53);
        jScrollPane53.setBounds(0, 372, 920, 162);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel40.setText("Participa");
        jPanel32.add(jLabel40);
        jLabel40.setBounds(115, 534, 46, 16);

        competenciasGenericasParticipaDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasParticipaDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseParticipa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasParticipaDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasParticipaDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane54.setViewportView(competenciasGenericasParticipaDesarrolloList);

        jPanel32.add(jScrollPane54);
        jScrollPane54.setBounds(0, 550, 920, 162);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setText("Piensa");
        jPanel32.add(jLabel41);
        jLabel41.setBounds(115, 712, 34, 16);

        competenciasGenericasPiensaDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasPiensaDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasePiensa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasPiensaDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasPiensaDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane55.setViewportView(competenciasGenericasPiensaDesarrolloList);

        jPanel32.add(jScrollPane55);
        jScrollPane55.setBounds(0, 728, 920, 162);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel42.setText("Trabaja");
        jPanel32.add(jLabel42);
        jLabel42.setBounds(115, 890, 38, 16);

        competenciasGenericasTrabajaDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasTrabajaDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseTrabaja();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasTrabajaDesarrolloList.setVisibleRowCount(10);
        competenciasGenericasTrabajaDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasPiensaDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane56.setViewportView(competenciasGenericasTrabajaDesarrolloList);

        jPanel32.add(jScrollPane56);
        jScrollPane56.setBounds(0, 906, 920, 162);

        jScrollPane50.setViewportView(jPanel32);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        competenciasDesarolloTabbedPane.addTab("Competencias Genericas", jPanel23);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        evidenciasDeAprendizajeDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        evidenciasDeAprendizajeDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarEvidenciasDeAprendizaje();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        evidenciasDeAprendizajeDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evidenciasDeAprendizajeDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evidenciasDeAprendizajeDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane21.setViewportView(evidenciasDeAprendizajeDesarrolloList);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21)
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        instrumentosDeEvaluacionDesarrolloList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        instrumentosDeEvaluacionDesarrolloList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarInstrumentosDeEvaluacion();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        instrumentosDeEvaluacionDesarrolloList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                instrumentosDeEvaluacionDesarrolloListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                instrumentosDeEvaluacionDesarrolloListMouseExited(evt);
            }
        });
        jScrollPane22.setViewportView(instrumentosDeEvaluacionDesarrolloList);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Evidencias");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setText("Instrumentos de Evaluación");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasDesarolloTabbedPane.addTab("Evidencias / Instrumentos", jPanel19);

        principalTabbedPane.addTab("Competencias / Desarollo", competenciasDesarolloTabbedPane);

        competenciasCierreTabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        competenciasCierreTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Aprendizaje");

        contenidosGeneralesAprendizajeCierreTextArea.setColumns(20);
        contenidosGeneralesAprendizajeCierreTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesAprendizajeCierreTextArea.setRows(5);
        jScrollPane13.setViewportView(contenidosGeneralesAprendizajeCierreTextArea);

        contenidosGeneralesEnsenianzaCierreTextArea.setColumns(20);
        contenidosGeneralesEnsenianzaCierreTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidosGeneralesEnsenianzaCierreTextArea.setRows(5);
        jScrollPane14.setViewportView(contenidosGeneralesEnsenianzaCierreTextArea);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Enseñanza");

        javax.swing.GroupLayout cierrePanelLayout = new javax.swing.GroupLayout(cierrePanel);
        cierrePanel.setLayout(cierrePanelLayout);
        cierrePanelLayout.setHorizontalGroup(
            cierrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cierrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cierrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                    .addGroup(cierrePanelLayout.createSequentialGroup()
                        .addGroup(cierrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cierrePanelLayout.setVerticalGroup(
            cierrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cierrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        competenciasCierreTabbedPane.addTab("Cierre", cierrePanel);

        jScrollPane57.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel35.setMinimumSize(new java.awt.Dimension(956, 750));
        jPanel35.setName(""); // NOI18N
        jPanel35.setPreferredSize(new java.awt.Dimension(956, 750));
        jPanel35.setLayout(null);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setText("Ciencias Experimentales");
        jPanel35.add(jLabel43);
        jLabel43.setBounds(76, 0, 127, 16);

        competenciasDisciplinaresCienciasExperimentalesCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresCienciasExperimentalesCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresCienciasExperimentalesCierreList.setAutoscrolls(false);
        competenciasDisciplinaresCienciasExperimentalesCierreList.setName(""); // NOI18N
        competenciasDisciplinaresCienciasExperimentalesCierreList.setPreferredSize(dimension);
        competenciasDisciplinaresCienciasExperimentalesCierreList.setValueIsAdjusting(true);
        competenciasDisciplinaresCienciasExperimentalesCierreList.setVisibleRowCount(10);
        competenciasDisciplinaresCienciasExperimentalesCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited(evt);
            }
        });
        jScrollPane58.setViewportView(competenciasDisciplinaresCienciasExperimentalesCierreList);

        jPanel35.add(jScrollPane58);
        jScrollPane58.setBounds(0, 16, 910, 162);

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel44.setText("Ciencias Sociales");
        jPanel35.add(jLabel44);
        jLabel44.setBounds(76, 178, 89, 16);

        competenciasDisciplinaresCienciasSocialesCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresCienciasSocialesCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasSociales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresCienciasSocialesCierreList.setAutoscrolls(false);
        competenciasDisciplinaresCienciasSocialesCierreList.setVisibleRowCount(10);
        competenciasDisciplinaresCienciasSocialesCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited(evt);
            }
        });
        jScrollPane59.setViewportView(competenciasDisciplinaresCienciasSocialesCierreList);

        jPanel35.add(jScrollPane59);
        jScrollPane59.setBounds(0, 194, 910, 162);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel45.setText("Comunicación");
        jPanel35.add(jLabel45);
        jLabel45.setBounds(76, 356, 78, 16);

        competenciasDisciplinaresComunicacionCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresComunicacionCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresComunicaciones();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresComunicacionCierreList.setAutoscrolls(false);
        competenciasDisciplinaresComunicacionCierreList.setVisibleRowCount(10);
        competenciasDisciplinaresComunicacionCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited(evt);
            }
        });
        jScrollPane60.setViewportView(competenciasDisciplinaresComunicacionCierreList);

        jPanel35.add(jScrollPane60);
        jScrollPane60.setBounds(0, 372, 910, 162);

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel46.setText("Matemáticas");
        jPanel35.add(jLabel46);
        jLabel46.setBounds(76, 534, 68, 16);

        competenciasDisciplinaresMatematicasCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDisciplinaresMatematicasCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresMatematicas();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDisciplinaresMatematicasCierreList.setVisibleRowCount(10);
        competenciasDisciplinaresMatematicasCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited(evt);
            }
        });
        jScrollPane61.setViewportView(competenciasDisciplinaresMatematicasCierreList);

        jPanel35.add(jScrollPane61);
        jScrollPane61.setBounds(0, 550, 910, 162);

        jScrollPane57.setViewportView(jPanel35);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane57, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane57, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        competenciasCierreTabbedPane.addTab("Competencias Disiplinares", jPanel33);

        jScrollPane62.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane62.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel38.setMinimumSize(new java.awt.Dimension(956, 1100));
        jPanel38.setPreferredSize(new java.awt.Dimension(956, 1100));
        jPanel38.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel47.setText("Aprende");
        jPanel38.add(jLabel47);
        jLabel47.setBounds(115, 0, 45, 16);

        competenciasGenericasAprendeCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAprendeCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAprende();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAprendeCierreList.setValueIsAdjusting(true);
        competenciasGenericasAprendeCierreList.setVisibleRowCount(10);
        competenciasGenericasAprendeCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane63.setViewportView(competenciasGenericasAprendeCierreList);

        jPanel38.add(jScrollPane63);
        jScrollPane63.setBounds(0, 16, 920, 162);

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel48.setText("Autodetermina");
        jPanel38.add(jLabel48);
        jLabel48.setBounds(115, 178, 80, 16);

        competenciasGenericasAutodeterminaCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasAutodeterminaCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasAutodetermina();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasAutodeterminaCierreList.setValueIsAdjusting(true);
        competenciasGenericasAutodeterminaCierreList.setVisibleRowCount(10);
        competenciasGenericasAutodeterminaCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane64.setViewportView(competenciasGenericasAutodeterminaCierreList);

        jPanel38.add(jScrollPane64);
        jScrollPane64.setBounds(0, 194, 920, 162);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel49.setText("Expresa");
        jPanel38.add(jLabel49);
        jLabel49.setBounds(115, 356, 40, 16);

        competenciasGenericasExpresaCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasExpresaCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseExpresa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasExpresaCierreList.setValueIsAdjusting(true);
        competenciasGenericasExpresaCierreList.setVisibleRowCount(10);
        competenciasGenericasExpresaCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane65.setViewportView(competenciasGenericasExpresaCierreList);

        jPanel38.add(jScrollPane65);
        jScrollPane65.setBounds(0, 372, 920, 162);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel50.setText("Participa");
        jPanel38.add(jLabel50);
        jLabel50.setBounds(115, 534, 46, 16);

        competenciasGenericasParticipaCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasParticipaCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseParticipa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasParticipaCierreList.setValueIsAdjusting(true);
        competenciasGenericasParticipaCierreList.setVisibleRowCount(10);
        competenciasGenericasParticipaCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane66.setViewportView(competenciasGenericasParticipaCierreList);

        jPanel38.add(jScrollPane66);
        jScrollPane66.setBounds(0, 550, 920, 162);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel51.setText("Piensa");
        jPanel38.add(jLabel51);
        jLabel51.setBounds(115, 712, 34, 16);

        competenciasGenericasPiensaCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasPiensaCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericasePiensa();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasPiensaCierreList.setValueIsAdjusting(true);
        competenciasGenericasPiensaCierreList.setVisibleRowCount(10);
        competenciasGenericasPiensaCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane67.setViewportView(competenciasGenericasPiensaCierreList);

        jPanel38.add(jScrollPane67);
        jScrollPane67.setBounds(0, 728, 920, 162);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel52.setText("Trabaja");
        jPanel38.add(jLabel52);
        jLabel52.setBounds(115, 890, 38, 16);

        competenciasGenericasTrabajaCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasGenericasTrabajaCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasGenericaseTrabaja();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasGenericasTrabajaCierreList.setValueIsAdjusting(true);
        competenciasGenericasTrabajaCierreList.setVisibleRowCount(10);
        competenciasGenericasTrabajaCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasGenericasTrabajaCierreListMouseExited(evt);
            }
        });
        jScrollPane68.setViewportView(competenciasGenericasTrabajaCierreList);

        jPanel38.add(jScrollPane68);
        jScrollPane68.setBounds(0, 906, 920, 162);

        jScrollPane62.setViewportView(jPanel38);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane62, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane62, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        competenciasCierreTabbedPane.addTab("Competencias Genericas", jPanel36);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        evidenciasDeAprendizajeCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        evidenciasDeAprendizajeCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarEvidenciasDeAprendizaje();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        evidenciasDeAprendizajeCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evidenciasDeAprendizajeCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evidenciasDeAprendizajeCierreListMouseExited(evt);
            }
        });
        jScrollPane25.setViewportView(evidenciasDeAprendizajeCierreList);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25)
                .addContainerGap())
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        instrumentosDeEvaluacionCierreList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        instrumentosDeEvaluacionCierreList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarInstrumentosDeEvaluacion();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        instrumentosDeEvaluacionCierreList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                instrumentosDeEvaluacionCierreListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                instrumentosDeEvaluacionCierreListMouseExited(evt);
            }
        });
        jScrollPane26.setViewportView(instrumentosDeEvaluacionCierreList);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setText("Evidencias");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText("Instrumentos de Evaluación");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel18)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasCierreTabbedPane.addTab("Evidencias / Instrumentos", jPanel25);

        principalTabbedPane.addTab("Competencias / Cierre", competenciasCierreTabbedPane);

        recursosMaterialesTextArea.setColumns(20);
        recursosMaterialesTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        recursosMaterialesTextArea.setRows(5);
        jScrollPane3.setViewportView(recursosMaterialesTextArea);

        recursosMaterialesLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        recursosMaterialesLabel.setText("Recursos Materiales");

        fuentesInformacionLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fuentesInformacionLabel.setText("Fuentes de Información");

        fuentesInformacionTextArea.setColumns(20);
        fuentesInformacionTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fuentesInformacionTextArea.setRows(5);
        jScrollPane4.setViewportView(fuentesInformacionTextArea);

        observacionesReflexionesTextArea.setColumns(20);
        observacionesReflexionesTextArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        observacionesReflexionesTextArea.setRows(5);
        jScrollPane5.setViewportView(observacionesReflexionesTextArea);

        observacionesReflexionesLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        observacionesReflexionesLabel.setText("Observaciones y/o Reflexiones");

        javax.swing.GroupLayout recursosPanelLayout = new javax.swing.GroupLayout(recursosPanel);
        recursosPanel.setLayout(recursosPanelLayout);
        recursosPanelLayout.setHorizontalGroup(
            recursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recursosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(recursosPanelLayout.createSequentialGroup()
                        .addGroup(recursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(observacionesReflexionesLabel)
                            .addComponent(fuentesInformacionLabel)
                            .addComponent(recursosMaterialesLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        recursosPanelLayout.setVerticalGroup(
            recursosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recursosPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(recursosMaterialesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fuentesInformacionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(observacionesReflexionesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        principalTabbedPane.addTab("Recursos", recursosPanel);

        siguienteButton.setText("Siguiente");
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(786, Short.MAX_VALUE)
                .addComponent(regresarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguienteButton)
                .addContainerGap())
            .addComponent(principalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siguienteButton)
                    .addComponent(regresarButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed

        switch (principalTabbedPane.getSelectedIndex()){
            case 0:
                principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                break;
            case 1:
                principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                break;
            case 2:
                if (competenciasInicioTabbedPane.getSelectedIndex() == 3){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasInicioTabbedPane.setSelectedIndex(competenciasInicioTabbedPane.getSelectedIndex() + 1);
                break;
            case 3:
                if (competenciasDesarolloTabbedPane.getSelectedIndex() == 3){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasDesarolloTabbedPane.setSelectedIndex(competenciasDesarolloTabbedPane.getSelectedIndex() + 1);
                break;
            case 4:
                if (competenciasCierreTabbedPane.getSelectedIndex() == 3){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasCierreTabbedPane.setSelectedIndex(competenciasCierreTabbedPane.getSelectedIndex() + 1);
                break;
            case 5:
                int lista[] = validarCampos();
                int desicion = 1;
                for (int i = 0; i < lista.length; i++){
                    if (lista[i] == -1){
                        desicion = -1;
                        break;
                    }
                }
                int valor = 0;
                if (desicion == -1){
                    valor = JOptionPane.showOptionDialog(this, "¿Estás seguro de que deseas continuar?", " ¡Campos Vacios!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Cancelar", "Si"}, "Cancelar");
                }

                if (valor == 1){
                    setearValores();
                    Lector lector = new Lector(contenidosAgregados, contenidosFijos, asignatura);
                    try{
                        lector.crearArchivo();
                    }catch (DocumentException | IOException ex){
                        Logger.getLogger(Rubrica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
            default:

        }

    }//GEN-LAST:event_siguienteButtonActionPerformed

    private void periodoEscolarClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_periodoEscolarClick
        if ("<Rellenar>".equals(periodoEscolarTextField.getText())){
            periodoEscolarTextField.setText("");
        }
    }//GEN-LAST:event_periodoEscolarClick

    private void numeroSecuenciaClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroSecuenciaClick
        if ("<Rellenar>".equals(numeroSecuenciaTextField.getText())){
            numeroSecuenciaTextField.setText("");
        }
    }//GEN-LAST:event_numeroSecuenciaClick

    private void numeroSesionClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroSesionClick
        if ("<Rellenar>".equals(numeroSesionesTextField.getText())){
            numeroSesionesTextField.setText("");
        }
    }//GEN-LAST:event_numeroSesionClick

    private void fechaInicioTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaInicioTextFieldMouseClicked
        if ("<Rellenar>".equals(fechaInicioTextField.getText())){
            fechaInicioTextField.setText("");
        }
    }//GEN-LAST:event_fechaInicioTextFieldMouseClicked

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed

        switch (principalTabbedPane.getSelectedIndex()){
            case 0:
                try{
                    new MenuRubrica(asignatura, contenidosAgregados, contenidosFijos).setVisible(true);
                }catch (IOException ex){
                    Logger.getLogger(MenuRubrica.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();

                break;
            case 1:
                principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() - 1);
                break;
            case 2:
                if (competenciasInicioTabbedPane.getSelectedIndex() == 0){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() - 1);
                    break;
                }
                competenciasInicioTabbedPane.setSelectedIndex(competenciasInicioTabbedPane.getSelectedIndex() - 1);
                break;
            case 3:
                if (competenciasDesarolloTabbedPane.getSelectedIndex() == 0){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() - 1);
                    break;
                }
                competenciasDesarolloTabbedPane.setSelectedIndex(competenciasDesarolloTabbedPane.getSelectedIndex() - 1);
                break;
            case 4:
                if (competenciasCierreTabbedPane.getSelectedIndex() == 0){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() - 1);
                    break;
                }
                competenciasCierreTabbedPane.setSelectedIndex(competenciasCierreTabbedPane.getSelectedIndex() - 1);
                break;
            case 5:
                principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() - 1);
                break;
            default:

        }
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void contenidoProcedimentalListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoProcedimentalListMouseEntered
        presionarControl();
    }//GEN-LAST:event_contenidoProcedimentalListMouseEntered

    private void contenidoProcedimentalListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoProcedimentalListMouseExited
        soltarControl();
    }//GEN-LAST:event_contenidoProcedimentalListMouseExited

    private void competenciasInicioEvidenciasListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasInicioEvidenciasListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasInicioEvidenciasListMouseEntered

    private void competenciasInicioEvidenciasListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasInicioEvidenciasListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasInicioEvidenciasListMouseExited

    private void competenciasInicioInstrumentosListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasInicioInstrumentosListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasInicioInstrumentosListMouseEntered

    private void competenciasInicioInstrumentosListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasInicioInstrumentosListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasInicioInstrumentosListMouseExited

    private void contenidoDeclarativoListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoDeclarativoListMouseExited
        soltarControl();
    }//GEN-LAST:event_contenidoDeclarativoListMouseExited

    private void contenidoDeclarativoListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoDeclarativoListMouseEntered
        presionarControl();
    }//GEN-LAST:event_contenidoDeclarativoListMouseEntered

    private void contenidoActitudinalListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoActitudinalListMouseExited
        soltarControl();
    }//GEN-LAST:event_contenidoActitudinalListMouseExited

    private void contenidoActitudinalListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenidoActitudinalListMouseEntered
        presionarControl();
    }//GEN-LAST:event_contenidoActitudinalListMouseEntered

    private void instrumentosDeEvaluacionCierreListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrumentosDeEvaluacionCierreListMouseExited
        soltarControl();
    }//GEN-LAST:event_instrumentosDeEvaluacionCierreListMouseExited

    private void instrumentosDeEvaluacionCierreListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrumentosDeEvaluacionCierreListMouseEntered
        presionarControl();
    }//GEN-LAST:event_instrumentosDeEvaluacionCierreListMouseEntered

    private void evidenciasDeAprendizajeCierreListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenciasDeAprendizajeCierreListMouseExited
        soltarControl();
    }//GEN-LAST:event_evidenciasDeAprendizajeCierreListMouseExited

    private void evidenciasDeAprendizajeCierreListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenciasDeAprendizajeCierreListMouseEntered
        presionarControl();
    }//GEN-LAST:event_evidenciasDeAprendizajeCierreListMouseEntered

    private void instrumentosDeEvaluacionDesarrolloListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrumentosDeEvaluacionDesarrolloListMouseExited
        soltarControl();
    }//GEN-LAST:event_instrumentosDeEvaluacionDesarrolloListMouseExited

    private void instrumentosDeEvaluacionDesarrolloListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrumentosDeEvaluacionDesarrolloListMouseEntered
        presionarControl();
    }//GEN-LAST:event_instrumentosDeEvaluacionDesarrolloListMouseEntered

    private void evidenciasDeAprendizajeDesarrolloListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenciasDeAprendizajeDesarrolloListMouseExited
        soltarControl();
    }//GEN-LAST:event_evidenciasDeAprendizajeDesarrolloListMouseExited

    private void evidenciasDeAprendizajeDesarrolloListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenciasDeAprendizajeDesarrolloListMouseEntered
        presionarControl();
    }//GEN-LAST:event_evidenciasDeAprendizajeDesarrolloListMouseEntered

    private void competenciasGenericasAprendeInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasAprendeInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasAprendeInicioListMouseEntered

    private void competenciasGenericasAprendeInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasAprendeInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasAprendeInicioListMouseExited

    private void competenciasGenericasAutodeterminaInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasAutodeterminaInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasAutodeterminaInicioListMouseEntered

    private void competenciasGenericasAutodeterminaInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasAutodeterminaInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasAutodeterminaInicioListMouseExited

    private void competenciasGenericasExpresaInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasExpresaInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasExpresaInicioListMouseEntered

    private void competenciasGenericasExpresaInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasExpresaInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasExpresaInicioListMouseExited

    private void competenciasGenericasParticipaInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasParticipaInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasParticipaInicioListMouseExited

    private void competenciasGenericasParticipaInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasParticipaInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasParticipaInicioListMouseEntered

    private void competenciasGenericasPiensaInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasPiensaInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasPiensaInicioListMouseEntered

    private void competenciasGenericasPiensaInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasPiensaInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasPiensaInicioListMouseExited

    private void competenciasGenericasTrabajaInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasTrabajaInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasTrabajaInicioListMouseEntered

    private void competenciasGenericasTrabajaInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasTrabajaInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasTrabajaInicioListMouseExited

    private void competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseEntered

    private void competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasDisciplinaresCienciasExperimentalesDesarrolloListMouseExited

    private void competenciasGenericasPiensaDesarrolloListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasPiensaDesarrolloListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasPiensaDesarrolloListMouseEntered

    private void competenciasGenericasPiensaDesarrolloListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasPiensaDesarrolloListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasPiensaDesarrolloListMouseExited

    private void competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasDisciplinaresCienciasExperimentalesCierreListMouseEntered

    private void competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasDisciplinaresCienciasExperimentalesCierreListMouseExited

    private void competenciasGenericasTrabajaCierreListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasTrabajaCierreListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasGenericasTrabajaCierreListMouseEntered

    private void competenciasGenericasTrabajaCierreListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasGenericasTrabajaCierreListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasGenericasTrabajaCierreListMouseExited

    private void CompetenciasDisciplinaresComunicacionInicioListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompetenciasDisciplinaresComunicacionInicioListMouseEntered
        presionarControl();
    }//GEN-LAST:event_CompetenciasDisciplinaresComunicacionInicioListMouseEntered

    private void CompetenciasDisciplinaresComunicacionInicioListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompetenciasDisciplinaresComunicacionInicioListMouseExited
        soltarControl();
    }//GEN-LAST:event_CompetenciasDisciplinaresComunicacionInicioListMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Rubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(() -> {
            new Rubrica(asignatura, contenidosAgregados, contenidosFijos).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> CompetenciasDisciplinaresCienciasExperimentalesInicioList;
    private javax.swing.JList<String> CompetenciasDisciplinaresCienciasSocialesInicioList;
    private javax.swing.JList<String> CompetenciasDisciplinaresComunicacionInicioList;
    private javax.swing.JList<String> CompetenciasDisciplinaresMatematicasInicioList;
    private javax.swing.JLabel asignaturaLabel;
    private javax.swing.JTextField asignaturaTextField;
    private javax.swing.JTextArea asignaturasRelacionadasTextArea;
    private javax.swing.JLabel bloqueLabel;
    private javax.swing.JTextField bloqueTextField;
    private javax.swing.JPanel cierrePanel;
    private javax.swing.JTabbedPane competenciasCierreTabbedPane;
    private javax.swing.JTabbedPane competenciasDesarolloTabbedPane;
    private javax.swing.JList<String> competenciasDisciplinaresCienciasExperimentalesCierreList;
    private javax.swing.JList<String> competenciasDisciplinaresCienciasExperimentalesDesarrolloList;
    private javax.swing.JList<String> competenciasDisciplinaresCienciasSocialesCierreList;
    private javax.swing.JList<String> competenciasDisciplinaresCienciasSocialesDesarrolloList;
    private javax.swing.JList<String> competenciasDisciplinaresComunicacionCierreList;
    private javax.swing.JList<String> competenciasDisciplinaresComunicacionDesarrolloList;
    private javax.swing.JList<String> competenciasDisciplinaresMatematicasCierreList;
    private javax.swing.JList<String> competenciasDisciplinaresMatematicasDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasAprendeCierreList;
    private javax.swing.JList<String> competenciasGenericasAprendeDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasAprendeInicioList;
    private javax.swing.JList<String> competenciasGenericasAutodeterminaCierreList;
    private javax.swing.JList<String> competenciasGenericasAutodeterminaDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasAutodeterminaInicioList;
    private javax.swing.JList<String> competenciasGenericasExpresaCierreList;
    private javax.swing.JList<String> competenciasGenericasExpresaDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasExpresaInicioList;
    private javax.swing.JList<String> competenciasGenericasParticipaCierreList;
    private javax.swing.JList<String> competenciasGenericasParticipaDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasParticipaInicioList;
    private javax.swing.JList<String> competenciasGenericasPiensaCierreList;
    private javax.swing.JList<String> competenciasGenericasPiensaDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasPiensaInicioList;
    private javax.swing.JList<String> competenciasGenericasTrabajaCierreList;
    private javax.swing.JList<String> competenciasGenericasTrabajaDesarrolloList;
    private javax.swing.JList<String> competenciasGenericasTrabajaInicioList;
    private javax.swing.JList<String> competenciasInicioEvidenciasList;
    private javax.swing.JList<String> competenciasInicioInstrumentosList;
    private javax.swing.JTabbedPane competenciasInicioTabbedPane;
    private javax.swing.JLabel contenidoActitudinalLabel;
    private javax.swing.JList<String> contenidoActitudinalList;
    private javax.swing.JPanel contenidoActitudinalPanel;
    private javax.swing.JLabel contenidoDeclarativoLabel;
    private javax.swing.JList<String> contenidoDeclarativoList;
    private javax.swing.JPanel contenidoDeclarativoPanel;
    private javax.swing.JPanel contenidoPanel;
    private javax.swing.JLabel contenidoProcedimentalLabel;
    private javax.swing.JList<String> contenidoProcedimentalList;
    private javax.swing.JPanel contenidoProcedimentalPanel;
    private javax.swing.JTextArea contenidosGeneralesAprendizajeCierreTextArea;
    private javax.swing.JTextArea contenidosGeneralesAprendizajeDesarolloTextArea;
    private javax.swing.JTextArea contenidosGeneralesAprendizajeInicioTextArea;
    private javax.swing.JTextArea contenidosGeneralesEnsenianzaCierreTextArea;
    private javax.swing.JTextArea contenidosGeneralesEnsenianzaDesarolloTextArea;
    private javax.swing.JTextArea contenidosGeneralesEnsenianzaInicioTextArea;
    private javax.swing.JPanel desarolloPanel;
    private javax.swing.JLabel docenteLabel;
    private javax.swing.JTextField docenteTextField;
    private javax.swing.border.EmptyBorder emptyBorder1;
    private javax.swing.JList<String> evidenciasDeAprendizajeCierreList;
    private javax.swing.JList<String> evidenciasDeAprendizajeDesarrolloList;
    private javax.swing.JLabel fechaInicioLabel;
    private javax.swing.JTextField fechaInicioTextField;
    private javax.swing.JLabel fuentesInformacionLabel;
    private javax.swing.JTextArea fuentesInformacionTextArea;
    private javax.swing.JPanel inicioPanel;
    private javax.swing.JList<String> instrumentosDeEvaluacionCierreList;
    private javax.swing.JList<String> instrumentosDeEvaluacionDesarrolloList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane56;
    private javax.swing.JScrollPane jScrollPane57;
    private javax.swing.JScrollPane jScrollPane58;
    private javax.swing.JScrollPane jScrollPane59;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane60;
    private javax.swing.JScrollPane jScrollPane61;
    private javax.swing.JScrollPane jScrollPane62;
    private javax.swing.JScrollPane jScrollPane63;
    private javax.swing.JScrollPane jScrollPane64;
    private javax.swing.JScrollPane jScrollPane65;
    private javax.swing.JScrollPane jScrollPane66;
    private javax.swing.JScrollPane jScrollPane67;
    private javax.swing.JScrollPane jScrollPane68;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numeroSecuenciaLabel;
    private javax.swing.JTextField numeroSecuenciaTextField;
    private javax.swing.JLabel numeroSesionesLabel;
    private javax.swing.JTextField numeroSesionesTextField;
    private javax.swing.JLabel observacionesReflexionesLabel;
    private javax.swing.JTextArea observacionesReflexionesTextArea;
    private javax.swing.JLabel otrasMateriasRelacionLabel;
    private javax.swing.JLabel periodoEscolarLabel;
    private javax.swing.JTextField periodoEscolarTextField;
    private javax.swing.JTabbedPane principalTabbedPane;
    private javax.swing.JLabel propositoSecuenciaLabel;
    private javax.swing.JTextArea propositoSecuenciaTextArea;
    private javax.swing.JLabel recursosMaterialesLabel;
    private javax.swing.JTextArea recursosMaterialesTextArea;
    private javax.swing.JPanel recursosPanel;
    private javax.swing.JButton regresarButton;
    private javax.swing.JLabel semestreLabel;
    private javax.swing.JTextField semestreTextField;
    private javax.swing.JButton siguienteButton;
    // End of variables declaration//GEN-END:variables

}
