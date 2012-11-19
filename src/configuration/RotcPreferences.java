
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
    private final String WORK_DIR_SET = "work_dir_set";
    private final String SYNC_DIR_SET = "sync_dir_set";
    private final String USE_SYNC = "use_sync_dir";
    private Preferences prefs;
    private static RotcPreferences rotcPrefs = null;

    private RotcPreferences() {
        this.prefs = Preferences.systemNodeForPackage(this.getClass());
    }

    public static RotcPreferences getRotcPreferences() {
        if (rotcPrefs == null){
            rotcPrefs = new RotcPreferences();
        }
        return rotcPrefs;
    }

    public String getWorkDir() {
        return prefs.get(WORK_DIR, "C:/Program Files");
    }

    public String getSyncDir() {
        return prefs.get(SYNC_DIR, "C:/Program Files");
    }

    public void setWorkDir(String dirPath) {
        prefs.put(WORK_DIR, dirPath);
    }

    public void setSyncDir(String dirPath) {
        prefs.put(SYNC_DIR, dirPath);
    }

    public boolean getWorkDirSet() {
        return prefs.getBoolean(WORK_DIR_SET, false);
    }

    public void setWorkDirSet(boolean setValue) {
        prefs.putBoolean(WORK_DIR_SET, setValue);
    }

    public boolean getSyncDirSet() {
        return prefs.getBoolean(SYNC_DIR_SET, false);
    }

    public void setSyncDirSet(boolean setValue) {
        prefs.putBoolean(SYNC_DIR_SET, setValue);
    }
    
    public boolean useSyncDirectory() {
        return prefs.getBoolean(USE_SYNC, false);
    }
    
    public void setUseSyncDirectory(boolean setValue) {
        prefs.putBoolean(USE_SYNC, setValue);
    }
}
