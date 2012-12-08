
package ui.contactform;

import database.MSAccessConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.queries.ContactQueries;

/**
 *
 * @author javarobots
 */
public class RotcContactsModel extends Observable {

    private boolean workingDirectoryDefined = false;
    private boolean synchronizationDirectoryDefined = false;
    private boolean useSyncDirectory = false;
    private boolean enableButtons = false;
    private MSAccessConnection dataSourceConnection;
    private ContactQueries queries;
    private int recordCount = 0;
    private Map<String, Integer> majorMap;
    private boolean updateData = false;

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

    public void setMSAccessConnection(MSAccessConnection connection) throws SQLException{
            this.dataSourceConnection = connection;
            queries = new ContactQueries(dataSourceConnection.getConnection());
            recordCount = queries.getContactCount();
            setChanged();
    }

    public Connection getDatabaseConnection(){
        Connection connection = null;
        try {
            connection = dataSourceConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RotcContactsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int count) {
        recordCount = count;
        setChanged();
    }

    public ContactQueries getQueries() {
        return queries;
    }

    public boolean isEnableButtons() {
        return enableButtons;
    }

    public void setEnableButtons(boolean enableButtons) {
        this.enableButtons = enableButtons;
        setChanged();
    }

    public boolean isUpdateData() {
        return updateData;
    }

    public void setUpdateData(boolean updateData) {
        this.updateData = updateData;
        setChanged();
    }

    public Map<String, Integer> getMajorMap() {
        return majorMap;
    }

    public void setMajorMap(Map<String, Integer> majorMap) {
        this.majorMap = majorMap;
        setChanged();
    }

}
