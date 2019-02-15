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
public class CadastroCargos {
    
    Integer cargo_id;
    Integer cod_cargo_id;
    String cargo_name;

    public Integer getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(Integer cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    public Integer getCod_cargo_id() {
        return cod_cargo_id;
    }

    public void setCod_cargo_id(Integer cod_cargo_id) {
        this.cod_cargo_id = cod_cargo_id;
    }
    
    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_CARGO  "
                    + " 	(CARGO_NAME "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(? "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            
            stmt.setString(1, getCargo_name());

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
                    + "FROM DB_MIS_GLOBAL.gmb.TB_CARGO ";

            int quantParam = 0;

            if (getCargo_id() != null) {
                comando = comando + " WHERE CARGO_ID = ? ";
            }

            comando = comando + " ORDER BY CARGO_ID ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCargo_id() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCargo_id());
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_CARGO "
                    + " 	SET "
                    + " 	CARGO_NAME = ?        "
                    + " 	WHERE "
                    + " 	CARGO_ID = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setString(1, getCargo_name());
            stmt.setInt(2, getCargo_id());

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
