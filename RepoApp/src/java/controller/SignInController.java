/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDAOImpl;
import dao.StudentDAO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author Coty
 */
@ManagedBean(name="signInController")
@SessionScoped
public class SignInController implements Serializable{
    private Users theModel;
    private Users signedInUser;
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
        if(user.size() > 0){
            String storedPass = user.get(0).getPassword();
            if(storedPass.equals(theModel.getPassword())){
                System.out.println("Logged In!");
                signedInUser = user.get(0);
                loggedIn = true;
                return "home.xhtml?faces-redirect=true";
            }
            else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Incorrect Password!"));
            }
        }
        else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "User ID Does Not Exist!"));
        }
        if(context.getMessageList().size() > 0)
            return(null);
        return "loginFailed.xhtml?faces-redirect=true";
    }   
    
        
    public boolean isAdmin(){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        ArrayList<Users> user = aProfileDAO.findBySTUID(signedInUser.getUserID());
        return "TRUE".equals(user.get(0).getAdmin());
    }
    
    public String signOut(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
}