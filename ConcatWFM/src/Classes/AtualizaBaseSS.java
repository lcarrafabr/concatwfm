/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano.benfica
 */
public class AtualizaBaseSS {
    
    private String data_arquivo_base;
    private String data_extracao_final;
    
    private String coluna_0;
    private String coluna_1;
    private String coluna_2;
    private String coluna_3;
    private static String coluna_4;
    private String coluna_5;
    private String coluna_6;
    private String coluna_7;
    private String coluna_8;
    private String coluna_9;
    private String coluna_10;
    private String coluna_11;
    private String coluna_12;
    private String coluna_13;
    private String coluna_14;
    private String coluna_15;
    private String coluna_16;
    private String coluna_17;
    private String coluna_18;
    private String coluna_19;
    private String coluna_20;
    private String coluna_21;
    private String coluna_22;
    private String coluna_23;
    private String coluna_24;
    private String coluna_25;
    private String coluna_26;
    private String coluna_27;
    private String coluna_28;
    private String coluna_29;
    private String coluna_30;
    private String coluna_31;
    private String coluna_32;
    private String coluna_33;
    private String coluna_34;
    private String coluna_35;
    private String coluna_36;
    private String coluna_37;
    private String coluna_38;
    private String coluna_39;
    private String coluna_40;
    private String coluna_41;
    private String coluna_42;
    private String coluna_43;
    private String coluna_44;
    private String coluna_45;
    private String coluna_46;
    private String coluna_47;
    private String coluna_48;
    private String coluna_49;
    private String coluna_50;
    private String coluna_51;
    private String coluna_52;
    private String coluna_53;
    private String coluna_54;
    private String coluna_55;
    private String coluna_56;
    private String coluna_57;
    private String coluna_58;
    private String coluna_59;
    private String coluna_60;
    private String coluna_61;
    private String coluna_62;
    private String coluna_63;
    private String coluna_64;
    private String coluna_65;
    private String coluna_66;
    private String coluna_67;
    private String coluna_68;
    private String coluna_69;
    private String coluna_70;
    private String coluna_71;
    private String coluna_72;
    private String coluna_73;
    private String coluna_74;
    private String coluna_75;
    private String coluna_76;
    private String coluna_77;
    private String coluna_78;
    private String coluna_79;
    private String coluna_80;
    private String coluna_81;
    private String coluna_82;
    private String coluna_83;
    private String coluna_84;
    private String coluna_85;
    private String coluna_86;
    private String coluna_87;
    private String coluna_88;
    private String coluna_89;
    private String coluna_90;
    private String coluna_91;
    private String coluna_92;
    private String coluna_93;
    private String coluna_94;
    private String coluna_95;
    private String coluna_96;
    private String coluna_97;
    private String coluna_98;
    private String coluna_99;
    private String coluna_100;
    private String coluna_101;
    private String coluna_102;
    private String coluna_103;
    private String coluna_104;
    private String coluna_105;
    private String coluna_106;
    private String coluna_107;
    private String coluna_108;
    private String coluna_109;
    private String coluna_110;
    private String coluna_111;
    private String coluna_112;
    /*****variaveis de controle*********************************/
    private static Date open_date;
    private static Date date_closed;
    
    
    /**
     * Função para entrar na rede e verificar se existe arquivo e subir os dados
     * no banco de dados. Esse método precisa dos parametros abaixo
     *
     * @param file arquivo a ser aberto
     * @param nome_do_arquivo nome do arquivo a ser aberto (já vem com a
     * extenção)
     * @param caminho_do_arquivo caminho até esse arquivo
     */
    public void atualizaBaseSS(File file, String nome_do_arquivo, String caminho_do_arquivo) {

        File[] arquivos = file.listFiles();
        try {
            ClassConecta.conecta();
        } catch (Exception e) {
        }
        for (File arquivo : arquivos) {
            
            
            
            nome_do_arquivo = arquivo.getName();
            
            String nome_base = nome_do_arquivo;
            String extencao = nome_base.substring(nome_base.length() - 4);
            String nome_sem_extensao = nome_base.replaceAll(extencao, "");
            String data_do_arquivo = nome_sem_extensao.substring(nome_sem_extensao.length()-10);
            
            String ano = data_do_arquivo.substring(data_do_arquivo.length()-4);
            String mes = data_do_arquivo.substring(3, 5);
            String dia = data_do_arquivo.substring(0, 2);
            
            data_arquivo_base = dia + "-" + mes + "-" + ano;
            
            
//            System.out.println("Data do arquivo: " + data_arquivo_base);


            File path = new File(caminho_do_arquivo + nome_do_arquivo);

            try {

                FileReader reader = new FileReader(path);
                try (BufferedReader input = new BufferedReader(reader)) {
                    String linha;


                    while ((linha = input.readLine()) != null) {

                        String[] colunas = linha.split("\t");

                        if (linha == null) {
                            break;
                        }

                        /**
                         * As colunas abaixo representam a base real. O que não
                         * for usado deverá ficar comentado. Qualquer alteração
                         * de posição das colunas, deverá ser alterado apenas o
                         * seu numero de posição sendo a colunas[0] como a
                         * primeira coluna da planilha. Toda alteração colocar
                         * nos comentarios abaixo
                         */
                        /**
                         * ==============Alterações aqui========================
                         *
                         *
                         */
                                coluna_0 = colunas[0];// Type
//                                + colunas[1] + " - "//Involved Dealer
                                coluna_2 = colunas[2];//BAC
//                                + colunas[3] + " - "//Region
                                coluna_4 = colunas[4].toString();//Actual open Date
                                coluna_5 = colunas[5];//Cellular Phone #
//                                + colunas[6] + " - "//Date initiated
                                coluna_7 = colunas[7];//Cross ref Type
                                coluna_8 = colunas[8];//Bussiness Unit
                                coluna_9 = colunas[9];//Resolution
                                coluna_10 = colunas[10];//Applications
//                                + colunas[11] + " - "//Avaiable offline
                                coluna_12 = colunas[12];//Financial A/C
//                                + colunas[13] + " - "//Status(icon)
//                                + colunas[14] + " - "//Incident count
//                                + colunas[15] + " - "//Member #
//                                + colunas[16] + " - "//member id
//                                + colunas[17] + " - "//Codes
//                                + colunas[18] + " - "//problem Title
//                                + colunas[19] + " - "//Problem #
//                                + colunas[20] + " - "//Product issue #
//                                + colunas[21] + " - "//Change
//                                + colunas[22] + " - "//Change title
//                                + colunas[23] + " - "//Recommendation
//                                + colunas[24] + " - "//Type
//                                + colunas[25] + " - "//Team space
//                                + colunas[26] + " - "//Lot#
//                                + colunas[27] + " - "//Product Issue
                                coluna_28 = colunas[28];//Contact
//                                + colunas[29] + " - "//Employee
//                                + colunas[30] + " - "//Disease
//                                + colunas[31] + " - "//Odometer reading
//                                + colunas[32] + " - "//Make
                                coluna_33 = colunas[33];//Model
                                coluna_34 = colunas[34];//model Year
                                coluna_35 = colunas[35];//Claim type
//                                + colunas[36] + " - "//Recommended Priority
                                coluna_37 = colunas[37];//Reason for contact
//                                + colunas[38] + " - "//Urgency
//                                + colunas[39] + " - "//Area
//                                + colunas[40] + " - "//Unit
//                                + colunas[41] + " - "//Sub area
//                                + colunas[42] + " - "//Licence Plate #
//                                + colunas[43] + " - "//Product
//                                + colunas[44] + " - "//Profile
//                                + colunas[45] + " - "//Acount # / Policy #
//                                + colunas[46] + " - "//Asset #
//                                + colunas[47] + " - "//Ent. Agreement id #
//                                + colunas[48] + " - "//Claim #
//                                + colunas[49] + " - "//Billing #
                                coluna_50 = colunas[50];//Area
                                coluna_51 = colunas[51];//Summary
                                coluna_52 = colunas[52];//Source
//                                + colunas[53] + " - "//part #
//                                + colunas[54] + " - "//New
                                coluna_55 = colunas[55];//SR#
                                coluna_56 = colunas[56];//Abstract
//                                + colunas[57] + " - "//Communication Record
//                                + colunas[58] + " - "//Reproducible
//                                + colunas[59] + " - "//Account
//                                + colunas[60] + " - "//Account
//                                + colunas[61] + " - "//Site
                                coluna_62 = colunas[62];//Home Phone #
//                                + colunas[63] + " - "//Agent Escalation Time
                                coluna_64 = colunas[64];//Cross Ref ID
                                coluna_65 = colunas[65];//Sub Area
//                                + colunas[66] + " - "//Account #
                                coluna_67 = colunas[67];//Last name
                                coluna_68 = colunas[68];//First Name
//                                + colunas[69] + " - "//Revision
                                coluna_70 = colunas[70];//Wort Phone #
//                                + colunas[71] + " - "//Agent
//                                + colunas[72] + " - "//Follow-Up
//                                + colunas[73] + " - "//Method
//                                + colunas[74] + " - "//Contact Account
//                                + colunas[75] + " - "//Serial #
//                                + colunas[76] + " - "//Serial#/VIN#
//                                + colunas[77] + " - "//Service Item
//                                + colunas[78] + " - "//Billable
//                                + colunas[79] + " - "//Contact At
//                                + colunas[80] + " - "//Request By
//                                + colunas[81] + " - "//Price List
//                                + colunas[82] + " - "//Supervisor review
//                                + colunas[83] + " - "//Document Needed
//                                + colunas[84] + " - "//Documents Received
//                                + colunas[85] + " - "//Rate List
                                coluna_86 = colunas[86];//Created By
                                coluna_87 = colunas[87];//Opened
                                coluna_88 = colunas[88];//Assigned To
//                                + colunas[89] + " - "//Check Order - Account #
//                                + colunas[90] + " - "//Check Style
//                                + colunas[91] + " - "//Check Design
//                                + colunas[92] + " - "//Check Order - Starting#
//                                + colunas[93] + " - "//Check Order - Quantify Of Order
//                                + colunas[94] + " - "//Include Cover
//                                + colunas[95] + " - "//From Account #
//                                + colunas[96] + " - "//To Account
//                                + colunas[97] + " - "//Dollar Amount
//                                + colunas[98] + " - "//Date Of Transfer
                                coluna_99 = colunas[99];//Group
//                                + colunas[100] + " - "//Date last modified
                                coluna_101 = colunas[101];//Date Closed
//                                + colunas[102] + " - "//Resolution Date
//                                + colunas[103] + " - "//Days Resolve
//                                + colunas[104] + " - "//Days opened
//                                + colunas[105] + " - "//Severity
                                coluna_106 = colunas[106];//Priority
                                coluna_107 = colunas[107];//Status
                                coluna_108 = colunas[108];//Substatus
//                                + colunas[109] + " - "//Entitlement
//                                + colunas[110] + " - "//Commited
//                                + colunas[111] + " - "//Organization
//                                +colunas[112]//Organization Id
                        
                        
                        /**==============INSERT=============**/
                        
                        
                        
                        try {
                            
                            String comando = "EXEC DB_MIS_GLOBAL.gmb.SP_GMB_INSERT_TB_SS "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "?, "
                                    + "? "
                                    + "";
                            
//                            System.out.println("Executando operação");

//                            CallableStatement stmt = (CallableStatement) ClassConecta.conecta();
                            CallableStatement stmt = ClassConecta.conecta().prepareCall(comando);
                            
//                            System.out.println("Data de exportação" + data_arquivo_base);
                            
                            //formata data de abertura----------------------------------------------
                            formataOpenDate(coluna_4);
                            String data_abertura = null;
                            if (open_date != null) {
                                SimpleDateFormat oDatOutOpenDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                data_abertura = oDatOutOpenDate.format(open_date);
                                
//                                System.out.println("Data de abertura: " + data_abertura);
                            }
                            //-----------------------------------------------------------------------
                            //formata data de abertura----------------------------------------------
                            formataDateClosed(coluna_101);
                            String data_fechamento = null;
                            if (date_closed != null) {
                                SimpleDateFormat oDatOutDateClosed = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                data_fechamento = oDatOutDateClosed.format(date_closed);
                                
//                                System.out.println("Data de fechamento: " + data_fechamento);
                            }
                            //-----------------------------------------------------------------------
                            Date data_extract = null;
                            String data_extracao_final2 = null;
                            if (data_arquivo_base != null) {
                                SimpleDateFormat oDatOut = new SimpleDateFormat("dd-MM-yyyy");
                                data_extract = (java.util.Date) oDatOut.parse(data_arquivo_base);
                                
                                
                                SimpleDateFormat oDatOutextFinal = new SimpleDateFormat("yyyy-MM-dd");
                                data_extracao_final2 = oDatOutextFinal.format(data_extract);
                                
                                
                            }
                            
                            
//                            System.out.println(data_arquivo_base + " Data esxtração: " + data_extracao_final2);
//                          //**Aqui são oa dados que serão enviados para banco**//  
                            stmt.setString(1, data_extracao_final2);
                            stmt.setString(2, colunas[55]);
                            stmt.setString(3, colunas[0]);
                            stmt.setString(4, colunas[2]);
                            stmt.setString(5, data_abertura);
                            stmt.setString(6, colunas[5]);
                            stmt.setString(7, colunas[10]);
                            stmt.setString(8, colunas[7]);
                            stmt.setString(9, colunas[8]); 
                            stmt.setString(10, colunas[12]);
                            stmt.setString(11, colunas[28]);
                            stmt.setString(12, colunas[33]);
                            stmt.setString(13, colunas[34]);
                            stmt.setString(14, colunas[35]);
                            stmt.setString(15, colunas[37]);
                            stmt.setString(16, colunas[41]);
                            stmt.setString(17, colunas[65]);
                            stmt.setString(18, colunas[51]);
                            stmt.setString(19, colunas[52]);
                            stmt.setString(20, colunas[56]);
                            stmt.setString(21, colunas[62]);
                            stmt.setString(22, colunas[64]);
                            stmt.setString(23, colunas[67]);
                            stmt.setString(24, colunas[68]);
                            stmt.setString(25, colunas[70]);
                            stmt.setString(26, colunas[86]);
                            stmt.setString(27, colunas[87]);
                            stmt.setString(28, colunas[88]);
                            stmt.setString(29, colunas[99]);
                            stmt.setString(30, data_fechamento);
                            stmt.setString(31, colunas[106]);
                            stmt.setString(32, colunas[107]);
                            stmt.setString(33, colunas[108]);
                            stmt.setString(34, colunas[9]);
                            
                            
//                            System.out.println(data_extracao_final2 + " - " +
//                            colunas[55]  + " - " +
//                            colunas[0] + " - " +
//                            colunas[2] + " - " +
//                            data_abertura + " - " +
//                            colunas[5] + " - " +
//                            colunas[10] + " - " +
//                            colunas[7] + " - " +
//                            colunas[8] + " - " +
//                            colunas[12] + " - " +
//                            colunas[28] + " - " +
//                            colunas[33] + " - " +
//                            colunas[34] + " - " +
//                            colunas[35] + " - " +
//                            colunas[37] + " - " +
//                            colunas[41] + " - " +
//                            colunas[65] + " - " +
//                            colunas[51] + " - " +
//                            colunas[52] + " - " +
//                            colunas[56] + " - " +
//                            colunas[62] + " - " +
//                            colunas[64] + " - " +
//                            colunas[67] + " - " +
//                            colunas[68] + " - " +
//                            colunas[70] + " - " +
//                            colunas[86] + " - " +
//                            colunas[87] + " - " +
//                            colunas[88] + " - " +
//                            colunas[99] + " - " +
//                            data_fechamento + " - " +
//                            colunas[106] + " - " +
//                            colunas[107] + " - " +
//                            colunas[108] + " - " +
//                          colunas[9]);

//                            System.out.println("antes do execute");
                            stmt.execute();

                            ClassConecta.con.commit();
                            ClassConecta.con.setAutoCommit(true);
                            

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                        

                    }//Fim do while (linha a linha)

                }



            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao importar\n" + e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
            
            //Função para deletar os arquivos da pasta
//            Funcoes.deletaArquivoNoDiretorio(caminho_do_arquivo, nome_do_arquivo);
        }//Fim do For que lê os arquivos
        JOptionPane.showMessageDialog(null, "TERMINEI");
    }
    
    public static Date formataOpenDate(String data) throws Exception {

        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            date = (java.util.Date) formatter.parse(data);
        } catch (Exception e) {
            throw e;
        }
//           System.out.println(coluna_4 + " Data formatada: " + date);
        open_date = date;
        return date;
    }
    
    public static Date formataDateClosed(String data_closed) throws Exception {

        if (data_closed == null || data_closed.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            date = (java.util.Date) formatter.parse(data_closed);
        } catch (Exception e) {
            throw e;
        }
//           System.out.println(coluna_4 + " Data formatada: " + date);
        date_closed = date;
        return date;
    }
    
    
}
