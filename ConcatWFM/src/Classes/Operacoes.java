/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class Operacoes {
    
    Integer operacao_id;
    String operacao_name;
    Integer cod_operacao_id;

    public Integer getCod_operacao_id() {
        return cod_operacao_id;
    }

    public void setCod_operacao_id(Integer cod_operacao_id) {
        this.cod_operacao_id = cod_operacao_id;
    }

    public Integer getOperacao_id() {
        return operacao_id;
    }

    public void setOperacao_id(Integer operacao_id) {
        this.operacao_id = operacao_id;
    }

    public String getOperacao_name() {
        return operacao_name;
    }

    public void setOperacao_name(String operacao_name) {
        this.operacao_name = operacao_name;
    }
    
    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_OPERACAO  "
                    + " 	(OPERACAO_ID, "
                    + "         OPERACAO_NAME    "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(?,"
                    + "         ?     "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            
            stmt.setInt(1, getOperacao_id());
            stmt.setString(2, getOperacao_name());

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public ResultSet getConsultarIdOperacao() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "SELECT * "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_OPERACAO ";

            int quantParam = 0;

            if (getOperacao_id() != null) {
                comando = comando + " WHERE OPERACAO_ID = ? ";
            }

            comando = comando + " ORDER BY OPERACAO_ID ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getOperacao_id() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getOperacao_id());
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_OPERACAO "
                    + " 	SET "
                    + " 	OPERACAO_ID = ?,        "
                    + "         OPERACAO_NAME = ?       "
                    + " 	WHERE "
                    + " 	OPERACAO_ID = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setInt(1, getOperacao_id());
            stmt.setString(2, getOperacao_name());
            stmt.setInt(3, getCod_operacao_id());

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
