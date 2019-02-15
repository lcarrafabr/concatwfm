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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class CaminhoRedeReport {

    private Integer id;
    private String caminho_rede;
    private String tabulador;
    private String nome_base;

    public String getCaminho_rede() {
        return caminho_rede;
    }

    public void setCaminho_rede(String caminho_rede) {
        this.caminho_rede = caminho_rede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_base() {
        return nome_base;
    }

    public void setNome_base(String nome_base) {
        this.nome_base = nome_base;
    }

    public String getTabulador() {
        return tabulador;
    }

    public void setTabulador(String tabulador) {
        this.tabulador = tabulador;
    }

    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_CAMINHO_ATUALIZACAO_REPORT  "
//                    + " 	(null, "
                    + " 	(CAMINHO,   "
                    + " 	TABULADOR,  "
                    + " 	PASTA     "
                    + " 	) "
                    + " 	VALUES  "
//                    + " 	(null,     "
                    + " 	(?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            stmt.setString(1, getCaminho_rede());
            stmt.setString(2, getTabulador());
            stmt.setString(3, getNome_base());

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Status cadastrado com sucesso!");

        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public ResultSet getConsultar() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT * "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_CAMINHO_ATUALIZACAO_REPORT ";

            int quantParam = 0;

            if (getId() != null) {
                comando = comando + " WHERE ID = ? ";
            }


            comando = comando + " ORDER BY ID ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getId() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getId());
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_CAMINHO_ATUALIZACAO_REPORT "
                    + " 	SET "
                    + "         CAMINHO = ?,    "
                    + "         TABULADOR = ?,  "
                    + "         PASTA = ?       "
                    + " 	WHERE "
                    + " 	ID = ? ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
            
            stmt.setString(1, getCaminho_rede());
            stmt.setString(2, getTabulador());
            stmt.setString(3, getNome_base());
            stmt.setInt(4, getId());

            stmt.executeUpdate();
            
            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            System.out.println("Transação Concluída");
            JOptionPane.showMessageDialog(null, "O REGISTRO foi alterado com sucesso.", "Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
