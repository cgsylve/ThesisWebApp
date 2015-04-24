/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDAOImpl;
import dao.StudentDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Users;

/**
 *
 * @author Coty
 */
@ManagedBean(name="signUpController")
@SessionScoped
public class SignUpController {
    private Users theModel; 
    private String result = "";
    
    public SignUpController(){
        theModel = new Users();
    }
    
    public Users getTheModel(){
        return theModel;
    }
    
    public void setTheModel(Users theModel){
        this.theModel = theModel;
    }

    public static boolean userIDExists(String userID){
        StudentDAO aProfileDAO = new StudentDAOImpl();
        return(aProfileDAO.exist(userID));
    }
    
    public String createUser() {
        FacesContext context = FacesContext.getCurrentInstance(); 
        if(!theModel.getPassword().equals(theModel.getPassword2())){
            context.addMessage(null, new FacesMessage("Passwords do not match!"));
        }
        
//        if(theModel.getFirstName().length() > 25 || theModel.getFirstName().length() < 2){
//            context.addMessage(null,new FacesMessage("First name length must be between 2 and 25 characters in length."));
//        }
//        
//        if(theModel.getLastName().length() > 25 || theModel.getLastName().length() < 2){
//            context.addMessage(null,new FacesMessage("Last name length must be between 2 and 25 characters in length."));
//        }
        
        if(userIDExists(theModel.getUserID())){
            context.addMessage(null,new FacesMessage("User ID already taken."));
        }
        
        if(context.getMessageList().size() > 0)
            return(null);
        else{
            StudentDAO aProfileDAO = new StudentDAOImpl();    // Creating a new object each time.
            int rowCount = aProfileDAO.createUser(theModel); // Doing anything with the object after this?
            if (rowCount == 1){
                //JavaMailApp.sendMail(theModel);
                return "waitingForAdmin.xhtml?faces-redirect=true";
            }
            else
                return(null);
        }
         
    }

    /**
     * @return the result
     */
    public String getResult() {
        String userID, firstName, lastName, password, email, secQ, secA, reason;
            userID = theModel.getUserID();
            firstName = theModel.getFirstName();
            lastName = theModel.getLastName();
            password = theModel.getPassword();
            email = theModel.getEmail();
            secQ = theModel.getSecQ();
            secA = theModel.getSecA();
            reason = theModel.getReason();
        result = "<h2>You are now signed up for Thesis Repository!</h2>"
                    + "<p>UserID: " + userID + "<br/>"
                    + "First Name: " + firstName + "<br/>"
                    + "Last Name: " + lastName + "<br/>"
                    + "Password: " + password + "<br/>"
                    + "Email: " + email + "<br/>"
                    + "Security Question: " + secQ + "<br/>"
                    + "Security Answer: " + secA + "<br/>"
                    + "Reason: " + reason + "<br/>"
                    +"</p>";
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
}

