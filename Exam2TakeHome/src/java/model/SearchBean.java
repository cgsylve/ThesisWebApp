/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author calebsylvester
 */
@ManagedBean
@SessionScoped
public class SearchBean {
    private String userTimeSelected; 
    private String userGroupName; 
    ArrayList<ScheduledTime> myList;
    String message; 

    /**
     * @return the userTimeSelected
     */
    
    public SearchBean(){
        myList = new ArrayList<>();
    }
    public String getUserTimeSelected() {
        return userTimeSelected;
    }

    /**
     * @param userTimeSelected the userTimeSelected to set
     */
    public void setUserTimeSelected(String userTimeSelected) {
        this.userTimeSelected = userTimeSelected;
    }

    /**
     * @return the userGroupName
     */
    public String getUserGroupName() {
        return userGroupName;
    }

    /**
     * @param userGroupName the userGroupName to set
     */
    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }
    
    public String getMessage(){
        return message; 
    }
    
    public void setMessage (String message){
        this.message = message; 
    }
    
    
}
