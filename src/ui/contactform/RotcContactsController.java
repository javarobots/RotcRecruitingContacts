
package ui.contactform;

import configuration.RotcPreferences;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
        model.notifyObservers();
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

}
