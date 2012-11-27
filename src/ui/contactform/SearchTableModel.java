/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.contactform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author javarobots74
 */
public class SearchTableModel extends AbstractTableModel {

    private String[] columnNames = {"ID","Last Name","First Name"};
    private ArrayList<ArrayList<String>> data;
    
    public SearchTableModel() {
        data = new ArrayList<>();
        ArrayList<String> list;
        for (int i = 0; i < columnNames.length; i++){
            list = new ArrayList<>();
            data.add(list);
        }
    }
    
    @Override
    public int getRowCount() {
        return data.get(0).size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(columnIndex).get(rowIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    public void updateData(ResultSet results) {
        try {
            for (int i = 0 ; i < 3 ; i++){
                data.get(i).clear();
            }
            while (results.next()){
                data.get(0).add(results.getString("ID"));
                data.get(1).add(results.getString("LastName"));
                data.get(2).add(results.getString("FirstName"));
            }
            fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(SearchTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearDate() {
        for (int i = 0 ; i < 3 ; i++){
            data.get(i).clear();
        }
    }
    
}
