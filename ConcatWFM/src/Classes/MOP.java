/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class MOP {
    
    private Integer matricula;
    private String gmid;
    private Integer niceid;
    private Integer login_avaya;
    private String nome;
    private Date hiredate;
    private String network;
    private String email;
    private Integer idccms;
    private String id_spredfast;
    private Integer gmin;
    private String status_name;
    private String supervisor;
    private String coordenador;
    private String celula;
    private String grupo;
    private Integer status_id;

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getGmid() {
        return gmid;
    }

    public void setGmid(String gmid) {
        this.gmid = gmid;
    }

    public Integer getNiceid() {
        return niceid;
    }

    public void setNiceid(Integer niceid) {
        this.niceid = niceid;
    }

    public Integer getLogin_avaya() {
        return login_avaya;
    }

    public void setLogin_avaya(Integer login_avaya) {
        this.login_avaya = login_avaya;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdccms() {
        return idccms;
    }

    public void setIdccms(Integer idccms) {
        this.idccms = idccms;
    }

    public String getId_spredfast() {
        return id_spredfast;
    }

    public void setId_spredfast(String id_spredfast) {
        this.id_spredfast = id_spredfast;
    }

    public Integer getGmin() {
        return gmin;
    }

    public void setGmin(Integer gmin) {
        this.gmin = gmin;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getCelula() {
        return celula;
    }

    public void setCelula(String celula) {
        this.celula = celula;
    }

    public String getGrupo() {
        return grupo;
    }   

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    public ResultSet getConsultar() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando = "select f.*, s.STATUS_NAME, f2.NOME as [SUPERVISOR], f3.NOME as [COORDENADOR], cel.CELULA_NOME as [CELULA], cel.GRUPO, s.STATUSID "
                    + "from DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS fs on fs.MATRICULA = f.MATRICULA and fs.FROM_DATE <= CONVERT(date, getdate()) and TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_STATUS s on fs.STATUSID = s.STATUSID "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO fc on fc.MATRICULA = f.MATRICULA and fc.FROM_DATE <= CONVERT(date, getdate()) and fc.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on c.CARGO_ID = fc.CARGO_ID "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h on h.MATRICULA = f.MATRICULA and h.FROM_DATE <= CONVERT(date, getdate()) and h.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f2 on f2.MATRICULA = h.MAT_LIDER "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h2 on h2.MATRICULA = f2.MATRICULA and h2.FROM_DATE <= CONVERT(date, getdate()) and h2.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f3 on f3.MATRICULA = h2.MAT_LIDER "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CELULA fcel on fcel.MATRICULA = f.MATRICULA and fcel.FROM_DATE <= CONVERT(date, getdate()) and fcel.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CELULA cel on cel.CELULA_ID = fcel.CELULA_ID "
                    + "where c.CARGO_ID in (1,7) ";

            int quantParam = 0;

            if (getNome() != null) {
                comando = comando + "AND f.NOME LIKE ? ";
            }
            if (getMatricula() != null) {
                comando = comando + " AND f.MATRICULA = ? ";
            }
            if (getGmid() != null) {
                comando = comando + "AND f.GMID LIKE ? ";
            }
            if(getNiceid() != null){
                comando = comando + "AND f.NICEID = ? ";
            }
            if(getLogin_avaya()!= null){
                comando = comando + "AND f.LOGIN_AVAYA = ? ";
            }
            if(getIdccms()!= null){
                comando = comando + "AND f.IDCCMS = ? ";
            }
            if(getStatus_id()!= null){
                comando = comando + "AND s.STATUSID = ? ";
            }
            if (getSupervisor()!= null) {
                comando = comando + "AND f2.NOME LIKE ? ";
            }
            if (getCoordenador()!= null) {
                comando = comando + "AND f3.NOME LIKE ? ";
            }
            if (getGrupo()!= null) {
                comando = comando + "AND cel.GRUPO LIKE ? ";
            }

            comando = comando + " ORDER BY f.NOME ";

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
            if (getNiceid()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getNiceid());
            }
            if (getLogin_avaya()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getLogin_avaya());
            }
            if (getIdccms()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getIdccms());
            }
            if (getStatus_id()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setInt(quantParam, getStatus_id());
            }
            if (getSupervisor()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getSupervisor()+ "%");
            }
            if (getCoordenador()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getCoordenador()+ "%");
            }
            if (getGrupo()!= null) {
                quantParam = quantParam + 1;
                stmtQuery.setString(quantParam, "%" + getGrupo()+ "%");
            }
            

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    public ResultSet getConsultarSupervisor() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "select distinct f.* "
                    + "from DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h on h.MAT_LIDER = f.MATRICULA and h.FROM_DATE <= CONVERT(date, getdate()) and h.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO fc on fc.MATRICULA = f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS fs on fs.MATRICULA = f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on c.CARGO_ID = fc.CARGO_ID "
                    + "where fc.CARGO_ID = 2 "
                    + "and fs.STATUSID = 7 ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND f.NOME LIKE ? ";
//            }
//            if (getMatricula() != null) {
//                comando = comando + " AND f.MATRICULA = ? ";
//            }

            comando = comando + " ORDER BY f.NOME ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


//            if (getNome() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, "%" + getNome() + "%");
//            }
//            if (getMatricula() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setInt(quantParam, getMatricula());
//            }

            

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    
    public ResultSet getConsultarCoordenador() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "select distinct f2.* "
                    + "from DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h on h.MAT_LIDER = f.MATRICULA and h.FROM_DATE <= CONVERT(date, getdate()) and h.TO_DATE >= CONVERT(date, getdate()) "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_CARGO fc on fc.MATRICULA = f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO_STATUS fs on fs.MATRICULA = f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_HIERARQUIA h2 on h2.MATRICULA = f.MATRICULA "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_FUNCIONARIO f2 on f2.MATRICULA = h2.MAT_LIDER "
                    + "inner join DB_MIS_GLOBAL.gmb.TB_CARGO c on c.CARGO_ID = fc.CARGO_ID "
                    + "where fc.CARGO_ID = 2 "
                    + "and fs.STATUSID = 7 ";

            int quantParam = 0;

//            if (getNome() != null) {
//                comando = comando + "AND f.NOME LIKE ? ";
//            }
//            if (getMatricula() != null) {
//                comando = comando + " AND f.MATRICULA = ? ";
//            }

            comando = comando + " ORDER BY f2.NOME ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


//            if (getNome() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setString(quantParam, "%" + getNome() + "%");
//            }
//            if (getMatricula() != null) {
//                quantParam = quantParam + 1;
//                stmtQuery.setInt(quantParam, getMatricula());
//            }

            

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
    
    public ResultSet getConsultarTIER() throws SQLException {
        ResultSet resultSet = null;

        try {
            String comando;
            comando = "select distinct c.GRUPO "
                    + "from DB_MIS_GLOBAL.gmb.TB_CELULA c "
                    + "where c.OPERACAO_ID <> 1 ";

            comando = comando + " ORDER BY c.GRUPO ";

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            resultSet = stmtQuery.executeQuery();

        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi Possivél executar o comando sql" + sqlex);

        }

        return resultSet;
    }
    
}
