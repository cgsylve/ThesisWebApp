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
    private String similarKeyword; 
    private String similarCatagory; 
    private String userID;
    private ArrayList<Thesis> thesisList;
    private ArrayList<Thesis> similarList;
    
    
    public SearchBean(){
        thesisList = new ArrayList<>(); 
        similarList = new ArrayList<>();
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

    /**
     * @return the similarKeyword
     */
    public String getSimilarKeyword() {
        return similarKeyword;
    }

    /**
     * @param similarKeyword the similarKeyword to set
     */
    public void setSimilarKeyword(String similarKeyword) {
        this.similarKeyword = similarKeyword;
    }

    /**
     * @return the similarCatagory
     */
    public String getSimilarCatagory() {
        return similarCatagory;
    }

    /**
     * @param similarCatagory the similarCatagory to set
     */
    public void setSimilarCatagory(String similarCatagory) {
        this.similarCatagory = similarCatagory;
    }

    /**
     * @return the similarList
     */
    public ArrayList<Thesis> getSimilarList() {
        return similarList;
    }

    /**
     * @param similarList the similarList to set
     */
    public void setSimilarList(ArrayList<Thesis> similarList) {
        this.similarList = similarList;
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
    
    
    
    
}
