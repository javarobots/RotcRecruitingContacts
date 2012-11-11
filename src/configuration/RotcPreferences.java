
package configuration;

import java.util.prefs.Preferences;

/**
 * A preference class for storing synchronization and
 * working directory paths and other application
 * preferences.
 *
 * @author javarobots
 */
public class RotcPreferences {

    private final String WORK_DIR = "working_directory";
    private final String SYNC_DIR = "sync_directory";
    private Preferences prefs;

    public RotcPreferences() {
        this.prefs = Preferences.systemNodeForPackage(this.getClass());
    }

    public String getWorkDir() {
        return prefs.get(WORK_DIR, "C:/Program Files/RotcContacts");
    }

    public String getSyncDir() {
        return prefs.get(SYNC_DIR, "C:/Program Files/RotcContactsSync");
    }

    public void setWorkDir(String dirPath) {
        prefs.put(WORK_DIR, dirPath);
    }

    public void setSyncDir(String dirPath) {
        prefs.put(SYNC_DIR, dirPath);
    }
}
