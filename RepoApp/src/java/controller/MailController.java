/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MailDAOImpl;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.MailBean;
import model.Users;

/**
 *
 * @author calebsylvester
 */
@ManagedBean
@SessionScoped
public class MailController {
    private MailBean mailBean; 
    private Users signedInUser; 
    
    public MailController(){
        mailBean = new MailBean();
    }

    /**
     * @return the mailBean
     */
    public MailBean getMailBean() {
        return mailBean;
    }

    /**
     * @param mailBean the mailBean to set
     */
    public void setMailBean(MailBean mailBean) {
        this.mailBean = mailBean;
    }
    
    public void addToList(){
        MailDAOImpl mailDAO = new MailDAOImpl();
        int result; 
        FacesContext context = FacesContext.getCurrentInstance();
        String email = mailBean.getUserEmail();
        
        
        result = mailDAO.addToList(email);
        
        if (result == 1)
            context.addMessage(null, new FacesMessage(null, "Success", "You have been added to the list"));
        else
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "You have not been added"));
            
        
        
    }
    
    public void removeFromList(){
        MailDAOImpl mailDAO = new MailDAOImpl();
        int result; 
        FacesContext context = FacesContext.getCurrentInstance();
        String email = mailBean.getUserEmail();
        
        result = mailDAO.removeFromList(email);
        
        if (result == 1)
            context.addMessage(null, new FacesMessage(null, "Success", "You have been added to the list"));
        else
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "You have not been added"));
    }
    
//    public String removeFromList(){
//    
//    }
}
