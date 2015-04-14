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
import model.StudentBean;

/**
 *
 * @author Huan_Nguyen
 */
public class StudentDAOImpl implements StudentDAO{
    @Override
    public ArrayList findAll() {
       String query = "SELECT * FROM TABLE.USERS";
       ArrayList aStudentCollection = selectProfilesFromDB(query);
       return aStudentCollection;
    }
    
    private ArrayList selectProfilesFromDB(String query) {
        ArrayList aStudentCollection = new ArrayList();
        Connection DBConn = null;
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/IT353Project"; //name the database here
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String stuID, password, fname, lname, email, secQ, secA, reason, isAdmin;
            
            StudentBean aStudent;
            while(rs.next()){
                stuID = rs.getString("STUID");
                password = rs.getString("PASSWORD");
                fname = rs.getString("FNAME");
                lname = rs.getString("LNAME");
                email = rs.getString("EMAIL");
                secQ = rs.getString("SECQ");
                secA = rs.getString("SECA");
                reason = rs.getString("REASON");
                isAdmin = rs.getString("ISADMIN");

                aStudent = new StudentBean(stuID, password, fname, lname, email, secQ, secA, reason, isAdmin);
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
       String query = "SELECT * FROM TABLE.USERS ";
        query += "WHERE STUID = '" + aSTUID + "'";

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
            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/IT353Project";
            // if doing the above in Oracle:  String myDB = "jdbc:oracle:thin:@oracle.itk.ilstu.edu:1521:ora478";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

            // With the connection made, create a statement to talk to the DB server.
            // Create a SQL statement to query, retrieve the rows one by one (by going to the
            // columns), and formulate the result string to send back to the client.
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String userid, password;

            while (rs.next()) {

                userid = rs.getString("STUID");
                password = rs.getString("PASSWORD");

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

            String myDB = "jdbc:derby://gfish.it.ilstu.edu:1527/IT353Project";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryCheck = "SELECT * from TABLE.USERS WHERE STUID = '" + aSTUID + "'";
            Statement st = DBConn.createStatement();
            ResultSet rs = st.executeQuery(queryCheck); // execute the query, and get a java resultset
            // if this ID already exists, we quit
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
       String query = "SELECT * FROM TABLE.USERS ";
        query += "WHERE STUID = '" + aSTUID + "'";

        ArrayList aStudentCollection = selectProfilesFromDB(query);
        return aStudentCollection;
    }
}
