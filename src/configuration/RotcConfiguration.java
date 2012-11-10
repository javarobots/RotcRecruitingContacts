package configuration;

import java.io.Serializable;

/**
 *
 * @author javarobots
 */
public class RotcConfiguration implements Serializable {

    private String workingDirectoryPath = "C:/Program Files/Rotc Contacts";
    private String synchronizationDirectoryPath;

    public String getWorkingDirectoryPath() {
        return workingDirectoryPath;
    }

    public void setWorkingDirectoryPath(String workingDirectoryPath) {
        this.workingDirectoryPath = workingDirectoryPath;
    }

    public String getSynchronizationDirectoryPath() {
        return synchronizationDirectoryPath;
    }

    public void setSynchronizationDirectoryPath(String synchronizationDirectoryPath) {
        this.synchronizationDirectoryPath = synchronizationDirectoryPath;
    }



}
