/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.faces.context.FacesContext;
import model.StudentBean;
import dao.StudentDAOImpl;

/**
 *
 * @author Huan_Nguyen
 */
public class LoginController {
    private StudentBean stuModel;
    private String userName;
    private String password;
    
    public String login() {
        StudentDAOImpl stulogin = new StudentDAOImpl();
        if (stulogin.exist(userName)) {
            if (StudentBean.authenticate(userName, password)) {
                ArrayList studentCollection = stulogin.findBySTUID(userName);
                stuModel = (StudentBean)studentCollection.get(0);
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedInStu", stuModel.getStuID());

                
           
                return "loginSuccess.xhtml";
            }
        }
        return "loginFailed.xhtml";
    }
    
    public LoginController() {
        stuModel = new StudentBean();
    }

    /**
     * @return the stuModel
     */
    public StudentBean getStuModel() {
        return stuModel;
    }

    /**
     * @param stuModel the stuModel to set
     */
    public void setStuModel(StudentBean stuModel) {
        this.stuModel = stuModel;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
