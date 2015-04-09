/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Users;

/**
 *
 * @author admin
 */
public class ProfileDAOImpl implements ProfileDAO {

    @Override
    public int createProfile(Users newUser) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/project353";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO Project353.Users VALUES ('"
                    + newUser.getUserID()
                    + "','" + newUser.getFirstName()
                    + "','" + newUser.getLastName()
                    + "','" + newUser.getPassword()
                    + "','" + newUser.getEmail()
                    + "','" + newUser.getSecQ()
                    + "','" + newUser.getSecA()
                    + "')";

            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public ArrayList findAll() {

        String query = "SELECT * FROM Project353.Users";
        ArrayList aUserCollection = selectUsersFromDB(query);
        return aUserCollection;

    }

    private ArrayList selectUsersFromDB(String query) {
        ArrayList aProfileBeanCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://localhost:1527/Project353";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String userID, firstName, lastName, password, email, secQ, secA;
            Users user;
            while (rs.next()) {
                // 1. if a float (say PRICE) is to be retrieved, use rs.getFloat("PRICE");
                // 2. Instead of using column name, can alternatively use: rs.getString(1); // not 0
                userID = rs.getString("UserID");
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                password = rs.getString("Password");
                email = rs.getString("Email");
                secQ = rs.getString("SecQ");
                secA = rs.getString("SecA");
                // make a ProfileBean object out of the values
                user = new Users(userID, firstName, lastName, password, email, secQ, secA);
                // add the newly created object to the collection
                aProfileBeanCollection.add(user);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aProfileBeanCollection;
    }

    @Override
    public ArrayList findByUserID(String userID) {
        // if interested in matching wild cards, use: LIKE and '%" + aName + "%'";
        String query = "SELECT * FROM Project353.Users ";
        query += "WHERE userID = '" + userID + "'";

        ArrayList aProfileCollection = selectUsersFromDB(query);
        return aProfileCollection;
    }
    
    @Override
    public boolean userIDExists(String userID){
        String query = "SELECT * FROM Project353.Users WHERE userID = '"
                + userID + "'";
        ArrayList aProfileCollection = selectUsersFromDB(query);
        return(aProfileCollection.size() > 0);
    }
}
