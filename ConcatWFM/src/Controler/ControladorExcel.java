/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Modelo.ModeloExcel;
import VO.VistaExcel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author luciano.benfica
 */
public class ControladorExcel implements ActionListener {

    ModeloExcel modeloE = new ModeloExcel();
    VistaExcel vistaE = new VistaExcel();
    JFileChooser selectArchivo = new JFileChooser();
    File archivo;
    int contAcction = 0;

    public ControladorExcel(VistaExcel vistaE, ModeloExcel modeloE) {

        this.vistaE = vistaE;
        this.modeloE = modeloE;
        this.vistaE.btnImportar.addActionListener(this);
        this.vistaE.btnExportar.addActionListener(this);
    }

    public void AgregarFiltro() {

//        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
//        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsm)", "xlsm"));
//        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.csv)", "csv"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contAcction++;

        if (contAcction == 1) {
            AgregarFiltro();
        }

        if (e.getSource() == vistaE.btnImportar) {

            if (selectArchivo.showDialog(null, "Selecionar um arquivo") == JFileChooser.APPROVE_OPTION) {
                archivo = selectArchivo.getSelectedFile();
                if (archivo.getName().endsWith("xls")
                        || archivo.getName().endsWith("xlsx")
                        || archivo.getName().endsWith("xlsm")
                        || archivo.getName().endsWith("csv")) {
                    
                    JOptionPane.showMessageDialog(null, modeloE.Importar(archivo, vistaE.jTDatos));
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Selecione um formato válido.");
                    
                }
            }

        }
        
        
        if (e.getSource() == vistaE.btnExportar) {

            if (selectArchivo.showDialog(null, "Exportar para Excel") == JFileChooser.APPROVE_OPTION) {
                archivo = selectArchivo.getSelectedFile();
                if (archivo.getName().endsWith("xls")
                        || archivo.getName().endsWith("xlsx")
                        || archivo.getName().endsWith("xlsm")
                        || archivo.getName().endsWith("csv")) {
                    
                    JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, vistaE.jTDatos));
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Selecione um formato válido.");
                    
                }
            }

        }


    }
}
