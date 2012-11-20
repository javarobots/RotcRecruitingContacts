
package ui.contactform;

import configuration.RotcPreferences;
import database.MSAccessConfiguration;
import database.MSAccessConnection;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author javarobots
 */
public class RotcContactsController {

    private RotcContactsModel model;

    public RotcContactsController(RotcContactsModel model) {
        this.model = model;
    }

    /**
     * Check for the existence of a serialized configuration file at the
     * default location. Then update the model with appropriate file
     * path information.
     */
    public void performInitialization() {
        RotcPreferences prefs = RotcPreferences.getRotcPreferences();
        model.setWorkingDirectoryDefined(prefs.getWorkDirSet());
        model.setSynchronizationDirectoryDefined(prefs.getSyncDirSet());
        model.setUseSyncDirectory(prefs.useSyncDirectory());

        //Init the database connection
        MSAccessConfiguration databaseConfig = new MSAccessConfiguration("rotcContacts", "contacts.mdb");
        model.setMSAccessConnection(new MSAccessConnection(databaseConfig));

        model.notifyObservers();
    }

    public void initDatabase() {
        if (model.isWorkingDirectoryDefined()){
            RotcPreferences prefs = RotcPreferences.getRotcPreferences();
            File dataSourceFile = new File(prefs.getWorkDir(), "contacts.mdb");
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
            model.getDatabaseConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(RotcContactsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RotcContactsModel getModel(){
        return model;
    }

}
