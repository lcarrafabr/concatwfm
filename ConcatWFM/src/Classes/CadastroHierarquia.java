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
public class CadastroHierarquia {

    private Integer matricula;
    private Date from_date;
    private Integer matricula_lider;
    private Date to_date;
    private Date update_from_date;
    private String to_date_FMA; //variavel usada para a planilha FMA.
    private String from_date_FMA;

    public String getFrom_date_FMA() {
        return from_date_FMA;
    }

    public void setFrom_date_FMA(String from_date_FMA) {
        this.from_date_FMA = from_date_FMA;
    }

    public String getTo_date_FMA() {
        return to_date_FMA;
    }

    public void setTo_date_FMA(String to_date_FMA) {
        this.to_date_FMA = to_date_FMA;
    }

    public Date getUpdate_from_date() {
        return update_from_date;
    }

    public void setUpdate_from_date(Date update_from_date) {
        this.update_from_date = update_from_date;
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

    public Integer getMatricula_lider() {
        return matricula_lider;
    }

    public void setMatricula_lider(Integer matricula_lider) {
        this.matricula_lider = matricula_lider;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public void setCadastrar() {
        try {

            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_HIERARQUIA  "
                    + " 	(MATRICULA, "
                    + " 	FROM_DATE,  "
                    + " 	MAT_LIDER,  "
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

            stmt.setInt(1, getMatricula());

            if (getFrom_date_FMA() != null) {
                stmt.setString(2, getFrom_date_FMA());
            } else {
                stmt.setString(2, oFrom_date);
            }

            stmt.setInt(3, getMatricula_lider());
            stmt.setString(4, oTo_date);

            stmt.execute();

            ClassConecta.con.commit();
            ClassConecta.con.setAutoCommit(true);

            if (getFrom_date_FMA() == null) {
                JOptionPane.showMessageDialog(null, "Status cadastrado com sucesso!");
            }

        } catch (SQLException | HeadlessException e) {
            System.err.println("Erro na Transação\n" + e);
            JOptionPane.showMessageDialog(null, "Erro na Transação\n" + e, "ATENÇÃO", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ResultSet getConsultar() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "SELECT f.MATRICULA,f.NOME,fh.NOME as 'nome2',h.FROM_DATE,h.TO_DATE   "
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f  "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h on h.MATRICULA=f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO fh on h.MAT_LIDER=fh.MATRICULA ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND NOME LIKE ? ";
//            }
            if (getMatricula() != null) {
                comando = comando + " WHERE h.MATRICULA = ? ";
            }

            comando = comando + " ORDER BY h.TO_DATE DESC ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

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
            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_HIERARQUIA "
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

            if (getTo_date_FMA() != null) {
                stmt.setString(1, getTo_date_FMA());
            } else {
                stmt.setString(1, oTo_date);
            }

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
