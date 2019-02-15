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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class FuncionariosStatus {

    Date from_date;
    Integer status_id;
    Integer matricula;
    Date to_date;
    Date update_from_date;

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public Date getUpdate_from_date() {
        return update_from_date;
    }

    public void setUpdate_from_date(Date update_from_date) {
        this.update_from_date = update_from_date;
    }

    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS  "
                    + " 	(FROM_DATE, "
                    + " 	STATUSID,   "
                    + " 	MATRICULA,  "
                    + " 	TO_DATE     "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(?,     "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oFrom_date = null;
            if (getFrom_date() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oFrom_date = oDatOut.format(getFrom_date());
            }
            String oTo_date = null;
            if (getTo_date() != null) {
                SimpleDateFormat oDatOut2 = new SimpleDateFormat("yyyy-MM-dd");
                oTo_date = oDatOut2.format(getTo_date());
            }

            stmt.setString(1, oFrom_date);
            stmt.setInt(2, getStatus_id());
            stmt.setInt(3, getMatricula());
            stmt.setString(4, oTo_date);

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

//            JOptionPane.showMessageDialog(null, "Status cadastrado com sucesso!");

        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ResultSet getConsultar() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT tfs.Matricula,s.STATUS_NAME ,f.NOME,tfs.FROM_DATE,tfs.TO_DATE "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS tfs "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f on f.MATRICULA=tfs.Matricula "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_STATUS s on s.STATUSID=tfs.STATUSID ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getMatricula() != null) {
                comando = comando + " WHERE tfs.Matricula = ? ";
            }


            comando = comando + " ORDER BY tfs.TO_DATE DESC ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


//            if (getNome() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, "%" + getNome() + "%");
////            }
            if (getMatricula() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getMatricula());
            }

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);
            System.out.println(sqlex);
            Logger.getLogger(FuncionariosStatus.class.getName()).log(Level.SEVERE, null, sqlex);

        }

        return resultSet;
    }

    public ResultSet getConsultarStatus() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT STATUSID, FROM_DATE "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS "
                    + "WHERE TO_DATE = '9999-12-30' ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getMatricula() != null) {
                comando = comando + " AND Matricula = ? ";
            }


            comando = comando + " ORDER BY Matricula ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


//            if (getNome() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, "%" + getNome() + "%");
////            }
            if (getMatricula() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getMatricula());
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS "
                    + " 	SET "
                    + "         TO_DATE = ?     "
                    + " 	WHERE "
                    + " 	TO_DATE = ? "
                    + "         AND MATRICULA = ? ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oTo_date = null;
            if (getTo_date() != null) {
                SimpleDateFormat oDatOut2 = new SimpleDateFormat("yyyy-MM-dd");
                oTo_date = oDatOut2.format(getTo_date());
            }
            String oUpdate = null;
            if (getUpdate_from_date() != null) {
                SimpleDateFormat oDatOut3 = new SimpleDateFormat("yyyy-MM-dd");
                oUpdate = oDatOut3.format(getUpdate_from_date());
            }

            stmt.setString(1, oTo_date);
            stmt.setString(2, oUpdate);
            stmt.setInt(3, getMatricula());

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

//    public void setExcluir(ClassConecta conexao) {
//
//        try {
//
//            String comando = " DELETE FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS  "
//                    + " 	WHERE "
//                    + " 	MATRICULA = ?  "
//                    + "         AND ";
//
//            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
//            //Formatar data Prevista
//
//            stmt.setInt(1, getCodigo_cargo());
//
//
//            stmt.executeUpdate();
//
//            ClassConecta.con.commit();
//            ClassConecta.con.setAutoCommit(true);
//
//            //System.out.println("TransaÃ§Ã£o ConcluÃ­da");
//            JOptionPane.showMessageDialog(null, "O REGISTRO foi excluÃ­do com sucesso.", "ATENÃÃO", JOptionPane.INFORMATION_MESSAGE);
//        } catch (SQLException | HeadlessException e) {
//            System.err.println("Erro na TransaÃ§Ã£o\n" + e);
//            JOptionPane.showMessageDialog(null, "Erro na TransaÃ§Ã£o", "ATENÃÃO", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
