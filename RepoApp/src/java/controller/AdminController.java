/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDAOImpl;
import dao.StudentDAO;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Users;

/**
 *
 * @author crsage
 */
@ManagedBean(name="adminController")
@SessionScoped
public class AdminController {
    private Users pendingUser;
    private String userID;
    
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
    
    public Users getUser(){
        return pendingUser;
    }
    
    public void setUser(Users pUser){
        pendingUser = pUser;
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
    
    public Users getPendingUser(String userID){
        StudentDAO DAO = new StudentDAOImpl();
        ArrayList<Users> arrL = DAO.findBySTUID(userID);
        pendingUser = arrL.get(0);
        return pendingUser;
    }
    
    public String approveUser(){
        //need to move user to Users table
        StudentDAO aProfileDAO = new StudentDAOImpl(); 
        System.out.println(userID);
        ArrayList<Users> arrL = aProfileDAO.findPendBySTUID(userID);
        pendingUser = arrL.get(0);
        System.out.println(pendingUser.toString());
        boolean success = aProfileDAO.removePendingUser(pendingUser);
        if(success){
            int rowCount = aProfileDAO.pendingToUser(pendingUser); 
        }
        
        //need to send confirmation email that the users accoutn ahs been approved
        return null;
    }
}
