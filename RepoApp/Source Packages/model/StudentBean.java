/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import dao.StudentDAOImpl;

/**
 *
 * @author Huan_Nguyen
 */
public class StudentBean {
    private String stuID;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String secQ;
    private String secA;
    private String reason;
    private String isAdmin;

    public StudentBean(){
        
    }
    
    public StudentBean(String stuID, String password, String fname, String lname, String email, String secQ, String secA, String reason, String isAdmin){
        this.stuID = stuID;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.secQ = secQ;
        this.secA = secA;
        this.reason = reason;
        this.isAdmin = isAdmin;
    }

    /**
     * @return the stuID
     */
    public String getStuID() {
        return stuID;
    }

    /**
     * @param stuID the stuID to set
     */
    public void setStuID(String stuID) {
        this.stuID = stuID;
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

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the secQ
     */
    public String getSecQ() {
        return secQ;
    }

    /**
     * @param secQ the secQ to set
     */
    public void setSecQ(String secQ) {
        this.secQ = secQ;
    }

    /**
     * @return the secA
     */
    public String getSecA() {
        return secA;
    }

    /**
     * @param secA the secA to set
     */
    public void setSecA(String secA) {
        this.secA = secA;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the isAdmin
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public static boolean authenticate(String username, String Password) {

        String user = username;
        String pass = Password;
        
        StudentDAOImpl login = new StudentDAOImpl();
        
      //  ArrayList userAuth = new ArrayList();
        
        ArrayList userAuth = login.findloginSTUID(user);

        HashMap<String, String> map = new HashMap<>();
        map.put(userAuth.get(0).toString(), userAuth.get(1).toString());
       
        
        if(map.containsKey(user)){
            if (map.get(user).equals(pass)) {
               return true;
             } else {
                return false;
            }
        }
        else
            return false;
    }
}
