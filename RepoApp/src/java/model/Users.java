/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Coty
 */

public class Users {
    private String firstName;
    private String lastName;
    private String userID;
    private String password;
    private String password2;
    private String email;
    private String secQ;
    private String secA;
    private String reason;
    private String admin;

    public Users(){
        
    }
    
    public Users(String userID, String password){
        this.userID = userID;
        this.password = password;
        this.admin = "FALSE";
    }
    
    public Users(String firstName, String lastName, String userID,
            String password, String password2, String email, String secQ, String secA, String reason, String admin){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.password2 = password2;
        this.email = email;
        this.secQ = secQ;
        this.secA = secA;
        this.reason = reason;
        this.admin = "FALSE";
    }
    
    public Users(String firstName, String lastName, String userID,
            String password, String email, String secQ, String secA, String reason, String admin){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.secQ = secQ;
        this.secA = secA;
        this.reason = reason;
        this.admin = "FALSE";
    }
    
    public Users(String firstName, String lastName, String userID,
            String password, String email, String secQ, String secA, String reason){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.secQ = secQ;
        this.secA = secA;
        this.reason = reason;
        this.admin = "FALSE";
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
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
     * @return the admin
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(String admin) {
        this.admin = admin;
    }
}

