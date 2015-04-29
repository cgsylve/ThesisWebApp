/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import model.UploadBean;

/**
 *
 * @author Huan_Nguyen
 */
public class UploadDAOImpl {
    public int updateRecords(UploadBean uploadBean){
        Connection DBConn = null; 
        
        String updateString = "INSERT INTO CGSYLVE_SP2015_PROJECT353.PROJECTTABLE VALUES (uploadBean.courseNumber, uploadBean.liveLink, uploadBean.keyWordDone, uploadBean.committeeChair, uploadBean.semesterComplete, uploadBean.studentName, uploadBean.dateCompleted, uploadBean.UserID)" ;
        
        int rowCount = 0; 
        
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            Statement stmt = DBConn.createStatement();
            rowCount = stmt.executeUpdate(updateString);
            
            System.out.println("Update String: " + updateString);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return rowCount; 
        
        
    }
}
