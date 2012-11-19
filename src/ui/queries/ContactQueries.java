/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author javarobots74
 */
public class ContactQueries {
    
    private Connection dataConnection;
    
    public ContactQueries(Connection connection) {
        this.dataConnection = connection;
    }
    
    public int getContactCount(){
        int count = 0;
        try{
        ResultSet result;
        result = dataConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("Select * From contacts");
        result.last();
        count = result.getRow();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }
    
}
