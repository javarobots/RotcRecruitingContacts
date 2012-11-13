
package ui.contactform;

import java.util.Observable;

/**
 *
 * @author javarobots
 */
public class RotcContactsModel extends Observable {

    private boolean workingDirectoryDefined = false;
    private boolean synchronizationDirectoryDefined = false;

    public boolean isWorkingDirectoryDefined() {
        return workingDirectoryDefined;
    }

    public void setWorkingDirectoryDefined(boolean workingDirectoryDefined) {
        this.workingDirectoryDefined = workingDirectoryDefined;
        setChanged();
    }

    public boolean isSynchronizationDirectoryDefined() {
        return synchronizationDirectoryDefined;
    }

    public void setSynchronizationDirectoryDefined(boolean synchronizationDirectoryDefined) {
        this.synchronizationDirectoryDefined = synchronizationDirectoryDefined;
        setChanged();
    }
    
    

}
