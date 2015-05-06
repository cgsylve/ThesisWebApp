/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchDAOImpl;
import dao.StudentDAOImpl;
import dao.StudentDAO;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ProjectBean;
import model.Users;

/**
 *
 * @author crsage
 */
@ManagedBean(name="adminController")
@SessionScoped
public class AdminController {
    private Users pendingUser;
    private ProjectBean project;
    private String userID;
    private ArrayList<Users> users;
    
    public ArrayList<Users> getUsers(){
        return users;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public AdminController(){
        pendingUser = new Users(); 
    }
    
    public AdminController(String firstName, String lastName, String userID, String password,
            String email, String secQ, String secA, String reason, String isAdmin){
        pendingUser = new Users(firstName, lastName, userID, password,
             email, secQ, secA, reason, isAdmin);
    }
    
    public Users getPendingUser(){
        return pendingUser;
    }
    
    public void setPendingUser(Users pendingUser){
        this.pendingUser = pendingUser;
    }
    
    public ProjectBean getProject(){
        return project;
    }
    
    public void setProject(ProjectBean project){
        this.project = project;
    }
    
    public static boolean pendingUserExists(String userID){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        return(aProfileDAO.pendingUserExists(userID));
    }
    
    public ArrayList populatePendingUserTable(){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        ArrayList<Users> pendingUsers = aProfileDAO.findAllPending();
        return pendingUsers;
    }
    
    public ArrayList<Users> populateUserTable(){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        ArrayList<Users> users1 = aProfileDAO.findAll();
        return users1;
    }
    
    public Users getPendingUser(String userID){
        StudentDAO DAO = new StudentDAOImpl();
        ArrayList<Users> arrL = DAO.findBySTUID(userID);
        pendingUser = arrL.get(0);
        return pendingUser;
    }
    
    public String approveUser(){
        //need to move user to Users table
        StudentDAO aProfileDAO = new StudentDAOImpl(); 
//        ArrayList<Users> arrL = aProfileDAO.findPendBySTUID(userID);
//        pendingUser = arrL.get(0);
        boolean success = aProfileDAO.removePendingUser(pendingUser);
        if(success){
            int rowCount = aProfileDAO.pendingToUser(pendingUser); 
        }
        
        //need to send confirmation email that the users accoutn ahs been approved
        return null;
    }
    
    public String approveAdminUser(){
        //need to move user to Users table
        StudentDAO aProfileDAO = new StudentDAOImpl(); 
//        ArrayList<Users> arrL = aProfileDAO.findPendBySTUID(userID);
//        pendingUser = arrL.get(0);
        boolean success = aProfileDAO.removePendingUser(pendingUser);
        if(success){
            pendingUser.setAdmin("TRUE");
            int rowCount = aProfileDAO.pendingToUser(pendingUser); 
        }
        
        //need to send confirmation email that the users accoutn ahs been approved
        return null;
    }
    
    public void removeUser(){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        boolean success = aProfileDAO.removeUser(pendingUser);
        System.out.println(success);
    }
    
    public void markAsFeatured(){
        SearchDAOImpl searchDAO = new SearchDAOImpl();
        project.setFeatured("TRUE");
        boolean result = searchDAO.markFeatured(project);
    }
    
    
    
}
