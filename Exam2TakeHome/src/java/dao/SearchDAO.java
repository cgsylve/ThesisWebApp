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
import model.ScheduledTime;

/**
 *
 * @author calebsylvester
 */
public class SearchDAO {
    
//    public int checkAvail(String userTimeSelected, String userGroupName){
//        int avail = 0;
//        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//        } catch (ClassNotFoundException e) {
//            System.err.println(e.getMessage());
//            System.exit(0);
//        }
//        
//         
//        try{
//            String myDB = "jdbc:derby://localhost:1527/DemoTime";
//            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
//            Statement stmt = DBConn.createStatement();
//            String checkString; 
//           
//            
//            checkString = "SELECT * FROM SCHEDULE "
//                            + "WHERE TIMESLOT = " + "'" + userTimeSelected + "'";
//            
//            ResultSet rs = stmt.executeQuery(checkString);
//            
//            String timeSlot;
//            String groupName; 
//            
//            while (rs.next()){
//                timeSlot = rs.getString("TIMESLOT");
//                groupName = rs.getString("GROUPNAME");
//                
//                if(groupName.equals("null")){
//                    
//                }
//            }
//            rs.close();
//            stmt.close();
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//        } 
//                
//        return avail; 
//    }
    
    public int signUp(String userTimeSelected, String userGroupName){
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
         
        try {
            String myDB = "jdbc:derby://localhost:1527/DemoTime";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String insertString;
            
            Statement stmt = DBConn.createStatement();
            
           
            
            insertString ="UPDATE SCHEDULE " 
                    +"SET GROUPNAME = " 
                    + "'" + userGroupName + "'"
                    +" WHERE TIMESLOT = " + "'" + userTimeSelected + "'";
                   
            
             rowCount = stmt.executeUpdate(insertString);
             
              System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
    
    public ArrayList getRecords(String userTimeSelected, String userGroupName){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        
       
        
        String query = "SELECT * FROM SCHEDULE"; 
        
        ScheduledTime st; 
        ArrayList timeCollection = new ArrayList(); 
        
        try{
            //prep DB for queries
            
            String myDB = "jdbc:derby://localhost:1527/DemoTime";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            //load query
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            String timeSlot, groupName; 
            
            while (rs.next()){
                timeSlot = rs.getString("TIMESLOT");
                groupName = rs.getString("GROUPNAME");
                
                st = new ScheduledTime(timeSlot, groupName);
                timeCollection.add(st);
            }
            rs.close();
            stmt.close();
        
        }   catch (Exception err){
            System.out.println(err.getMessage());
        }
        return timeCollection; 
    }
    
   

}
