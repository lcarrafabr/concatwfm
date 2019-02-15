/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class CadastroStatus {
    
    Integer status_id;
    String nome_status;

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getNome_status() {
        return nome_status;
    }

    public void setNome_status(String nome_status) {
        this.nome_status = nome_status;
    }
    
    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_STATUS  "
                    + " 	(STATUS_NAME    "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(?     "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setString(1, getNome_status());

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    
    public ResultSet getConsultar() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "SELECT * "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_STATUS "
                    + "WHERE STATUSID = STATUSID ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getStatus_id() != null) {
                comando = comando + " AND STATUSID = ? ";
            }


            comando = comando + " ORDER BY STATUSID ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


//            if (getNome() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, "%" + getNome() + "%");
//            }
            if (getStatus_id() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getStatus_id());
            }

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    public void setAlterar(ClassConecta conexao) {

        try {
            //ClassConecta conexao = new ClassConecta();

            //conexao.conecta();

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_STATUS "
                    + " 	SET "
                    + " 	STATUS_NAME = ?      "
                    + " 	WHERE "
                    + " 	STATUSID = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oDataCadastro = null;

            stmt.setString(1, getNome_status());
            stmt.setInt(2, getStatus_id());

            stmt.executeUpdate();
            
            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            System.out.println("Transação Concluída");
            JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
