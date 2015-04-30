/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Thesis;

/**
 *
 * @author calebsylvester
 */
public class MailDAOImpl {
    
    public int addToList(String email){
        
        Connection DBConn = null; 
        
        String insertString = "INSERT INTO CGSYLVE_SP2015_PROJECT353.MAIL VALUES " 
                + "'" + email + "'";
        int rowCount = 0; 
        
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            //load query
            
            Statement stmt = DBConn.createStatement();
           rowCount = stmt.executeUpdate(insertString);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return rowCount; 
    }
    
    public int removeFromList(String email){
        Connection DBConn = null; 
        
        String insertString = "DELETE FROM CGSYLVE_SP2015_PROJECT353.MAIL " 
                + "WHERE EMAIL = '" + email + "'";
        int rowCount = 0; 
        
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            //load query
            
            Statement stmt = DBConn.createStatement();
           rowCount = stmt.executeUpdate(insertString);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return rowCount; 
    }
}
