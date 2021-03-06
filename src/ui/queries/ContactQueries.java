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

    public void deleteContact(String id){
        try {
            Statement statement = dataConnection.createStatement();
            statement.execute("DELETE FROM contacts WHERE id = " + id + ";");
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addContact(Object[] data) {
        try {
            String enrolled = convertBooleanToString((Boolean)data[11]);
            String wings = convertBooleanToString((Boolean)data[12]);
            Statement statement = dataConnection.createStatement();
            statement.execute("INSERT INTO contacts (ContactDate, LastName, FirstName, Phone1, Phone2, GPA, ACTSAT, major, Notes, EmailAddress, Enrolled, Wings)" +
                                " VALUES ({d'" + data[8] + "'},'" + data[0] + "','" + data[1] + "','" + data[2] + "','" + data[3] + "','" +
                                data[4] + "','" + data[5] + "'," + data[6] + ",'" + data[7] + "','" + data[10] + "'," + enrolled + "," + wings + ");");
        } catch (SQLException ex) {
            System.out.println("SQL FUBAR");
        }
    }

    public void updateContact(Object[] data) {
        try {
            String enrolled = convertBooleanToString((Boolean)data[11]);
            String wings = convertBooleanToString((Boolean)data[12]);
            Integer updateId = (Integer) data[9];
            Statement statement = dataConnection.createStatement();
            statement.execute("UPDATE contacts SET LastName = '" + data[0] + "'," +
                              "FirstName = '" + data[1] + "'," +
                              "Phone1 = '" + data[2] + "'," +
                              "Phone2 = '" + data[3] + "'," +
                              "GPA = '" + data[4] + "'," +
                              "ACTSAT = '" + data[5] + "'," +
                              "major = '" + data[6] + "'," +
                              "Notes = '" + data[7] + "'," +
                              "EmailAddress = '" + data[10] + "'," +
                              "Enrolled = " + enrolled + "," +
                              "Wings = " + wings + " " +
                              "WHERE ID = " + updateId.toString() + ";");
        } catch (SQLException ex) {
            System.out.println("SQL FUBAR");
        }
    }

    /**
     * Determines whether a major being deleted exists
     * in the contacts table
     * @param majorID
     * @return
     */
    public boolean majorBeingUsed(String majorID) {
        boolean majorUsed = false;
        try {
            Statement statement = dataConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery("SELECT ID from contacts WHERE major=" + majorID + ";");
            result.last();
            if (result.getRow() != 0){
                majorUsed = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return majorUsed;
    }

    public ResultSet contactSearch(String searchValue) {
        ResultSet result = null;
            if (!searchValue.isEmpty()){
                try {
                    String searchPattern = "'" + searchValue + "%'";
                    Statement statement = dataConnection.createStatement();
                    result = statement.executeQuery("SELECT * FROM contacts WHERE LastName LIKE " + searchPattern);
                } catch (SQLException ex) {
                    Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return result;
    }

    public ResultSet getContactRecord(String selectedIndex) {
        ResultSet result = null;
        try {
            Statement statement = dataConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            result = statement.executeQuery("SELECT * from contacts WHERE ID=" + selectedIndex + ";");
        } catch (SQLException ex) {
            Logger.getLogger(ContactQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private String convertBooleanToString(boolean b) {
         String result = "0";
         if (b) {
             result = "1";
         }
         return result;
    }

}
