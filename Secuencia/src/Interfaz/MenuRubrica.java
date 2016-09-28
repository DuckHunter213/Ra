package Interfaz;

import Fachada.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Luis Fernando
 */
public class MenuRubrica extends javax.swing.JFrame{
    private static Asignatura asignatura;
    private static ContenidosAgregados contenidosAgregados;
    private static ContenidosFijos contenidosFijos;
    ArrayList<String> listarAsignaturas;
    ArrayList<String> listarSemestres;
    ArrayList<String> listarBloques;

    /**
     * Creates new form Menu
     *
     * @param asignatura
     * @param contenidosAgregados
     * @param contenidosFijos
     * @throws java.io.IOException
     */
    public MenuRubrica(Asignatura asignatura, ContenidosAgregados contenidosAgregados, ContenidosFijos contenidosFijos) throws IOException{
        this.asignatura = asignatura;
        this.contenidosAgregados = contenidosAgregados;
        this.contenidosFijos = contenidosFijos;
        listarAsignaturas = asignatura.listarAsignaturas();
        listarAsignaturas.add(0, "<Selecionar>");
        listarSemestres = asignatura.listarSemestres();
        listarBloques = asignatura.listarBloques();
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

        semestreLabel = new javax.swing.JLabel();
        bloqueLabel = new javax.swing.JLabel();
        asignaturaLabel = new javax.swing.JLabel();
        docenteLabel = new javax.swing.JLabel();
        semestreComboBox = new javax.swing.JComboBox<>();
        bloqueComboBox = new javax.swing.JComboBox<>();
        asignaturaComboBox = new javax.swing.JComboBox<>();
        docenteTextField = new javax.swing.JTextField();
        iniciarRubricaButton = new javax.swing.JButton();
        subtituloLabel = new javax.swing.JLabel();
        botoneraSeparator = new javax.swing.JSeparator();
        instruccionesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        semestreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        semestreLabel.setText("Semestre");

        bloqueLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bloqueLabel.setText("Bloque");

        asignaturaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        asignaturaLabel.setText("Asignatura");

        docenteLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        docenteLabel.setText("Docente");

        semestreComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        semestreComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambioEstadoSemestre(evt);
            }
        });

        bloqueComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bloqueComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambioItemBloque(evt);
            }
        });

        asignaturaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        asignaturaComboBox.setModel(new DefaultComboBoxModel(listarAsignaturas.toArray()));
        asignaturaComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cambioEstadoAsignatura(evt);
            }
        });

        docenteTextField.setEditable(false);
        docenteTextField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        docenteTextField.setText("José Manuel Ojeda Pereda");
        docenteTextField.setToolTipText("");

        iniciarRubricaButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        iniciarRubricaButton.setText("Iniciar Rúbrica");
        iniciarRubricaButton.setEnabled(false);
        iniciarRubricaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarRubricaButtonMouseClicked(evt);
            }
        });

        subtituloLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        subtituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtituloLabel.setText("Sistema de Secuencias");

        instruccionesLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        instruccionesLabel.setText("Primero Elija la Asignatura Para Listar Semestres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iniciarRubricaButton)
                .addContainerGap())
            .addComponent(botoneraSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subtituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asignaturaLabel)
                            .addComponent(bloqueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(semestreLabel)
                                        .addComponent(asignaturaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(semestreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bloqueLabel))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(instruccionesLabel)
                                    .addComponent(docenteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(docenteLabel))))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subtituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asignaturaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(asignaturaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(semestreLabel)
                            .addComponent(docenteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(semestreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloqueLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bloqueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(docenteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(botoneraSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(iniciarRubricaButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instruccionesLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void validar(){
        if (asignaturaComboBox.getSelectedIndex() != 0){
            if (semestreComboBox.getSelectedIndex() != 0){
                if (bloqueComboBox.getSelectedIndex() != 0){
                    iniciarRubricaButton.setEnabled(true);
                }else{
                    iniciarRubricaButton.setEnabled(false);
                }
            }else{
                iniciarRubricaButton.setEnabled(false);
            }
        }else{
            iniciarRubricaButton.setEnabled(false);
        }
    }

    private void iniciarRubricaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarRubricaButtonMouseClicked
        if (iniciarRubricaButton.isEnabled()){
            asignatura.setNombreCompletoMaestro(docenteTextField.getText());
            Rubrica rubrica = new Rubrica(asignatura, contenidosAgregados, contenidosFijos);
            rubrica.setVisible(true);
            rubrica.setResizable(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_iniciarRubricaButtonMouseClicked

    private void cambioEstadoAsignatura(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambioEstadoAsignatura
        asignatura.setAsignatura((String) (asignaturaComboBox.getSelectedItem()));
        listarSemestres = asignatura.listarSemestres();
        listarSemestres.add(0, "<Selecionar>");
        listarBloques = new ArrayList<>();
        listarBloques.add(0, "<Selecionar>");
        semestreComboBox.setModel(new DefaultComboBoxModel(listarSemestres.toArray()));
        bloqueComboBox.setModel(new DefaultComboBoxModel(listarBloques.toArray()));
        validar();
    }//GEN-LAST:event_cambioEstadoAsignatura

    private void cambioEstadoSemestre(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambioEstadoSemestre
        try{
            asignatura.setSemestre(Integer.valueOf((String) semestreComboBox.getSelectedItem()));
        }catch(NumberFormatException e){
            asignatura.setSemestre(0);
        }
        
        listarBloques = asignatura.listarBloques();
        listarBloques.add(0, "<Selecionar>");
        bloqueComboBox.setModel(new DefaultComboBoxModel(listarBloques.toArray()));
        validar();
    }//GEN-LAST:event_cambioEstadoSemestre

    private void cambioItemBloque(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cambioItemBloque
        asignatura.setBloque((String) bloqueComboBox.getSelectedItem());
        validar();
    }//GEN-LAST:event_cambioItemBloque

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
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(MenuRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(MenuRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(MenuRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(MenuRubrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(() -> {
            try{
                new MenuRubrica(asignatura, contenidosAgregados, contenidosFijos).setVisible(true);
            }catch (IOException ex){
                Logger.getLogger(MenuRubrica.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> asignaturaComboBox;
    private javax.swing.JLabel asignaturaLabel;
    private javax.swing.JComboBox<String> bloqueComboBox;
    private javax.swing.JLabel bloqueLabel;
    private javax.swing.JSeparator botoneraSeparator;
    private javax.swing.JLabel docenteLabel;
    private javax.swing.JTextField docenteTextField;
    private javax.swing.JButton iniciarRubricaButton;
    private javax.swing.JLabel instruccionesLabel;
    private volatile javax.swing.JComboBox<String> semestreComboBox;
    private javax.swing.JLabel semestreLabel;
    private javax.swing.JLabel subtituloLabel;
    // End of variables declaration//GEN-END:variables
}
