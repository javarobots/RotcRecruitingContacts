
package ui.contactform;

import database.MSAccessConnection;
import java.sql.Connection;
import java.util.Observable;
import ui.queries.ContactQueries;

/**
 *
 * @author javarobots
 */
public class RotcContactsModel extends Observable {

    private boolean workingDirectoryDefined = false;
    private boolean synchronizationDirectoryDefined = false;
    private boolean useSyncDirectory = false;
    private MSAccessConnection dataSourceConnection;
    private ContactQueries queries;
    private int recordCount = 0;

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

    public boolean isUseSyncDirectory() {
        return useSyncDirectory;
    }

    public void setUseSyncDirectory(boolean useSyncDirectory) {
        this.useSyncDirectory = useSyncDirectory;
        setChanged();
    }
    
    public void setMSAccessConnection(MSAccessConnection connection){
        this.dataSourceConnection = connection;
        ContactQueries query = new ContactQueries(dataSourceConnection.getConnection());
        recordCount = query.getContactCount();
        setChanged();
    }
    
    public Connection getDatabaseConnection(){
        return dataSourceConnection.getConnection();
    }

    public int getRecordCount() {
        return recordCount;
    }
    
    public void setRecordCount(int count) {
        recordCount = count;
    }
}
