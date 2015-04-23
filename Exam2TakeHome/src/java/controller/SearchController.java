/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.SearchBean;

/**
 *
 * @author calebsylvester
 */
@ManagedBean
@SessionScoped
public class SearchController {
    SearchBean searchBean; 
    
    
    public SearchController(){
        searchBean = new SearchBean();
        
    }
    
    public SearchBean getSearchBean(){
        return searchBean; 
    }
    
    public void setSearchBean(SearchBean searchBean){
        this.searchBean = searchBean; 
    }
    
    public String signUp(){
        SearchDAO searchDAO; 
        searchDAO = new SearchDAO();
        
        int valid; 
        String message; 
        String groupName = searchBean.getUserGroupName();
        String timeSelected = searchBean.getUserTimeSelected();
        
        valid = searchDAO.signUp(timeSelected, groupName);
        
        if (valid == 1)
            message = "You have been signed up for the time slot."; 
        else
            message = "Time Slot already taken, please select another time.";
        
        searchBean.setMessage(message);
        
        return message; 
    }
    
    
}
