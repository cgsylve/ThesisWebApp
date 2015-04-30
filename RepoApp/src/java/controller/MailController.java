/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MailDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
//    public String addToList(){
//        MailDAOImpl mailDAO = new MailDAOImpl();
//        StudentDAO studentDAO = new StudentDAOImpl();
//        
//        String stuToAdd = studentDAO.findBySTUID(signedInUser.getUserID());
//        
//    }
}
