/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.javafx.scene.CameraHelper.project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.ProjectBean;
import model.Thesis;

/**
 *
 * @author calebsylvester
 */
public class SearchDAOImpl {
    
    
    public ArrayList searchProjects(String searchType, String searchTerm){
        
        Connection DBConn = null; 
        
        String query = "SELECT * FROM PROJECTTABLE " 
                + "WHERE " + searchType + "= '" + searchTerm + "'";
        Thesis thesis; 
        ArrayList projectCollection = new ArrayList(); 
        
        try{
            //prep DB for queries
            DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
            String myDB = "jdbc:derby://localhost:1527/LocalProjectDatabase";
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
    
    
//    public ArrayList findAll() {
//
//        String query = "SELECT * FROM PROJECTTABLE";
//        ArrayList aProfileCollection = searchProjects(query);
//        return aProfileCollection;
//
//    }
    
    
}
