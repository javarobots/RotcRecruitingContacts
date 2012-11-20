/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        result = dataConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM contacts");
        result.last();
        count = result.getRow();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public ResultSet getAcademicMajors(){
        ResultSet result = null;
        try {
            Statement statement = dataConnection.createStatement();
            result = statement.executeQuery("SELECT * FROM majors ORDER BY major;");
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void addAcademicMajor(String major){
        try {
            Statement statement = dataConnection.createStatement();
            statement.execute("INSERT INTO majors(major) VALUES('" + major + "');");
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAcademicMajor(String id){
        try {
            Statement statement = dataConnection.createStatement();
            statement.execute("DELETE FROM majors WHERE id = " + id + ";");
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
