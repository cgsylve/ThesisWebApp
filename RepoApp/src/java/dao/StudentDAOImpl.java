/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Huan_Nguyen
 */
public class StudentDAOImpl implements StudentDAO{
    @Override
    public ArrayList findAll() {
       String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.USERS";
       ArrayList aStudentCollection = selectProfilesFromDB(query);
       return aStudentCollection;
    }
    
    @Override
    public ArrayList findAllPending() {
       String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PENDINGUSERS";
       ArrayList aStudentCollection = selectProfilesFromDB(query);
       return aStudentCollection;
    }
    
    private ArrayList selectProfilesFromDB(String query) {
        ArrayList aStudentCollection = new ArrayList();
        Connection DBConn = null;
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp"; //name the database here
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String stuID, password, fname, lname, email, secQ, secA, reason, isAdmin;
            
            Users aStudent;
            while(rs.next()){
                stuID = rs.getString("userID");
                password = rs.getString("pw");
                fname = rs.getString("fName");
                lname = rs.getString("lName");
                email = rs.getString("email");
                secQ = rs.getString("secQ");
                secA = rs.getString("secA");
                reason = rs.getString("reason");
                isAdmin = rs.getString("isAdmin");

                aStudent = new Users(fname, lname, stuID, password, email, secQ, secA, reason, isAdmin);
                aStudentCollection.add(aStudent);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try{
            DBConn.close();
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return aStudentCollection;
    }

    @Override
    public ArrayList findloginSTUID(String aSTUID) {
       String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.USERS ";
        query += "WHERE userID = '" + aSTUID + "'";

        ArrayList aStudentCollection = selectLoginFromStudent(query);
        return aStudentCollection;
    }
    
    @Override
    public ArrayList selectLoginFromStudent(String query) {
        ArrayList aLoginCollection = new ArrayList();
        Connection DBConn = null;
        try {
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            // if doing the above in Oracle: DBHelper.loadDriver("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String userid, password;

            while (rs.next()) {

                userid = rs.getString("userID");
                password = rs.getString("pw");

                aLoginCollection.add(userid);
                aLoginCollection.add(password);
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
        return aLoginCollection;
    }
    
    @Override
    public boolean exist(String aSTUID) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try {

            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryCheck = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.USERS WHERE userID = '" + aSTUID + "'";
            Statement st = DBConn.createStatement();
            ResultSet rs = st.executeQuery(queryCheck); //Check in Users table
            if (rs.next()) {
                DBConn.close();
               return true;
            }
            queryCheck = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PENDINGUSERS WHERE userID = '" + aSTUID + "'";
            st = DBConn.createStatement();
            rs = st.executeQuery(queryCheck); //Check in PendingUsers table
            if (rs.next()) {
                DBConn.close();
               return true;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
    
    @Override
    public ArrayList findBySTUID(String aSTUID) {
       String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.USERS ";
        query += "WHERE userID = '" + aSTUID + "'";

        ArrayList aStudentCollection = selectProfilesFromDB(query);
        return aStudentCollection;
    }
    
     @Override
    public ArrayList findPendBySTUID(String aSTUID) {
       String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PENDINGUSERS ";
        query += "WHERE userID = '" + aSTUID + "'";

        ArrayList aStudentCollection = selectProfilesFromDB(query);
        return aStudentCollection;
    }

    @Override
    public int createUser(Users user) {
        System.out.println(user.getAdmin());
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO CGSYLVE_SP2015_PROJECT353.PENDINGUSERS VALUES ('"
                    + user.getUserID()
                    + "','" + user.getPassword()
                    + "','" + user.getFirstName()
                    + "','" + user.getLastName()
                    + "','" + user.getEmail()
                    + "','" + user.getSecQ()
                    + "','" + user.getSecA()
                    + "','" + user.getReason()
                    + "','" + user.getAdmin()
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
    public boolean pendingUserExists(String userID) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        try {

            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryCheck = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PENDINGUSERS WHERE userID = '" + userID + "'";
            Statement st = DBConn.createStatement();
            ResultSet rs = st.executeQuery(queryCheck); //Check in PendingUsers table
            if (rs.next()) {
                DBConn.close();
               return true;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public int pendingToUser(Users user) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO CGSYLVE_SP2015_PROJECT353.USERS VALUES ('"
                    + user.getUserID()
                    + "','" + user.getPassword()
                    + "','" + user.getFirstName()
                    + "','" + user.getLastName()
                    + "','" + user.getEmail()
                    + "','" + user.getSecQ()
                    + "','" + user.getSecA()
                    + "','" + user.getReason()
                    + "','" + user.getAdmin()
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
    public boolean removePendingUser(Users pendingUser) {
        boolean success = false;
        int returnInt = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String sql;
            Statement stmt = DBConn.createStatement();
            sql = "DELETE FROM CGSYLVE_SP2015_PROJECT353.PENDINGUSERS"
                    + " WHERE userID = '" + pendingUser.getUserID() + "'";

            returnInt = stmt.executeUpdate(sql);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        if(returnInt > 0)
            return success = true;
        else
            return success;
    }

    @Override
    public boolean removeUser(Users pendingUser) {
        boolean success = false;
        int returnInt = 0;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String sql;
            Statement stmt = DBConn.createStatement();
            sql = "DELETE FROM CGSYLVE_SP2015_PROJECT353.USERS"
                    + " WHERE userID = '" + pendingUser.getUserID() + "'";

            returnInt = stmt.executeUpdate(sql);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        if(returnInt > 0)
            return success = true;
        else
            return success;
    }
}
