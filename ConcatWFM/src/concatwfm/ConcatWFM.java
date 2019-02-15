/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concatwfm;

import Classes.ClassConecta;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author luciano.benfica
 */
public class ConcatWFM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        JFHome oFormHome = new JFHome();
        
        oFormHome.setTitle("ConcatWFM");
        oFormHome.setLocationRelativeTo(null);
        oFormHome.pack();
        oFormHome.setVisible(true);



//        ClassConecta conecta = new ClassConecta();
//        
//        try {
//            ClassConecta.conecta();
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados!\n"+e, "mensagem do sistema", JOptionPane.ERROR_MESSAGE);
//            
//            System.out.println(e);
//            
//        }






    }
}
