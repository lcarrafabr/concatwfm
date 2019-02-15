/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author cmtj
 */

public class ClassConecta {


    /** Creates a new instance of ClassConecta */


    public ClassConecta() {    }

    //Dados conexao banco
    public static String url      = "jdbc:sqlserver://SPWS-VM-DB58.tpb.corp:1433;mydatabaseName=DB_MIS_GLOBAL;";
    public static String driver   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String user     = "user=usr_sist_DB_MIS_GLOBAL;";
    public static String pwd      = "password=!@Usr_Sist_DB_MIS_GLOBAL#$;";
    
//    public static String user     = "user=usr_app_DB_MIS_GLOBAL;";
//    public static String pwd      = "password=!@Usr_App_DB_MIS_GLOBAL#$;";


    public static Connection con = null;

    /**
     *
     * @return
     */

    public void setConnection(String dominio) throws SQLException{
         ClassConecta conexao = new ClassConecta();
         ClassConecta.conecta();

        //Pegar dados do dominio solicitado
        Dominios oDominio = new Dominios();
        if (!dominio.isEmpty() ){
          oDominio.setDominio( dominio );
        }

        ResultSet rsDominio;

            rsDominio = oDominio.getConsultar(conexao);
            rsDominio.first();

            url     = rsDominio.getString("url");
            driver  = rsDominio.getString("driver");
            user    = rsDominio.getString("user");
            pwd     = rsDominio.getString("pwd");


    }

    public static Connection conecta(){

        try{

            Class.forName(driver);

//            con = DriverManager.getConnection("jdbc:sqlserver://SPWS-VM-DB58.tpb.corp:1433;databaseName=DB_MIS_GLOBAL;user=usr_app_DB_MIS_GLOBAL;password=!@Usr_App_DB_MIS_GLOBAL#$");
            con = DriverManager.getConnection(url + user + pwd);
            //Suas tabelas são MyISAM ou InnoDB? Porque MyISAM não suportam transações.
            //Alter table alterar para InnoDB.
            con.setAutoCommit(false);
        }catch(ClassNotFoundException e){
            do {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Driver não encontrado!\n" + e, "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } while (true);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocorreu um erro no sistema, se o problema persistir contate o administrador:\n Erro na Conexão com Banco\n"+ e,"ATENÇÃO",JOptionPane.WARNING_MESSAGE);
}
//        System.out.println("Conectado brrlll");

        return con;
    }


}
