/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.dialog;

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

    /**
     * Clears the table data and then re-populates
     * the data lists based on the provided result
     * set.
     * @param result
     */
    public void updateTableData(ResultSet result){
        try {
            tableData.get(0).clear();
            tableData.get(1).clear();
            while(result.next()){
                String majorId = Integer.toString(result.getInt("ID"));
                String major = result.getString("major");
                tableData.get(0).add(majorId);
                tableData.get(1).add(major);
            }
            fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(AcademicMajorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
