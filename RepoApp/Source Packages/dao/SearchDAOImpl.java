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
import model.ProjectBean;

/**
 *
 * @author calebsylvester
 */
public class SearchDAOImpl {
    
    
    public ArrayList searchProjects(String query){
        
        Connection DBConn = null; 
        ArrayList projectCollection = new ArrayList(); 
        ProjectBean project; 
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
                
                project = new ProjectBean(courseNumber, liveLink, key1, chair, semCompleted, stuName, dateCompleted);
                projectCollection.add(project);
            }
            rs.close();
            stmt.close();
        
        }   catch (Exception err){
            System.out.println(err.getMessage());
        }
        return projectCollection; 
    }
    
    
}
