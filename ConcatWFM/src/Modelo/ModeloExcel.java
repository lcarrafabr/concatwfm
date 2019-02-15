/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author luciano.benfica
 */
public class ModeloExcel {
    
    Workbook wb = new SXSSFWorkbook(100);
    
    public String Importar(File archivo, JTable tablaD){
        
        String respuesta = "Não foi possível realizar a importação.";
        
        
        
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        try {
            
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            
            Iterator filaIterator = hoja.rowIterator();
            
            int indiceFila = -1;
            
            while (filaIterator.hasNext()) {                
                
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                
                Object[] listaColumna = new Object[14];
                
                int indiceColumna = -1;
                
                while (columnaIterator.hasNext()) {                    
                    
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    
                    if(indiceFila == 0){
                        modeloT.addColumn(celda.getStringCellValue());
                    }else{
                        if(celda != null){
                            
                            switch(celda.getCellType()){
                                
                                case Cell.CELL_TYPE_NUMERIC:
                                    
                                    listaColumna [indiceColumna] = (int)Math.round(celda.getNumericCellValue());
                                    break;
                                    
                                case Cell.CELL_TYPE_STRING:
                                    
                                    listaColumna [indiceColumna] = celda.getStringCellValue();
                                    break;
                                    
                                    default:
                                        
                                        listaColumna [indiceColumna] = celda.getDateCellValue();
                                        break;
                                
                            }
                            
                        }                       
                    }
                    
                    
                }
                
                if(indiceFila != 0)modeloT.addRow(listaColumna);
                
            }
            
           
            
            respuesta = "Importação realizada com sucesso!";
        } catch (IOException | InvalidFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao importar a planilha FMA.\n"
                    + "Verifique a planilha antes de importar.\n"+e, "Mensagem do sistema", JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
        
    }
    
    
    public String Exportar (File archivo, JTable tablaD){
        
        String respuesta = "Falha ao exportar dados.";
        
        
        int numFila = tablaD.getRowCount(), numColumna = tablaD.getColumnCount();
        
        if(archivo.getName().endsWith("xls")){
            
            wb = new HSSFWorkbook();  
        }else{
            wb = new SXSSFWorkbook();
        }
        
        Sheet hoja = wb.createSheet("Teste");
        
        try {
            
            for (int i = -1; i < numFila; i++) {
                
                Row fila = hoja.createRow(i+1);
                
                for (int j = 0; j < numColumna; j++) {
                    
                    Cell celda = fila.createCell(j);
                    
                    if(i == -1){
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    
                    wb.write(new FileOutputStream(archivo));
                    
                }
                
            }
            
            respuesta = "Exportado com sucesso";
            
        } catch (IOException e) {
        }
        
        
        
        return respuesta;
        
    }
    
    
    
}
