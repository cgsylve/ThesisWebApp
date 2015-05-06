/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import model.UploadBean;

/**
 *
 * @author Huan_Nguyen
 */
public class UploadDAOImpl {
    //public int updateRecords(UploadBean uploadBean){
    public int updateRecords(String courseNumber,String liveLink,String keyWordOne,String committeeChair,String semesterComplete,String studentName,String dateCompleted,String userID){
        //Connection DBConn = null; 
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0; 
        try{
        String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
        Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
        
        String updateString;
        Statement stmt = DBConn.createStatement();
        updateString = "INSERT INTO CGSYLVE_SP2015_PROJECT353.PROJECTTABLE VALUES ('"
                + courseNumber
                + "','" + liveLink
                + "','" + keyWordOne
                + "','" + committeeChair
                + "','" + semesterComplete
                + "','" + studentName
                + "','" + dateCompleted
                + "','" + userID
                + "','" + "FALSE"
                + "')";
        
//        + uploadBean.getCourseNumber()
//                + "','" + uploadBean.getLiveLink()
//                + "','" + uploadBean.getKeyWordOne()
//                + "','" + uploadBean.getCommitteeChair()
//                + "','" + uploadBean.getSemesterComplete()
//                + "','" + uploadBean.getStudentName()
//                + "','" + uploadBean.getDateCompleted()
//                + "','" + uploadBean.getUserID()
//                + "')";
        
            //DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            //String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            //DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            //Statement stmt = DBConn.createStatement();
            rowCount = stmt.executeUpdate(updateString); 
            System.out.println("Update String: " + updateString);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return rowCount; 
        
        
    }
}
