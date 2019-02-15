/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class Funcionarios {

    Integer matricula;
    String gmid;
    String niceID;
    Integer login_avaya;
    String nome;
    Date hiredate;
    String network;
    String email;
    Integer altera_matricula;
    Integer idccms;
    String id_spreadfast;
    Integer gmin;

    public Integer getGmin() {
        return gmin;
    }

    public void setGmin(Integer gmin) {
        this.gmin = gmin;
    }

    public String getId_spreadfast() {
        return id_spreadfast;
    }

    public void setId_spreadfast(String id_spreadfast) {
        this.id_spreadfast = id_spreadfast;
    }

    public Integer getIdccms() {
        return idccms;
    }

    public void setIdccms(Integer idccms) {
        this.idccms = idccms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGmid() {
        return gmid;
    }

    public void setGmid(String gmid) {
        this.gmid = gmid;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getLogin_avaya() {
        return login_avaya;
    }

    public void setLogin_avaya(Integer login_avaya) {
        this.login_avaya = login_avaya;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNiceID() {
        return niceID;
    }

    public void setNiceID(String niceID) {
        this.niceID = niceID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAltera_matricula() {
        return altera_matricula;
    }

    public void setAltera_matricula(Integer altera_matricula) {
        this.altera_matricula = altera_matricula;
    }
    

    public void setCadastrar() {
        try {


            String comando = "INSERT INTO DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO  "
                    + " 	(MATRICULA,     "
                    + " 	GMID,           "
                    + " 	NICEID,         "
                    + " 	LOGIN_AVAYA,    "
                    + " 	NOME,           "
                    + " 	HIREDATE,       "
                    + " 	NETWORK,        "
                    + " 	EMAIL,          "
                    + " 	IDCCMS,         "
                    + " 	ID_SPREADFAST,  "
                    + " 	GMIN            "
                    + " 	) "
                    + " 	VALUES  "
                    + " 	(?,     "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?,      "
                    + " 	?       "
                    + " 	); ";

            System.out.println("Executando operação");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oDataCadastro = null;
            if (getHiredate() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oDataCadastro = oDatOut.format(getHiredate());
            }

            stmt.setInt(1, getMatricula());
            stmt.setString(2, getGmid());
            stmt.setString(3, getNiceID());
            stmt.setInt(4, getLogin_avaya());
            stmt.setString(5, getNome());
            stmt.setString(6, oDataCadastro);
            stmt.setString(7, getNetwork());
            stmt.setString(8, getEmail());
            if(getIdccms() == null){
                stmt.setNull(9, Types.NULL);
            }else{
                stmt.setInt(9, getIdccms());
            }

            stmt.setString(10, getId_spreadfast());
            
            if(getGmin() == null){
                stmt.setNull(11, Types.NULL);
            }else{
                stmt.setInt(11, getGmin());
            }

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
                    + "FROM DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO "
                    + "WHERE MATRICULA = MATRICULA ";

            int quantParam = 0;

            if (getNome() != null) {
                comando = comando + "AND NOME LIKE ? ";
            }
            if (getMatricula() != null) {
                comando = comando + " AND MATRICULA = ? ";
            }
            if (getGmid() != null) {
                comando = comando + "AND GMID LIKE ? ";
            }




            comando = comando + " ORDER BY NOME ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getNome() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getNome() + "%");
            }
            if (getMatricula() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getMatricula());
            }
            if (getGmid() != null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getGmid() + "%");
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

            String comando = "UPDATE DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO "
                    + " 	SET "
                    + " 	MATRICULA = ?,      "
                    + " 	GMID = ?,           "
                    + "         NICEID = ?,         "
                    + "         LOGIN_AVAYA = ?,    "
                    + "         NOME = ?,           "
                    + "         HIREDATE = ?,       "
                    + "         NETWORK = ?,        "
                    + "         EMAIL = ?,          "
                    + "         IDCCMS = ?,         "
                    + "         ID_SPREADFAST = ?,  "
                    + "         GMIN = ?            "
                    + " 	WHERE "
                    + " 	MATRICULA = ? ";

            System.out.println("Executando operação...");

            PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

            String oDataCadastro = null;
            if (getHiredate() != null) {
                SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
                oDataCadastro = oDatOut.format(getHiredate());
            }
            
            stmt.setInt(1, getMatricula());
            stmt.setString(2, getGmid());
            stmt.setString(3, getNiceID());
            stmt.setInt(4, getLogin_avaya());
            stmt.setString(5, getNome());
            stmt.setString(6, oDataCadastro);
            stmt.setString(7, getNetwork());
            stmt.setString(8, getEmail());
            
            if(getIdccms() == null){
                stmt.setNull(9, Types.NULL);
            }else{
                stmt.setInt(9, getIdccms());
            }

            stmt.setString(10, getId_spreadfast());
            
            if(getGmin() == null){
                stmt.setNull(11, Types.NULL);
            }else{
                stmt.setInt(11, getGmin());
            }

            stmt.setInt(12, getAltera_matricula());

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
