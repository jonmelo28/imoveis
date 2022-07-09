/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jonatha.classe;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonatha
 */
public class Model extends AbstractTableModel{
     private String[] columns;
    private Object[][] rows;
    
    public Model(){}
    
    public Model(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }
    
      public Class getColumnClass(int column){
      // 0 is the index of the column image
        if(column == 0 ){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
      
      public int getRowCount() {
     return this.rows.length;
    }

    public int getColumnCount() {
     return this.columns.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    return this.rows[rowIndex][columnIndex];
    }
    public String getColumnName(int col){
        return this.columns[col];
    }
    
}

