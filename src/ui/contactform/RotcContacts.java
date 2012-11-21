/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.contactform;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import ui.dialog.AcademicMajorDialog;
import ui.utility.ComponentPosition;

/**
 *
 * @author javarobots74
 */
public class RotcContacts extends javax.swing.JFrame implements Observer {

    private static RotcContactsController contactController;
    private boolean lastNameFocus = false;

    /**
     * Creates new form RotcContacts
     */
    public RotcContacts() {
        initComponents();
        
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                //Do nothing
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //Do Nothing
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //Do nothing
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //Do nothing
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //Do nothing
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //Do nothing
            }

            @Override
            public void windowClosing(WindowEvent e) {
                contactController.closeDatabaseConnection();
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        contactPanel = new javax.swing.JPanel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        phoneOneLabel = new javax.swing.JLabel();
        phoneTwoLabel = new javax.swing.JLabel();
        phoneOneTextField = new javax.swing.JTextField();
        phoneTwoTextField = new javax.swing.JTextField();
        gpaLabel = new javax.swing.JLabel();
        gpaTextField = new javax.swing.JTextField();
        actLabel = new javax.swing.JLabel();
        actTextField = new javax.swing.JTextField();
        majorLabel = new javax.swing.JLabel();
        notesLabel = new javax.swing.JLabel();
        notesScrollPane = new javax.swing.JScrollPane();
        notesTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        majorLookupButton = new javax.swing.JButton();
        totalRecordsLabel = new javax.swing.JLabel();
        majorComboBox = new javax.swing.JComboBox();
        searchPanel = new javax.swing.JPanel();
        searchLastNameLabel = new javax.swing.JLabel();
        searchLastNameTextField = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        statusMenu = new javax.swing.JMenu();
        workingDirectoryMenuItem = new javax.swing.JMenuItem();
        synchronizeDirectoryMenuItem = new javax.swing.JMenuItem();
        synchronizeCheckBox = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Det 014 Contacts");
        setResizable(false);

        lastNameLabel.setText("Last Name:");

        firstNameLabel.setText("First Name:");

        phoneOneLabel.setText("Phone 1:");

        phoneTwoLabel.setText("Phone 2:");

        gpaLabel.setText("GPA:");

        actLabel.setText("ACT/SAT:");

        majorLabel.setText("Major:");

        notesLabel.setText("Notes:");

        notesTextArea.setColumns(20);
        notesTextArea.setRows(5);
        notesScrollPane.setViewportView(notesTextArea);

        submitButton.setText("Submit");
        submitButton.setEnabled(false);

        majorLookupButton.setText("...");
        majorLookupButton.setEnabled(false);
        majorLookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majorLookupButtonActionPerformed(evt);
            }
        });

        totalRecordsLabel.setText("Total Records: 0");

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contactPanelLayout.createSequentialGroup()
                                .addComponent(lastNameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(contactPanelLayout.createSequentialGroup()
                                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneOneLabel)
                                    .addComponent(firstNameLabel)
                                    .addComponent(phoneTwoLabel)
                                    .addComponent(gpaLabel)
                                    .addComponent(actLabel)
                                    .addComponent(majorLabel))
                                .addGap(18, 18, 18)
                                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contactPanelLayout.createSequentialGroup()
                                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(firstNameTextField)
                                            .addComponent(phoneOneTextField)
                                            .addComponent(phoneTwoTextField)
                                            .addComponent(actTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                            .addComponent(gpaTextField))
                                        .addGap(52, 52, 52))
                                    .addGroup(contactPanelLayout.createSequentialGroup()
                                        .addComponent(majorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addComponent(majorLookupButton))
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notesLabel)
                            .addComponent(notesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanelLayout.createSequentialGroup()
                        .addComponent(totalRecordsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)))
                .addContainerGap())
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneOneLabel)
                    .addComponent(phoneOneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneTwoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTwoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gpaLabel)
                    .addComponent(gpaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actLabel)
                    .addComponent(actTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorLabel)
                    .addComponent(majorLookupButton)
                    .addComponent(majorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(notesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(totalRecordsLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Contact", contactPanel);

        searchLastNameLabel.setText("Last Name:");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLastNameLabel)
                .addGap(18, 18, 18)
                .addComponent(searchLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLastNameLabel)
                    .addComponent(searchLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(361, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Search", searchPanel);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        statusMenu.setText("Status");
        statusMenu.setToolTipText("");

        workingDirectoryMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error_round_13x13.png"))); // NOI18N
        workingDirectoryMenuItem.setText("Working Directory");
        workingDirectoryMenuItem.setToolTipText("Select the database working directory.");
        workingDirectoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workingDirectoryMenuItemActionPerformed(evt);
            }
        });
        statusMenu.add(workingDirectoryMenuItem);

        synchronizeDirectoryMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error_round_13x13.png"))); // NOI18N
        synchronizeDirectoryMenuItem.setText("Synchronization Directory");
        synchronizeDirectoryMenuItem.setToolTipText("Select the synchronization directory.");
        synchronizeDirectoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                synchronizeDirectoryMenuItemActionPerformed(evt);
            }
        });
        statusMenu.add(synchronizeDirectoryMenuItem);

        synchronizeCheckBox.setText("Synchronize Data Source");
        synchronizeCheckBox.setToolTipText("Copy the data source to the synchronization directory on shut down.");
        synchronizeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                synchronizeCheckBoxActionPerformed(evt);
            }
        });
        statusMenu.add(synchronizeCheckBox);

        menuBar.add(statusMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void workingDirectoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workingDirectoryMenuItemActionPerformed
        contactController.selectWorkingDirectory(this);
    }//GEN-LAST:event_workingDirectoryMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        contactController.closeDatabaseConnection();
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void synchronizeDirectoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_synchronizeDirectoryMenuItemActionPerformed
        contactController.selectSyncDirectory(this);
    }//GEN-LAST:event_synchronizeDirectoryMenuItemActionPerformed

    private void synchronizeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_synchronizeCheckBoxActionPerformed
        contactController.setUseSyncDirectory(synchronizeCheckBox.isSelected());
    }//GEN-LAST:event_synchronizeCheckBoxActionPerformed

    private void majorLookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorLookupButtonActionPerformed
        AcademicMajorDialog dialog = new AcademicMajorDialog(this,true,contactController.getModel());
        ComponentPosition.centerFrame(dialog);
        dialog.setVisible(true);
    }//GEN-LAST:event_majorLookupButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RotcContacts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RotcContacts instance = new RotcContacts();

                RotcContactsModel model = new RotcContactsModel();
                model.addObserver(instance);
                contactController = new RotcContactsController(model);
                contactController.performInitialization();
                contactController.initDatabase();

                ComponentPosition.centerFrame(instance);
                instance.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actLabel;
    private javax.swing.JTextField actTextField;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel gpaLabel;
    private javax.swing.JTextField gpaTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JComboBox majorComboBox;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JButton majorLookupButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollPane;
    private javax.swing.JTextArea notesTextArea;
    private javax.swing.JLabel phoneOneLabel;
    private javax.swing.JTextField phoneOneTextField;
    private javax.swing.JLabel phoneTwoLabel;
    private javax.swing.JTextField phoneTwoTextField;
    private javax.swing.JLabel searchLastNameLabel;
    private javax.swing.JTextField searchLastNameTextField;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenu statusMenu;
    private javax.swing.JButton submitButton;
    private javax.swing.JCheckBoxMenuItem synchronizeCheckBox;
    private javax.swing.JMenuItem synchronizeDirectoryMenuItem;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel totalRecordsLabel;
    private javax.swing.JMenuItem workingDirectoryMenuItem;
    // End of variables declaration//GEN-END:variables

    private void enableMajorSubmitButtons(boolean enable) {
        majorLookupButton.setEnabled(enable);
        submitButton.setEnabled(enable);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof RotcContactsModel){
            RotcContactsModel model = (RotcContactsModel)o;

            //Focus last name field
            if (!lastNameFocus){
                lastNameTextField.requestFocus();
                lastNameFocus = true;
            }

            //Update icon for working directory
            ImageIcon menuItemIcon;
            if (model.isWorkingDirectoryDefined()){
                menuItemIcon = new ImageIcon(getClass().getResource("/images/check_round_13x13.png"));
                enableMajorSubmitButtons(true);
            } else {
                menuItemIcon = new ImageIcon(getClass().getResource("/images/error_round_13x13.png"));
                enableMajorSubmitButtons(false);
            }
            workingDirectoryMenuItem.setIcon(menuItemIcon);

            //Update icon for synchronization directory
            if (model.isSynchronizationDirectoryDefined()){
                menuItemIcon = new ImageIcon(getClass().getResource("/images/check_round_13x13.png"));
            } else {
                menuItemIcon = new ImageIcon(getClass().getResource("/images/error_round_13x13.png"));
            }
            synchronizeDirectoryMenuItem.setIcon(menuItemIcon);

            //Set use sync directory
            synchronizeCheckBox.setSelected(model.isUseSyncDirectory());

            //Update record count label
            totalRecordsLabel.setText("Total Records: " + model.getRecordCount());
            
            //Update academic combo box
            DefaultComboBoxModel majorModel = (DefaultComboBoxModel) majorComboBox.getModel();
            majorModel.removeAllElements();
            for(String s : model.getAcademicMajors()){
                majorModel.addElement(s);
            }
            
        }
    }
}
