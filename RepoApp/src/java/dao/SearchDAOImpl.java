/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Thesis;
import model.ProjectBean;

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
    
    public ArrayList searchSimilarProjects(String searchType, String searchTerm, String addTerm, String addCat){
        
        
        Connection DBConn = null; 
        
        String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PROJECTTABLE " 
                + "WHERE " + searchType + "= '" + searchTerm + "' "
                + "AND " + addCat + "= '" + addTerm + "'";
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
    
    public ArrayList findAllProjects() {
        ArrayList projects = new ArrayList();
        String query = "SELECT * FROM CGSYLVE_SP2015_PROJECT353.PROJECTTABLE";                
        Connection DBConn = null;
        try{
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://gfish2.it.ilstu.edu:1527/cgsylve_Sp2015_RepoApp"; //name the database here
            DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted, featured;
            ProjectBean project;        
            while(rs.next()){
                courseNumber = rs.getString("COURSENUMBER");
                liveLink = rs.getString("LIVELINK");
                key1 = rs.getString("KEYWORDONE");               
                chair = rs.getString("COMMITTEECHAIR");
                semCompleted = rs.getString("SEMESTERCOMPLETED");
                stuName = rs.getString("STUDENTNAME");
                dateCompleted = rs.getString("DATECOMPLETED");
                featured = rs.getString("FEATURED");

                project = new ProjectBean(courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted, featured);
                projects.add(project);
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
        return projects;
    }
    
    public boolean markFeatured(ProjectBean project){
        System.out.println(project.getStudentName());
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
            sql = "UPDATE CGSYLVE_SP2015_PROJECT353.PROJECTTABLE SET FEATURED = 'TRUE' WHERE STUDENTNAME = '" + project.getStudentName() + "'";
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
    
    

