/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.dialog;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javarobots74
 */
public class AcademicMajorTableModel extends AbstractTableModel {
    
    private String[] headingNames = {"ID", "Academic Major"};
    private ArrayList<ArrayList<String>> tableData;
    
    public AcademicMajorTableModel(){
        tableData = new ArrayList<>();
        ArrayList<String> dataList = new ArrayList<>();
        tableData.add(dataList);
        dataList = new ArrayList<>();
        tableData.add(dataList);
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return headingNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return tableData.get(0).size();
    }

    @Override
    public int getColumnCount() {
        return headingNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tableData.get(columnIndex).get(rowIndex);
    }
    
}
