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
public class FuncionarioCargos {
    
    public Date from_date;
    public Integer cargo_id;
    public Integer matricula;
    public Date to_date;
    public Date to_date_pesquisa;
    public Date update_from_date;

    public Date getTo_date_pesquisa() {
        return to_date_pesquisa;
    }

    public void setTo_date_pesquisa(Date to_date_pesquisa) {
        this.to_date_pesquisa = to_date_pesquisa;
    }
    public Integer getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(Integer cargo_id) {
        this.cargo_id = cargo_id;
    }

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


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO  "
                    + " 	(FROM_DATE, "
                    + " 	CARGO_ID,   "
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
            stmt.setInt(2, getCargo_id());
            stmt.setInt(3, getMatricula());
            stmt.setString(4, oTo_date);
            
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
            String comando = "SELECT tfc.MATRICULA,c.CARGO_NAME ,f.NOME,tfc.FROM_DATE,tfc.TO_DATE "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO tfc "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f on f.MATRICULA=tfc.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on c.CARGO_ID=tfc.CARGO_ID ";

            int quantParam = 0;
            
            String To_date_pesq = null;
            if (getTo_date_pesquisa() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                To_date_pesq = oDatOut.format(getTo_date_pesquisa());
            }

            
            if (getMatricula() != null) {
                comando = comando + " WHERE tfc.MATRICULA = ? ";
            }
            if (getTo_date_pesquisa() != null) {
                comando = comando + "AND tfc.TO_DATE = ? ";
            }


            comando = comando + " ORDER BY tfc.TO_DATE DESC ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getMatricula() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getMatricula());
            }
            if (getTo_date_pesquisa()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, To_date_pesq);
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
            String comando = "SELECT CARGO_NAME, FROM_DATE "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO "
                    + "WHERE TO_DATE = '9999-12-30' ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getMatricula() != null) {
                comando = comando + " AND MATRICULA = ? ";
            }


            comando = comando + " ORDER BY MATRICULA ";

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
    
    public ResultSet getConsultarCargoFunc() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT fc.CARGO_ID, fc.FROM_DATE, c.* "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO fc, DB_MIS_GLOBAL.gmb.TB_CARGO c "
                    + "WHERE TO_DATE = '9999-12-30' "
                    + "and fc.CARGO_ID = c.CARGO_ID ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getMatricula() != null) {
                comando = comando + " AND MATRICULA = ? ";
            }


            comando = comando + " ORDER BY MATRICULA ";

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
    
    
    public ResultSet getConsultarFuncionarioCargoCombos(int nivel1, int nivel2) throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT fc.CARGO_ID, fc.FROM_DATE, c.*, f.MATRICULA, f.NOME "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO fc "
//                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on fc.CARGO_ID=c.CARGO_ID and fc.CARGO_ID in (3,2)"
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on fc.CARGO_ID=c.CARGO_ID and fc.CARGO_ID in (" + nivel1 + "," + nivel2 + ") "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f on fc.MATRICULA=f.MATRICULA "
                    + "WHERE TO_DATE = '9999-12-30' ";

            int quantParam = 0;

            if (getCargo_id() != null) {
                comando = comando + " AND fc.CARGO_ID = ? ";
            }


            comando = comando + " ORDER BY f.NOME ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getCargo_id() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getCargo_id());
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO "
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
//            JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
  
}
