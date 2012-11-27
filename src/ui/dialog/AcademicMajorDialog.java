/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import ui.contactform.RotcContactsModel;
import ui.queries.ContactQueries;

/**
 *
 * @author javarobots74
 */
public class AcademicMajorDialog extends javax.swing.JDialog {

    private AcademicMajorTableModel tableModel;
    private RotcContactsModel contactsModel;
    private ContactQueries databaseQueries;

    /**
     * Creates new form AcademicMajorDialog
     */
    public AcademicMajorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTable();
    }

    public AcademicMajorDialog(java.awt.Frame parent, boolean modal, RotcContactsModel model) {
        super(parent, modal);
        initComponents();
        this.contactsModel = model;
        this.databaseQueries = model.getQueries();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        academicMajorLabel = new javax.swing.JLabel();
        academicMajorTextField = new javax.swing.JTextField();
        academicMajorScrollPane = new javax.swing.JScrollPane();
        academicMajorTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Academic Majors");

        academicMajorLabel.setText("Academic Major:");

        academicMajorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Academic Major"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        academicMajorScrollPane.setViewportView(academicMajorTable);

        addButton.setText("Add");
        addButton.setToolTipText("Add the major entered in the academic major text field.");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setToolTipText("Delete the selected major(s).");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(academicMajorScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(academicMajorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(academicMajorTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, cancelButton, deleteButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicMajorLabel)
                    .addComponent(academicMajorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(academicMajorScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!academicMajorTextField.getText().isEmpty()){
            databaseQueries.addAcademicMajor(academicMajorTextField.getText());
        }
        updateContactsModel();
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (academicMajorTable.getSelectedRow() > -1){
            String id = (String) academicMajorTable.getModel().getValueAt(academicMajorTable.getSelectedRow(), 0);
            if (!databaseQueries.majorBeingUsed(id)){
                databaseQueries.deleteAcademicMajor(id);
                updateContactsModel();
                this.dispose();
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void initTable() {
        //Set table model
        tableModel = new AcademicMajorTableModel();
        academicMajorTable.setModel(tableModel);
        academicMajorTable.setCellSelectionEnabled(false);
        academicMajorTable.setRowSelectionAllowed(true);

        //Adjust column widths of table
        academicMajorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int scrollPaneWidth = academicMajorTable.getParent().getWidth();
        int firstColumnWidth = 40;
        academicMajorTable.getColumnModel().getColumn(0).setPreferredWidth(firstColumnWidth);
        academicMajorTable.getColumnModel().getColumn(1).setPreferredWidth(scrollPaneWidth - firstColumnWidth);

        //Load data to table model
        tableModel.updateTableData(databaseQueries.getAcademicMajors());
    }
    
    private void updateContactsModel(){
        try {
            ResultSet majors = databaseQueries.getAcademicMajors();
            ArrayList<String> majorList = new ArrayList<>();
            Map<String,Integer> majorMap = new HashMap<>();
            while(majors.next()){
                String major = majors.getString("major");
                int majorID = majors.getInt("ID");
                majorList.add(major);
                majorMap.put(major, majorID);
            }
            contactsModel.setMajorMap(majorMap);
            contactsModel.notifyObservers();
        } catch (SQLException ex) {
            Logger.getLogger(AcademicMajorDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel academicMajorLabel;
    private javax.swing.JScrollPane academicMajorScrollPane;
    private javax.swing.JTable academicMajorTable;
    private javax.swing.JTextField academicMajorTextField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    // End of variables declaration//GEN-END:variables
}
