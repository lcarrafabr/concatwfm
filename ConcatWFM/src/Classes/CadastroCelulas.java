/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class CadastroCelulas {

    private Integer celula_id;
    private Integer operacao_id;
    private String celula_nome;
    private Integer cod_celula_update;

    public Integer getCod_celula_update() {
        return cod_celula_update;
    }

    public void setCod_celula_update(Integer cod_celula_update) {
        this.cod_celula_update = cod_celula_update;
    }

    public Integer getCelula_id() {
        return celula_id;
    }

    public void setCelula_id(Integer celula_id) {
        this.celula_id = celula_id;
    }

    public String getCelula_nome() {
        return celula_nome;
    }

    public void setCelula_nome(String celula_nome) {
        this.celula_nome = celula_nome;
    }

    public Integer getOperacao_id() {
        return operacao_id;
    }

    public void setOperacao_id(Integer operacao_id) {
        this.operacao_id = operacao_id;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_CELULA  "
                    + " 	(CELULA_ID,     "
                    + " 	OPERACAO_ID,    "
                    + " 	CELULA_NOME     "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(?,     "
                    + " 	?,      "
                    + " 	?      "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setInt(1, getCelula_id());
            stmt.setInt(2, getOperacao_id());
            stmt.setString(3, getCelula_nome());

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
            String comando = "SELECT tfc.* ,o.OPERACAO_NAME "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_CELULA tfc "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_OPERACAO o on o.OPERACAO_ID=tfc.OPERACAO_ID ";

            int quantParam = 0;

            if (getCelula_id() != null) {
                comando = comando + " WHERE tfc.CELULA_ID = ? ";
            }
            if (getCelula_nome()!= null) {
                comando = comando + "WHERE tfc.CELULA_NOME like ? ";
            }


            comando = comando + " ORDER BY tfc.CELULA_ID ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCelula_id() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCelula_id());
            }
            if (getCelula_nome()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getCelula_nome()+ "%");
            }

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);
            System.out.println(sqlex);
            Logger.getLogger(FuncionariosStatus.class.getName()).log(Level.SEVERE, null, sqlex);

        }

        return resultSet;
    }
     
     
     public void setAlterar(ClassConecta conexao) {

        try {
            //ClassConecta conexao = new ClassConecta();

            //conexao.conecta();

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_CELULA "
                    + " 	SET "
                    + " 	CELULA_ID = ?,      "
                    + " 	OPERACAO_ID = ?,    "
                    + "         CELULA_NOME = ?     "
                    + " 	WHERE "
                    + " 	CELULA_ID = ?";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setInt(1, getCelula_id());
            stmt.setInt(2, getOperacao_id());
            stmt.setString(3, getCelula_nome());
            stmt.setInt(4, getCod_celula_update());

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
