/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concatwfm;

import Classes.*;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luciano.benfica
 */
public class JFFuncionariosCargos extends javax.swing.JDialog {

    /**
     * Creates new form JFFuncionariosCargos
     */
    public JFFuncionariosCargos() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomejLabel = new javax.swing.JLabel();
        matriculajLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cargojComboBox = new javax.swing.JComboBox();
        cadastroCargosjButton = new javax.swing.JButton();
        alterarCargojButton = new javax.swing.JButton();
        dataFimjLabel = new javax.swing.JLabel();
        escolhaDatajCheckBox = new javax.swing.JCheckBox();
        dataNovoCargojDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeFuncStatusjTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nome:");

        jLabel2.setText("Matrícula:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matriculajLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(matriculajLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nomejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Cargo");

        cargojComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargojComboBoxActionPerformed(evt);
            }
        });

        cadastroCargosjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add_small.png"))); // NOI18N
        cadastroCargosjButton.setToolTipText("Cadastro de cargos");
        cadastroCargosjButton.setContentAreaFilled(false);
        cadastroCargosjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastroCargosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroCargosjButtonActionPerformed(evt);
            }
        });

        alterarCargojButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/save2.png"))); // NOI18N
        alterarCargojButton.setText("Alterar cargo");
        alterarCargojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarCargojButtonActionPerformed(evt);
            }
        });

        dataFimjLabel.setText("Data do novo cargo");

        escolhaDatajCheckBox.setText("Usar data presonalizada");
        escolhaDatajCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolhaDatajCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cargojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cadastroCargosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataFimjLabel)
                                    .addComponent(dataNovoCargojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(escolhaDatajCheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alterarCargojButton)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastroCargosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(alterarCargojButton)))
                .addGap(12, 12, 12)
                .addComponent(dataFimjLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escolhaDatajCheckBox)
                    .addComponent(dataNovoCargojDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alterar Cargo", jPanel2);

        gradeFuncStatusjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data início", "Data Fim", "Matrícula", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeFuncStatusjTable.getTableHeader().setReorderingAllowed(false);
        gradeFuncStatusjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeFuncStatusjTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeFuncStatusjTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ClassConecta conecta = new ClassConecta();
    int recebe_matricula;
    String recebe_nome;
    int contador;
    private String data_atual;
    private ComboItem combo_func_carg;
    private String data_admissao;
    private String data_final;
    private String data_calcular;
    private String to_date;

    public void getGrandeFuncionariosCargos() throws ParseException {
        //Consultar Cargos
        FuncionarioCargos oFuncCargo = new FuncionarioCargos();


        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Data início", "Data Fim", "Matrícula", "Status"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeFuncStatusjTable.setModel(modeloTabela);
        gradeFuncStatusjTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        gradeFuncStatusjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        gradeFuncStatusjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        gradeFuncStatusjTable.getColumnModel().getColumn(3).setPreferredWidth(50);

        try {

            oFuncCargo.setMatricula(recebe_matricula);
            resultSet = oFuncCargo.getConsultar();

            if (resultSet.getRow() == 1) {
                resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                Date FROM_DATE = resultSet.getDate("FROM_DATE");
                String data_from = null;
                if (FROM_DATE != null) {
                    SimpleDateFormat formatoDataLanc = new SimpleDateFormat("dd/MM/yyyy");
                    data_from = formatoDataLanc.format(FROM_DATE);
                }


                Date TO_DATE = resultSet.getDate("TO_DATE");
                String data_to = null;
                String verifica = null;
                if (TO_DATE != null) {
                    SimpleDateFormat formatoDataLanc = new SimpleDateFormat("dd/MM/yyyy");
                    data_to = formatoDataLanc.format(TO_DATE);

                    if (data_to.equals("30/12/9999")) {
                        verifica = "Até o momento";
                    } else {
                        verifica = data_to;
                    }

                }

                modeloTabela.addRow(new String[]{
                            //                            resultSet.getString("FROM_DATE"),
                            data_from,
                            verifica,
                            resultSet.getString("MATRICULA"),
                            resultSet.getString("CARGO_NAME")
                        });

            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getFieldFuncionarioCargo(String to_date) throws ParseException {

        FuncionarioCargos oFuncCargo = new FuncionarioCargos();
        ResultSet rs;
        oFuncCargo.setMatricula(recebe_matricula);
        oFuncCargo.setTo_date_pesquisa(Funcoes.getDataFormatBR(to_date));

        try {
            rs = oFuncCargo.getConsultar();
            rs.next();

            //Pegar campos
            dataNovoCargojDateChooser.setDateFormatString(Funcoes.getDataFormat(rs.getDate("FROM_DATE")));
            System.out.println(Funcoes.getDataFormat(rs.getDate("FROM_DATE")));
            
            dataNovoCargojDateChooser.setDate(rs.getDate("FROM_DATE"));


        } catch (SQLException ex) {
            Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getConsultarGrade() {

        try {
            getGrandeFuncionariosCargos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a grade.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void getConsultarDataAdmissao() {

        Funcionarios oFunc = new Funcionarios();

        ResultSet rs;
        oFunc.setMatricula(recebe_matricula);
        try {
            rs = oFunc.getConsultar();
            while (rs.next()) {

                data_admissao = Funcoes.getDataFormat(rs.getDate("HIREDATE"));
            }

        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar data de admissão.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consutaComboCargos() {

        CadastroCargos oCadCargo = new CadastroCargos();

        ResultSet rs;

        try {
            rs = oCadCargo.getConsultar();
            cargojComboBox.removeAllItems();

            while (rs.next()) {

                cargojComboBox.addItem(new ComboItem(rs.getInt(1), rs.getString(2)));
            }
            cargojComboBox.updateUI();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao apreencher o combo cargos..\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void contadorGrade() {

        contador = gradeFuncStatusjTable.getRowCount();

    }

    public void calculaData() throws ParseException {

        Calendar c = Calendar.getInstance();
        c.setTime(Funcoes.getDataFormatBR(data_calcular));
        c.add(Calendar.DATE, -1);

        data_final = Funcoes.getDataFormat(c.getTime());
    }

    private void updateStatus() {

        FuncionarioCargos oFuncCargo = new FuncionarioCargos();

        try {

            if (escolhaDatajCheckBox.isSelected()) {

                SimpleDateFormat oDatOut = new SimpleDateFormat("dd/MM/yyyy");
                data_calcular = oDatOut.format(dataNovoCargojDateChooser.getDate());

                calculaData();
            } else {

                data_calcular = data_atual;
                calculaData();
            }


            if (cargojComboBox.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Atenção.\nÉ obrigatório selecionar um cargo.", "Mensagem do sistema", JOptionPane.WARNING_MESSAGE);
            } else {


                oFuncCargo.setUpdate_from_date(Funcoes.getDataFormatBR("30/12/9999"));
                oFuncCargo.setTo_date(Funcoes.getDataFormatBR(data_final));
                oFuncCargo.setMatricula(recebe_matricula);
                oFuncCargo.setAlterar(conecta);
            }

        } catch (ParseException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados.\n" + e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        nomejLabel.setText(recebe_nome);
        matriculajLabel.setText(Integer.toString(recebe_matricula));

        dataFimjLabel.setEnabled(false);
        dataNovoCargojDateChooser.setEnabled(false);

        alterarCargojButton.setEnabled(false);

        try {
            ClassConecta.conecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão com o banco de dados.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        try {
            data_atual = Funcoes.getNowBR();
        } catch (Exception e) {
        }

        consutaComboCargos();
        contadorGrade();
        getConsultarDataAdmissao();
        getConsultarGrade();
    }//GEN-LAST:event_formWindowOpened

    private void escolhaDatajCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolhaDatajCheckBoxActionPerformed
        // TODO add your handling code here:
        if (escolhaDatajCheckBox.isSelected()) {
            dataNovoCargojDateChooser.setEnabled(true);
            dataFimjLabel.setEnabled(true);
            dataNovoCargojDateChooser.grabFocus();
        } else {
            dataNovoCargojDateChooser.setEnabled(false);
            dataFimjLabel.setEnabled(false);
            dataNovoCargojDateChooser.setDate(null);
        }
    }//GEN-LAST:event_escolhaDatajCheckBoxActionPerformed

    private void cadastroCargosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroCargosjButtonActionPerformed
        // TODO add your handling code here:
        jFCadastroCargos oCadCargo = new jFCadastroCargos();

        oCadCargo.setTitle("Cadastro de cargos");
        oCadCargo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oCadCargo.setLocationRelativeTo(null);
        oCadCargo.setModal(true);
        oCadCargo.pack();
        oCadCargo.setVisible(true);

        consutaComboCargos();
    }//GEN-LAST:event_cadastroCargosjButtonActionPerformed

    private void alterarCargojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarCargojButtonActionPerformed
        // TODO add your handling code here:
        contadorGrade();
        FuncionarioCargos oFuncCargo = new FuncionarioCargos();

        combo_func_carg = (ComboItem) cargojComboBox.getSelectedItem();


        if (contador == 0) {

            try {

                oFuncCargo.setMatricula(recebe_matricula);
                oFuncCargo.setCargo_id(combo_func_carg.getId());
                oFuncCargo.setFrom_date(Funcoes.getDataFormatBR(data_admissao));
                oFuncCargo.setTo_date(Funcoes.getDataFormatBR("30/12/9999"));
                oFuncCargo.setCadastrar();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\n" + e,
                        "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }


        } else {

            updateStatus();

            try {


                String data;
                if (escolhaDatajCheckBox.isSelected()) {

                    SimpleDateFormat oDatOut = new SimpleDateFormat("dd/MM/yyyy");
                    data = oDatOut.format(dataNovoCargojDateChooser.getDate());

                } else {
                    data = data_atual;
                }

                oFuncCargo.setMatricula(recebe_matricula);
                oFuncCargo.setCargo_id(combo_func_carg.getId());
                oFuncCargo.setFrom_date(Funcoes.getDataFormatBR(data));
                oFuncCargo.setTo_date(Funcoes.getDataFormatBR("30/12/9999"));
                oFuncCargo.setCadastrar();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar após a atualização dos dados.\n" + e,
                        "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }


        }

        getConsultarGrade();
        contadorGrade();
        alterarCargojButton.setEnabled(false);
    }//GEN-LAST:event_alterarCargojButtonActionPerformed

    private void cargojComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargojComboBoxActionPerformed
        // TODO add your handling code here:
        alterarCargojButton.setEnabled(true);
    }//GEN-LAST:event_cargojComboBoxActionPerformed

    private void gradeFuncStatusjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeFuncStatusjTableMouseClicked
        // TODO add your handling code here:
//        to_date  = gradeFuncStatusjTable.getValueAt(gradeFuncStatusjTable.getSelectedRow(), 1).toString();
//        try {
//            getFieldFuncionarioCargo(to_date);
//        } catch (ParseException ex) {
//            Logger.getLogger(FuncionarioCargos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_gradeFuncStatusjTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFFuncionariosCargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFuncionariosCargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFuncionariosCargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFuncionariosCargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JFFuncionariosCargos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarCargojButton;
    private javax.swing.JButton cadastroCargosjButton;
    private javax.swing.JComboBox cargojComboBox;
    private javax.swing.JLabel dataFimjLabel;
    private com.toedter.calendar.JDateChooser dataNovoCargojDateChooser;
    private javax.swing.JCheckBox escolhaDatajCheckBox;
    private javax.swing.JTable gradeFuncStatusjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel matriculajLabel;
    private javax.swing.JLabel nomejLabel;
    // End of variables declaration//GEN-END:variables
}
