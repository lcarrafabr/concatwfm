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
public class JFHierarquia extends javax.swing.JDialog {

    /**
     * Creates new form JFHierarquia
     */
    public JFHierarquia() {
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
        jLabel5 = new javax.swing.JLabel();
        cargojLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboSuperioresjComboBox = new javax.swing.JComboBox();
        dataAlteracaojLabel = new javax.swing.JLabel();
        dataPersonalizadajCheckBox = new javax.swing.JCheckBox();
        alterarHirrarquiajButton = new javax.swing.JButton();
        cargosjButton = new javax.swing.JButton();
        DataHierarqjDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeHierarquiajTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFocusable(false);

        jLabel1.setText("Nome:");

        jLabel2.setText("Matrícula:");

        jLabel5.setText("Cargo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(matriculajLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargojLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(matriculajLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nomejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cargojLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setText("Nome do superior imediato");

        comboSuperioresjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSuperioresjComboBoxActionPerformed(evt);
            }
        });

        dataAlteracaojLabel.setText("Data da alteração");

        dataPersonalizadajCheckBox.setText("Usar data personalizada");
        dataPersonalizadajCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataPersonalizadajCheckBoxActionPerformed(evt);
            }
        });

        alterarHirrarquiajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/save2.png"))); // NOI18N
        alterarHirrarquiajButton.setText("Alterar Hierarquia");
        alterarHirrarquiajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarHirrarquiajButtonActionPerformed(evt);
            }
        });

        cargosjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hierarchi.png"))); // NOI18N
        cargosjButton.setText("Cargos");
        cargosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataAlteracaojLabel)
                            .addComponent(DataHierarqjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataPersonalizadajCheckBox)
                        .addGap(26, 26, 26)
                        .addComponent(cargosjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alterarHirrarquiajButton))
                    .addComponent(jLabel3)
                    .addComponent(comboSuperioresjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSuperioresjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataAlteracaojLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataPersonalizadajCheckBox)
                        .addComponent(alterarHirrarquiajButton)
                        .addComponent(cargosjButton))
                    .addComponent(DataHierarqjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alterar Hirarquia", jPanel2);

        gradeHierarquiajTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome1", "Nome2", "Data inicio", "Data fim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeHierarquiajTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(gradeHierarquiajTable);
        gradeHierarquiajTable.getColumnModel().getColumn(0).setResizable(false);
        gradeHierarquiajTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeHierarquiajTable.getColumnModel().getColumn(1).setResizable(false);
        gradeHierarquiajTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        gradeHierarquiajTable.getColumnModel().getColumn(2).setResizable(false);
        gradeHierarquiajTable.getColumnModel().getColumn(2).setPreferredWidth(180);
        gradeHierarquiajTable.getColumnModel().getColumn(3).setResizable(false);
        gradeHierarquiajTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        gradeHierarquiajTable.getColumnModel().getColumn(4).setResizable(false);
        gradeHierarquiajTable.getColumnModel().getColumn(4).setPreferredWidth(50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ClassConecta conecta = new ClassConecta();
    int recebe_matricula;
    String recebe_nome;
    private String cargo;
    private int cargo_id;
    private int contador_grade;
    private ComboItem combo_hierarquia;
    private String data_admissao;
    private String nome_nivel1;
    private String nome_nivel2;
    private String data_calcular;
    private String data_final;
    private String data_atual;

    public void getGrandeHierarquia() throws ParseException {
        //Consultar Cargos
        CadastroHierarquia oCadHier = new CadastroHierarquia();


        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Matrícula", nome_nivel1, nome_nivel2, "Data inicio", "Data fim"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeHierarquiajTable.setModel(modeloTabela);
        gradeHierarquiajTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeHierarquiajTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        gradeHierarquiajTable.getColumnModel().getColumn(2).setPreferredWidth(180);
        gradeHierarquiajTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        gradeHierarquiajTable.getColumnModel().getColumn(4).setPreferredWidth(50);

        try {

            oCadHier.setMatricula(recebe_matricula);
            resultSet = oCadHier.getConsultar();

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
                String data_to;
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
                            resultSet.getString("MATRICULA"),
                            resultSet.getString("NOME"),
                            resultSet.getString("NOME2"),
                            data_from,
                            verifica
                        });

            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosStatus.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void getCarregarGrade() {
        try {
            getGrandeHierarquia();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar grade.\n" + e,
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

    private void contadorGrade() {

        contador_grade = gradeHierarquiajTable.getRowCount();
    }

    private void getPreencherCombo() {
        FuncionarioCargos oFuncCargo = new FuncionarioCargos();
        ResultSet rs;
        int nivel1 = 0;
        int nivel2 = 0;

        try {

            switch (cargo_id) {

                case 1://operador
                    nivel1 = 2;//supervisor
                    nivel2 = 3;//coordenador
                    break;

                case 2://supervisor
                    nivel1 = 3;//coordenador
                    nivel2 = 4;//gerente
                    break;

                case 3://coordenador
                    nivel1 = 4;//gerente
                    nivel2 = 5;//gerente geral
                    break;

                case 4://genrente
                    nivel1 = 5;//gerente geral
                    nivel2 = 5;//gerente geral
                    break;
                    
                case 8: //treinamento
                    nivel1 = 3;//coordenador
                    nivel2 = 4;//gerente
                    break;
                case 7://PONTO FOCAL
                    nivel1 = 2;//supervisor
                    nivel2 = 3;//coordenador
                    break;    

                case 5://gerente geral

                    JOptionPane.showMessageDialog(null, "Não é necessário cadastrar uma hierarquia superior para Gerente Geral.",
                            "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);

                    comboSuperioresjComboBox.removeAllItems();
                    alterarHirrarquiajButton.setEnabled(false);
                    break;

            }

            rs = oFuncCargo.getConsultarFuncionarioCargoCombos(nivel1, nivel2);
            comboSuperioresjComboBox.removeAllItems();
            while (rs.next()) {
                comboSuperioresjComboBox.addItem(new ComboItem(rs.getInt("MATRICULA"), rs.getString("NOME")));
            }
            comboSuperioresjComboBox.updateUI();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar campo Superior imediato.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getConsultarCargo() {

        FuncionarioCargos oFuncCargo = new FuncionarioCargos();

        ResultSet rs;
        try {
            oFuncCargo.setMatricula(recebe_matricula);
            rs = oFuncCargo.getConsultarCargoFunc();

            while (rs.next()) {

                cargo = rs.getString("CARGO_NAME");
                cargo_id = rs.getInt("CARGO_ID");

            }
            cargojLabel.setText(cargo);
        } catch (SQLException e) {
            Logger.getLogger(JFHierarquia.class.getName()).log(Level.SEVERE, null, e);
        }

        if (cargo == null) {

            JOptionPane.showMessageDialog(null, "Atenção\n"
                    + "O usuario \'" + recebe_matricula + "\' não possui um cargo atribuído a ele.\n"
                    + "Antes de informar uma hierarquia é necessário atribuír um cargo ao usuário.", "Mensagem do sistema", JOptionPane.WARNING_MESSAGE);

            cargosjButton.setVisible(true);
            alterarHirrarquiajButton.setVisible(false);

        } else {
            cargosjButton.setVisible(false);
            alterarHirrarquiajButton.setVisible(true);
            getPreencherCombo();
            atualizaNomecargoTabela();
        }
    }

    private void atualizaNomecargoTabela() {

        switch (cargo) {

            case "OPERADOR":
                nome_nivel1 = cargo;
                nome_nivel2 = "SUPERVISOR";
                break;
            case "SUPERVISOR":
                nome_nivel1 = cargo;
                nome_nivel2 = "COORDENADOR";
                break;
            case "COORDENADOR":
                nome_nivel1 = cargo;
                nome_nivel2 = "GERENTE";
                break;
            case "GERENTE":
                nome_nivel1 = cargo;
                nome_nivel2 = "GERENTE GERAL";
                break;
            case "GERENTE GERAL":
                nome_nivel1 = cargo;
                nome_nivel2 = "-";
                break;
            case "TREINAMENTO":
                nome_nivel1 = cargo;
                nome_nivel2 = "COORDENADOR";
                break;
            case "PONTO FOCAL":
                nome_nivel1 = cargo;
                nome_nivel2 = "SUPERVISOR";
                break;    
        }
    }

    public void calculaData() throws ParseException {

        Calendar c = Calendar.getInstance();
        c.setTime(Funcoes.getDataFormatBR(data_calcular));
        c.add(Calendar.DATE, -1);

        data_final = Funcoes.getDataFormat(c.getTime());
    }

    private void updateStatus() {

        CadastroHierarquia oCadHier = new CadastroHierarquia();

        try {

            if (dataPersonalizadajCheckBox.isSelected()) {

                SimpleDateFormat oDatOut = new SimpleDateFormat("dd/MM/yyyy");
                data_calcular = oDatOut.format(DataHierarqjDateChooser.getDate());
                calculaData();
            } else {

                data_calcular = data_atual;
                calculaData();
            }

            if (DataHierarqjDateChooser.getDate() == null && dataPersonalizadajCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Informe uma data.", "Mensagem do sistema", JOptionPane.WARNING_MESSAGE);
            } else if (comboSuperioresjComboBox.getSelectedItem().equals("") && !"GERENTE GERAL".equals(cargo)) {
                JOptionPane.showMessageDialog(null, "O campo NOME DO SUPERIOR IMEDIATO não pode ser vazio.", "Mensagem do sistema", JOptionPane.WARNING_MESSAGE);
            } else {
                try {

                    oCadHier.setUpdate_from_date(Funcoes.getDataFormatBR("30/12/9999"));
                    oCadHier.setTo_date(Funcoes.getDataFormatBR(data_final));
                    oCadHier.setMatricula(recebe_matricula);
                    oCadHier.setAlterar(conecta);

                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar registro.\n" + e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (ParseException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular data.\n" + e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        alterarHirrarquiajButton.setEnabled(false);
        cargosjButton.setVisible(false);
        DataHierarqjDateChooser.setEnabled(false);
        dataAlteracaojLabel.setEnabled(false);

        nomejLabel.setText(recebe_nome);
        matriculajLabel.setText(Integer.toString(recebe_matricula));

        try {
            ClassConecta.conecta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão com o banco de dados.\n" + e,
                    "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        try {
            data_atual = Funcoes.getNowBR();
        } catch (ParseException e) {
        }
        getConsultarCargo();
        contadorGrade();
        getConsultarDataAdmissao();
        getCarregarGrade();
    }//GEN-LAST:event_formWindowOpened

    private void cargosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargosjButtonActionPerformed
        // TODO add your handling code here:
        JFFuncionariosCargos oFuncCargo = new JFFuncionariosCargos();

        oFuncCargo.recebe_matricula = recebe_matricula;
        oFuncCargo.recebe_nome = recebe_nome;

        oFuncCargo.setTitle("Cadastro de cargos");
        oFuncCargo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oFuncCargo.setLocationRelativeTo(null);
        oFuncCargo.pack();
        oFuncCargo.setModal(true);
        oFuncCargo.setVisible(true);

        getConsultarCargo();
        atualizaNomecargoTabela();
        getCarregarGrade();
    }//GEN-LAST:event_cargosjButtonActionPerformed

    private void alterarHirrarquiajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarHirrarquiajButtonActionPerformed
        // TODO add your handling code here:
        CadastroHierarquia oCadHi = new CadastroHierarquia();
        contadorGrade();

        combo_hierarquia = (ComboItem) comboSuperioresjComboBox.getSelectedItem();

        if (contador_grade == 0) {

            try {
                oCadHi.setMatricula(recebe_matricula);
                oCadHi.setFrom_date(Funcoes.getDataFormatBR(data_admissao));
                oCadHi.setMatricula_lider(combo_hierarquia.getId());
                oCadHi.setTo_date(Funcoes.getDataFormatBR("30/12/9999"));
                oCadHi.setCadastrar();
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\n" + e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            updateStatus();

            try {

                String data;
                if (dataPersonalizadajCheckBox.isSelected()) {

                    SimpleDateFormat oDatOut = new SimpleDateFormat("dd/MM/yyyy");
                    data = oDatOut.format(DataHierarqjDateChooser.getDate());
                } else {
                    data = data_atual;
                }

                oCadHi.setMatricula(recebe_matricula);
                oCadHi.setMatricula_lider(combo_hierarquia.getId());
                oCadHi.setFrom_date(Funcoes.getDataFormatBR(data));
                oCadHi.setTo_date(Funcoes.getDataFormatBR("30/12/9999"));
                oCadHi.setCadastrar();

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar.\n" + e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
            }

        }
        getCarregarGrade();
        contadorGrade();
        alterarHirrarquiajButton.setEnabled(false);
    }//GEN-LAST:event_alterarHirrarquiajButtonActionPerformed

    private void comboSuperioresjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSuperioresjComboBoxActionPerformed
        // TODO add your handling code here:
        alterarHirrarquiajButton.setEnabled(true);
    }//GEN-LAST:event_comboSuperioresjComboBoxActionPerformed

    private void dataPersonalizadajCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataPersonalizadajCheckBoxActionPerformed
        // TODO add your handling code here:
        if (dataPersonalizadajCheckBox.isSelected()) {
            DataHierarqjDateChooser.setEnabled(true);
            dataAlteracaojLabel.setEnabled(true);
            DataHierarqjDateChooser.grabFocus();
        } else {
            DataHierarqjDateChooser.setEnabled(false);
            dataAlteracaojLabel.setEnabled(false);
            DataHierarqjDateChooser.setDate(null);
        }
    }//GEN-LAST:event_dataPersonalizadajCheckBoxActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFHierarquia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JFHierarquia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataHierarqjDateChooser;
    private javax.swing.JButton alterarHirrarquiajButton;
    private javax.swing.JLabel cargojLabel;
    private javax.swing.JButton cargosjButton;
    private javax.swing.JComboBox comboSuperioresjComboBox;
    private javax.swing.JLabel dataAlteracaojLabel;
    private javax.swing.JCheckBox dataPersonalizadajCheckBox;
    private javax.swing.JTable gradeHierarquiajTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel matriculajLabel;
    private javax.swing.JLabel nomejLabel;
    // End of variables declaration//GEN-END:variables
}