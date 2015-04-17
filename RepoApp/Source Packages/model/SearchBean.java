/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author calebsylvester
 */

@ManagedBean
@SessionScoped
public class SearchBean {
    
    private String searchType; 
    private String searchTerm;
    private ArrayList<Thesis> thesisList;
    
    
    public SearchBean(){
        thesisList = new ArrayList<>(); 
    }
    
    public SearchBean(String searchType, String searchTerm){
        this.searchType = searchType; 
        this.searchTerm = searchTerm;
    }

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the searchTerm
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * @param searchTerm the searchTerm to set
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * @return the thesisList
     */
    public ArrayList<Thesis> getThesisList() {
        return thesisList;
    }

    /**
     * @param thesisList the thesisList to set
     */
    public void setThesisList(ArrayList<Thesis> thesisList) {
        this.thesisList = thesisList;
    }
    
    
    
    
}
