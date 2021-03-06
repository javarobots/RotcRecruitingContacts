
package ui.contactform;

import configuration.RotcPreferences;
import database.MSAccessConfiguration;
import database.MSAccessConnection;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.commons.io.FileUtils;
import ui.dialog.BadConfigurationDialog;
import ui.utility.ComponentPosition;

/**
 *
 * @author javarobots
 */
public class RotcContactsController {

    private RotcContactsModel model;
    private final String DATA_SOURCE_NAME = "rotcContacts";
    private final String DATA_SOURCE_FILE_NAME = "contacts.mdb";

    public RotcContactsController(RotcContactsModel model) {
        this.model = model;
    }

    /**
     * Check for the existence of a serialized configuration file at the
     * default location. Then update the model with appropriate file
     * path information.
     */
    public void performInitialization() {
        //Init the database connection
        MSAccessConfiguration databaseConfig = new MSAccessConfiguration(DATA_SOURCE_NAME, DATA_SOURCE_FILE_NAME);

        try {
            model.setMSAccessConnection(new MSAccessConnection(databaseConfig));
            model.setEnableButtons(true);

            //Init academic major list
            ResultSet majors = model.getQueries().getAcademicMajors();
            Map<String,Integer> majorMap = new HashMap<>();
            while(majors.next()){
                String major = majors.getString("major");
                int majorID = majors.getInt("ID");
                majorMap.put(major, majorID);
            }
            model.setMajorMap(majorMap);
        } catch (SQLException ex) {
            showBadConfigurationDialog(DATA_SOURCE_NAME, DATA_SOURCE_FILE_NAME);
        }
        model.notifyObservers();
    }

    public void initDatabase() {
        RotcPreferences prefs = RotcPreferences.getRotcPreferences();
        model.setWorkingDirectoryDefined(prefs.getWorkDirSet());
        model.setSynchronizationDirectoryDefined(prefs.getSyncDirSet());
        model.setUseSyncDirectory(prefs.useSyncDirectory());

        if (model.isWorkingDirectoryDefined()){
            File dataSourceFile = new File(prefs.getWorkDir(), DATA_SOURCE_FILE_NAME);
            if (!dataSourceFile.exists()){
                try {
                    File sourceFile = new File((getClass().getResource("/resources/contacts.mdb")).toURI());
                    FileUtils.copyFile(sourceFile, dataSourceFile);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(RotcContactsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void selectWorkingDirectory(JFrame frame) {
        RotcPreferences prefs = RotcPreferences.getRotcPreferences();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setSelectedFile(new File(prefs.getWorkDir()));
        int success = chooser.showDialog(frame, "Select");
        if (0 == success){
            prefs.setWorkDir(chooser.getSelectedFile().getAbsolutePath());
            prefs.setWorkDirSet(true);
            model.setWorkingDirectoryDefined(true);
            model.notifyObservers();
        }
    }

    public void selectSyncDirectory(JFrame frame) {
        RotcPreferences prefs = RotcPreferences.getRotcPreferences();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setSelectedFile(new File(prefs.getSyncDir()));
        int success = chooser.showDialog(frame, "Select");
        if (0 == success){
            prefs.setSyncDir(chooser.getSelectedFile().getAbsolutePath());
            prefs.setSyncDirSet(true);
            model.setSynchronizationDirectoryDefined(true);
            model.notifyObservers();
        }
    }

    public void setUseSyncDirectory(boolean selected) {
        RotcPreferences prefs = RotcPreferences.getRotcPreferences();
        prefs.setUseSyncDirectory(selected);
    }

    public void closeDatabaseConnection() {
        try {
            Connection connection = model.getDatabaseConnection();
            if (connection != null){
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RotcContactsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RotcContactsModel getModel(){
        return model;
    }

    public void submitData(Object[] data, boolean dataUpdate) {
        Integer majorID = model.getMajorMap().get(data[6].toString());
        data[6] = majorID.toString();
        if (!dataUpdate){
            model.getQueries().addContact(data);
        }
        else {
            model.getQueries().updateContact(data);
        }
        model.setRecordCount(model.getQueries().getContactCount());
        model.notifyObservers();
    }

    private void showBadConfigurationDialog(String dataSourceName, String dataSourceFileName) {
        BadConfigurationDialog dialog = new BadConfigurationDialog(null, true);
        dialog.setNames(dataSourceName, dataSourceFileName);
        ComponentPosition.centerFrame(dialog);
        dialog.setVisible(true);
    }

    public String getDataSourceFileName() {
        return DATA_SOURCE_FILE_NAME;
    }

}
