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
 * @author Coty
 */
@ManagedBean(name="signInController")
@SessionScoped
public class SignInController {
    private Users theModel;
    private boolean loggedIn = false;
    
    public SignInController(){
        theModel = new Users();
    }
    
    public Users getTheModel(){
        return theModel;
    }
    
    public void setTheModel(Users theModel){
        this.theModel = theModel;
    }
    
    public String signIn(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        StudentDAO aProfileDAO = new StudentDAOImpl(); 
        ArrayList<Users> user = aProfileDAO.findBySTUID(theModel.getUserID());
        System.out.print("Test1:");
        System.out.println(user.get(0).getUserID());
        if(user.size() > 0){
            System.out.print("test2: ");
            String storedPass = user.get(0).getPassword();
            System.out.println(user.get(0).getPassword());
            if(storedPass.equals(theModel.getPassword())){
                System.out.println("Logged In!");
                loggedIn = true;
                return "loginSuccess.xhtml?faces-redirect=true";
            }
            else{
                context.addMessage(null, new FacesMessage("Incorrect Password!"));
            }
        }
        else{
            context.addMessage(null, new FacesMessage("User ID Does Not Exist!"));
        }
        if(context.getMessageList().size() > 0)
            return(null);
        return "loginFailed.xhtml?faces-redirect=true";
    }
    
}