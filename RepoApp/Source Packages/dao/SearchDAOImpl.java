/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Thesis;

/**
 *
 * @author calebsylvester
 */
public class SearchDAOImpl {
    
    
    public ArrayList searchProjects(String searchType, String searchTerm){
        
        Connection DBConn = null; 
        
        String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PROJECTTABLE " 
                + "WHERE " + searchType + "= '" + searchTerm + "'";
        Thesis thesis; 
        ArrayList projectCollection = new ArrayList(); 
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            //load query
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            String courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted; 
            while (rs.next()){
                courseNumber = rs.getString("COURSENUMBER");
                liveLink = rs.getString("LIVELINK");
                key1 = rs.getString("KEYWORDONE");               
                chair = rs.getString("COMMITTEECHAIR");
                semCompleted = rs.getString("SEMESTERCOMPLETED");
                stuName = rs.getString("STUDENTNAME");
                dateCompleted = rs.getString("DATECOMPLETED");
                
                thesis = new Thesis(courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted);
                projectCollection.add(thesis);
            }
            rs.close();
            stmt.close();
        
        }   catch (Exception err){
            System.out.println(err.getMessage());
        }
        return projectCollection; 
    }
    
    public ArrayList searchMyProjects(String username){
        Connection DBConn = null; 
        
        String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PROJECTTABLE " 
                + "WHERE USERID = '" + username + "'";
        
        Thesis thesis; 
        ArrayList projectCollection = new ArrayList(); 
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            //load query
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query); 
            String courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted; 
            while (rs.next()){
                courseNumber = rs.getString("COURSENUMBER");
                liveLink = rs.getString("LIVELINK");
                key1 = rs.getString("KEYWORDONE");               
                chair = rs.getString("COMMITTEECHAIR");
                semCompleted = rs.getString("SEMESTERCOMPLETED");
                stuName = rs.getString("STUDENTNAME");
                dateCompleted = rs.getString("DATECOMPLETED");
                
                thesis = new Thesis(courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted);
                projectCollection.add(thesis);
            }
            rs.close();
            stmt.close();
        
        }   catch (Exception err){
            System.out.println(err.getMessage());
        }
        return projectCollection; 
    }
    
    public int updateDetails(String courseNumber, String liveLink, String key1, String chair, String semCompleted, String stuName, String dateCompleted){
        Connection DBConn = null; 
        
        int rowCount = 0; 
        
        
        
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp";
            DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
            
            String insertString = ""; 
            //load query
            
            Statement stmt = DBConn.createStatement();
            rowCount = stmt.executeUpdate(insertString);
            stmt.close();
        
        }   catch (Exception err){
            System.out.println(err.getMessage());
        }  
        return rowCount; 
    }
    }
    
    
//    public ArrayList findAll() {
//
//        String query = "SELECT * FROM PROJECTTABLE";
//        ArrayList aProfileCollection = searchProjects(query);
//        return aProfileCollection;
//
//    }
    
    

