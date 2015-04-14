/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProfileDAOImpl;
import dao.ProfileDAO;
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
@ManagedBean
@SessionScoped
public class SignInController {
    private Users theModel;
    private static int numAttempts = 0;
    
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
        if(numAttempts > 3)
            return "LoginBad.xhtml";
        while(numAttempts < 3){
            FacesContext context = FacesContext.getCurrentInstance(); 
            ProfileDAO aProfileDAO = new ProfileDAOImpl(); 
            ArrayList<Users> user = aProfileDAO.findByUserID(theModel.getUserID());
            if(user.size() > 0){
                String storedPass = user.get(0).getPassword();
                if(storedPass.equals(theModel.getPassword())){
                    return "LoginGood.xhtml";
                }
                else{
                    context.addMessage(null, new FacesMessage("Incorrect Password!"));
                    numAttempts++;
                }
            }
            else{
                context.addMessage(null, new FacesMessage("User ID Does Not Exist!"));
                numAttempts++;
            }
            if(context.getMessageList().size() > 0)
                return(null);
        }
        return "LoginBad.xhtml";
    }
    
}