package Interfaz;

import Fachada.*;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

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

    private void setearValores(){
        ArrayList contenidosDeclarativos, contenidosProcedimentales, contenidosActitudinales;

        contenidosAgregados.setPeriodoEscolar(periodoEscolarTextField.getText());
        contenidosAgregados.setNumeroSecuencia(Integer.parseInt(numeroSecuenciaTextField.getText()));
        contenidosAgregados.setNumeroSesiones(Integer.parseInt(numeroSesionesTextField.getText()));
        contenidosAgregados.setFechaInicio(fechaInicioTextField.getText());
        contenidosAgregados.setPropositoSecuencia(propositoSecuenciaTextArea.getText());
        contenidosAgregados.setAsignaturasRelacionadas(asignaturasRelacionadasTextArea.getText());

        //Segunda Ventana
        contenidosFijos.setContenidosDeclarativos(pasarArray(contenidoDeclarativoList.getSelectedIndices()));
        contenidosFijos.setContenidosProcedimentales(pasarArray(contenidoProcedimentalList.getSelectedIndices()));
        contenidosFijos.setContenidosActitudinales(pasarArray(contenidoActitudinalList.getSelectedIndices()));
        //Tercera Ventana (Inicio)
        contenidosAgregados.setContenidosGeneralesEnsenianzaInicio(contenidosGeneralesEnsenianzaInicioTextArea.getText());
        contenidosAgregados.setContenidosGeneralesAprendizajeInicio(contenidosGeneralesAprendizajeInicioTextArea.getText());
        ////Competencias
/*        contenidosFijos.setCompetenciasGenericasAprendeInicio(pasarArray(competenciasGenericasAprendeInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasGenericasAutodeterminaInicio(pasarArray(competenciasGenericasAutodeterminaInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasGenericasExpresaInicio(pasarArray(CompetenciasGenericasExpresaInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasGenericasParticipaInicio(pasarArray(CompetenciasGenericasParticipaInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasGenericasPiensaInicio(pasarArray(CompetenciasGenericasPiensaInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasGenericasTrabajaInicio(pasarArray(CompetenciasGenericasTrabajaInicioList.getSelectedIndices()));
        //-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<
        contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesInicio(pasarArray(CompetenciasDisciplinaresCienciasExperimentalesInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesInicio(pasarArray(CompetenciasDisciplinaresCienciasSocialesInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasDisciplinaresComunicacionInicio(pasarArray(CompetenciasDisciplinaresComunicacionInicioList.getSelectedIndices()));
        contenidosFijos.setCompetenciasDisciplinaresMatematicasInicio(pasarArray(CompetenciasDisciplinaresMatematicasInicioList.getSelectedIndices()));
        ////Evidencias
        contenidosFijos.setEvidenciasDeAprendizajeInicio(pasarArray(competenciasInicioEvidenciasList.getSelectedIndices()));
        contenidosFijos.setInstrumentosDeEvaluacionInicio(pasarArray(competenciasInicioInstrumentosList.getSelectedIndices()));
        /*
         * //Cuarta Ventana (Desarollo)
         * contenidosAgregados.setContenidosGeneralesEnsenianzaDesarrollo(contenidosGeneralesEnsenianzaDesarolloTextArea.getText());
         * contenidosAgregados.setContenidosGeneralesAprendizajeDesarrollo(contenidosGeneralesAprendizajeDesarolloTextArea.getText());
         * ////Competencias
         * contenidosFijos.setCompetenciasGenericasAprendeDesarrollo();
         * contenidosFijos.setCompetenciasGenericasAutodeterminaDesarrollo();
         * contenidosFijos.setCompetenciasGenericasExpresaDesarrollo();
         * contenidosFijos.setCompetenciasGenericasParticipaDesarrollo();
         * contenidosFijos.setCompetenciasGenericasTrabajaDesarrollo();
         * //-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<
         * contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesDesarrollo();
         * contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesDesarrollo();
         * contenidosFijos.setCompetenciasDisciplinaresComunicacionDesarrollo();
         * contenidosFijos.setCompetenciasDisciplinaresMatematicasDesarrollo();
         * ////Evidencias
         * contenidosFijos.setEvidenciasDeAprendizajeDesarrollo();
         * contenidosFijos.setInstrumentosDeEvaluacionDesarrollo(); //Quinta
         * Ventana (Cierre)
         * contenidosAgregados.setContenidosGeneralesEnsenianzaCierre(contenidosGeneralesEnsenianzaCierreTextArea.getText());
         * contenidosAgregados.setContenidosGeneralesAprendizajeCierre(contenidosGeneralesAprendizajeCierreTextArea.getText());
         * ////Competencias
         * contenidosFijos.setCompetenciasGenericasAprendeCierre();
         * contenidosFijos.setCompetenciasGenericasAutodeterminaCierre();
         * contenidosFijos.setCompetenciasGenericasExpresaCierre();
         * contenidosFijos.setCompetenciasGenericasParticipaCierre();
         * contenidosFijos.setCompetenciasGenericasTrabajaCierre();
         * //-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<
         * contenidosFijos.setCompetenciasDisciplinaresCienciasExperimentalesCierre();
         * contenidosFijos.setCompetenciasDisciplinaresCienciasSocialesCierre();
         * contenidosFijos.setCompetenciasDisciplinaresComunicacionCierre();
         * contenidosFijos.setCompetenciasDisciplinaresMatematicasCierre();
         * ////Evidencias contenidosFijos.setEvidenciasDeAprendizajeCierre();
         * contenidosFijos.setInstrumentosDeEvaluacionCierre();
         */
        //Sexta Ventana
        contenidosAgregados.setRecursosMateriales(recursosMaterialesTextArea.getText());
        contenidosAgregados.setFuentesInformacion(fuentesInformacionTextArea.getText());
        contenidosAgregados.setObservaciones(observacionesReflexionesTextArea.getText());
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

    /**
     * Creates new form Rubrica
     *
     * @param asignatura
     * @param contenidosAgregados
     * @param contenidosFijos
     */
    public Rubrica(Asignatura asignatura, ContenidosAgregados contenidosAgregados, ContenidosFijos contenidosFijos){
        Rubrica.contenidosFijos = contenidosFijos;
        Rubrica.contenidosAgregados = contenidosAgregados;
        Rubrica.asignatura = asignatura;
        contenidosFijos.setAsignatura(asignatura);
        initComponents();
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
        contenidoProcedimentalList.setFixedCellWidth(-1);
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
        jScrollPane28 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresCienciasExperimentalesInicioList = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresCienciasSocialesInicioList = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresComunicacionInicioList = new javax.swing.JList<>();
        jScrollPane31 = new javax.swing.JScrollPane();
        CompetenciasDisciplinaresMatematicasInicioList = new javax.swing.JList<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        competenciasDesarolloEvidenciasList = new javax.swing.JList<>();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        competenciasDesarolloInstrumentosList = new javax.swing.JList<>();
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
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        competenciasCierreEvidenciasList = new javax.swing.JList<>();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        competenciasCierreIntrumentosList1 = new javax.swing.JList<>();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
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

        contenidoDeclarativoList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoDeclarativoList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosDeclarativos();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoDeclarativoList.setAutoscrolls(false);
        contenidoDeclarativoList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoDeclarativoListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoDeclarativoListMouseExited(evt);
            }
        });
        jScrollPane6.setViewportView(contenidoDeclarativoList);

        javax.swing.GroupLayout contenidoDeclarativoPanelLayout = new javax.swing.GroupLayout(contenidoDeclarativoPanel);
        contenidoDeclarativoPanel.setLayout(contenidoDeclarativoPanelLayout);
        contenidoDeclarativoPanelLayout.setHorizontalGroup(
            contenidoDeclarativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoDeclarativoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        contenidoDeclarativoPanelLayout.setVerticalGroup(
            contenidoDeclarativoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoDeclarativoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        contenidoProcedimentalPanel.setBackground(new java.awt.Color(255, 255, 255));
        contenidoProcedimentalPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        contenidoProcedimentalList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoProcedimentalList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosProcedimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoProcedimentalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoProcedimentalListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoProcedimentalListMouseExited(evt);
            }
        });
        jScrollPane7.setViewportView(contenidoProcedimentalList);

        javax.swing.GroupLayout contenidoProcedimentalPanelLayout = new javax.swing.GroupLayout(contenidoProcedimentalPanel);
        contenidoProcedimentalPanel.setLayout(contenidoProcedimentalPanelLayout);
        contenidoProcedimentalPanelLayout.setHorizontalGroup(
            contenidoProcedimentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoProcedimentalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenidoProcedimentalPanelLayout.setVerticalGroup(
            contenidoProcedimentalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoProcedimentalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        contenidoActitudinalPanel.setBackground(new java.awt.Color(255, 255, 255));
        contenidoActitudinalPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contenidoActitudinalList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenidoActitudinalList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarContenidosActitudinales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        contenidoActitudinalList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contenidoActitudinalListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contenidoActitudinalListMouseExited(evt);
            }
        });
        jScrollPane9.setViewportView(contenidoActitudinalList);

        javax.swing.GroupLayout contenidoActitudinalPanelLayout = new javax.swing.GroupLayout(contenidoActitudinalPanel);
        contenidoActitudinalPanel.setLayout(contenidoActitudinalPanelLayout);
        contenidoActitudinalPanelLayout.setHorizontalGroup(
            contenidoActitudinalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoActitudinalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
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
                .addGap(30, 30, 30)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoDeclarativoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenidoDeclarativoLabel))
                .addGap(36, 36, 36)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoProcedimentalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenidoProcedimentalLabel))
                .addGap(40, 40, 40)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoActitudinalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addComponent(contenidoActitudinalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        contenidoPanelLayout.setVerticalGroup(
            contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contenidoDeclarativoLabel)
                    .addComponent(contenidoProcedimentalLabel)
                    .addComponent(contenidoActitudinalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenidoActitudinalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenidoDeclarativoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenidoProcedimentalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        competenciasInicioTabbedPane.addTab("Inicio", inicioPanel);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane27.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane27.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setMaximumSize(new java.awt.Dimension(78, 1000));
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setMinimumSize(new java.awt.Dimension(578, 0));
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setName(""); // NOI18N
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setValueIsAdjusting(true);
        CompetenciasDisciplinaresCienciasExperimentalesInicioList.setVisibleRowCount(contenidosFijos.listarCompetenciasDisciplinaresCienciasExperimentales().size());
        jScrollPane28.setViewportView(CompetenciasDisciplinaresCienciasExperimentalesInicioList);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setText("Ciencias Sociales");

        CompetenciasDisciplinaresCienciasSocialesInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresCienciasSocialesInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresCienciasSociales();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresCienciasSocialesInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresCienciasSocialesInicioList.setVisibleRowCount(200);
        jScrollPane29.setViewportView(CompetenciasDisciplinaresCienciasSocialesInicioList);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Comunicación");

        CompetenciasDisciplinaresComunicacionInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresComunicacionInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresComunicaciones();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresComunicacionInicioList.setAutoscrolls(false);
        CompetenciasDisciplinaresComunicacionInicioList.setVisibleRowCount(200);
        jScrollPane15.setViewportView(CompetenciasDisciplinaresComunicacionInicioList);

        CompetenciasDisciplinaresMatematicasInicioList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CompetenciasDisciplinaresMatematicasInicioList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarCompetenciasDisciplinaresMatematicas();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        CompetenciasDisciplinaresMatematicasInicioList.setVisibleRowCount(200);
        jScrollPane31.setViewportView(CompetenciasDisciplinaresMatematicasInicioList);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setText("Matemáticas");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setText("Ciencias Experimentales");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane27.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Disiplinares");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Genéricas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasInicioTabbedPane.addTab("Competencias", jPanel5);

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
                .addComponent(jScrollPane17)
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
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
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
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        competenciasDesarolloTabbedPane.setBackground(new java.awt.Color(238, 238, 238));
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
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        competenciasDesarolloTabbedPane.addTab("Desarollo", desarolloPanel);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane16.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane16.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16)
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Disiplinares");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Genéricas");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasDesarolloTabbedPane.addTab("Competencias", jPanel16);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        competenciasDesarolloEvidenciasList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDesarolloEvidenciasList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarEvidenciasDeAprendizaje();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDesarolloEvidenciasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDesarolloEvidenciasListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDesarolloEvidenciasListMouseExited(evt);
            }
        });
        jScrollPane21.setViewportView(competenciasDesarolloEvidenciasList);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
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

        competenciasDesarolloInstrumentosList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasDesarolloInstrumentosList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarInstrumentosDeEvaluacion();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasDesarolloInstrumentosList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasDesarolloInstrumentosListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasDesarolloInstrumentosListMouseExited(evt);
            }
        });
        jScrollPane22.setViewportView(competenciasDesarolloInstrumentosList);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasDesarolloTabbedPane.addTab("Evidencias / Instrumentos", jPanel19);

        principalTabbedPane.addTab("Competencias / Desarollo", competenciasDesarolloTabbedPane);

        competenciasCierreTabbedPane.setBackground(new java.awt.Color(238, 238, 238));
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
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        competenciasCierreTabbedPane.addTab("Cierre", cierrePanel);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Disiplinares");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Genéricas");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        competenciasCierreTabbedPane.addTab("Competencias", jPanel22);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        competenciasCierreEvidenciasList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasCierreEvidenciasList.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarEvidenciasDeAprendizaje();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasCierreEvidenciasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasCierreEvidenciasListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasCierreEvidenciasListMouseExited(evt);
            }
        });
        jScrollPane25.setViewportView(competenciasCierreEvidenciasList);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
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

        competenciasCierreIntrumentosList1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        competenciasCierreIntrumentosList1.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = contenidosFijos.listarInstrumentosDeEvaluacion();
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        competenciasCierreIntrumentosList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                competenciasCierreIntrumentosList1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                competenciasCierreIntrumentosList1MouseExited(evt);
            }
        });
        jScrollPane26.setViewportView(competenciasCierreIntrumentosList1);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
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
                .addContainerGap(38, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siguienteButton)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(principalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
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
                if (competenciasInicioTabbedPane.getSelectedIndex() == 2){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasInicioTabbedPane.setSelectedIndex(competenciasInicioTabbedPane.getSelectedIndex() + 1);
                break;
            case 3:
                if (competenciasDesarolloTabbedPane.getSelectedIndex() == 2){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasDesarolloTabbedPane.setSelectedIndex(competenciasDesarolloTabbedPane.getSelectedIndex() + 1);
                break;
            case 4:
                if (competenciasCierreTabbedPane.getSelectedIndex() == 2){
                    principalTabbedPane.setSelectedIndex(principalTabbedPane.getSelectedIndex() + 1);
                    break;
                }
                competenciasCierreTabbedPane.setSelectedIndex(competenciasCierreTabbedPane.getSelectedIndex() + 1);
                break;
            case 5:
                setearValores();
                Confirmar confirmar = new Confirmar(this, rootPaneCheckingEnabled);
                confirmar.setVisible(true);
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

    private void competenciasDesarolloEvidenciasListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDesarolloEvidenciasListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasDesarolloEvidenciasListMouseEntered

    private void competenciasDesarolloEvidenciasListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDesarolloEvidenciasListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasDesarolloEvidenciasListMouseExited

    private void competenciasDesarolloInstrumentosListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDesarolloInstrumentosListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasDesarolloInstrumentosListMouseEntered

    private void competenciasDesarolloInstrumentosListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasDesarolloInstrumentosListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasDesarolloInstrumentosListMouseExited

    private void competenciasCierreEvidenciasListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasCierreEvidenciasListMouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasCierreEvidenciasListMouseEntered

    private void competenciasCierreEvidenciasListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasCierreEvidenciasListMouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasCierreEvidenciasListMouseExited

    private void competenciasCierreIntrumentosList1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasCierreIntrumentosList1MouseEntered
        presionarControl();
    }//GEN-LAST:event_competenciasCierreIntrumentosList1MouseEntered

    private void competenciasCierreIntrumentosList1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competenciasCierreIntrumentosList1MouseExited
        soltarControl();
    }//GEN-LAST:event_competenciasCierreIntrumentosList1MouseExited

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
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new Rubrica(asignatura, contenidosAgregados, contenidosFijos).setVisible(true);
            }

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
    private javax.swing.JList<String> competenciasCierreEvidenciasList;
    private javax.swing.JList<String> competenciasCierreIntrumentosList1;
    private javax.swing.JTabbedPane competenciasCierreTabbedPane;
    private javax.swing.JList<String> competenciasDesarolloEvidenciasList;
    private javax.swing.JList<String> competenciasDesarolloInstrumentosList;
    private javax.swing.JTabbedPane competenciasDesarolloTabbedPane;
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
    private javax.swing.JLabel fechaInicioLabel;
    private javax.swing.JTextField fechaInicioTextField;
    private javax.swing.JLabel fuentesInformacionLabel;
    private javax.swing.JTextArea fuentesInformacionTextArea;
    private javax.swing.JPanel inicioPanel;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
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
