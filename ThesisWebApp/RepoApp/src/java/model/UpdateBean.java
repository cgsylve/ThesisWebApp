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
public class UpdateBean {
    
    private String liveLinkKey; 
    private ArrayList <Thesis> thesisList; 
    

    
    public UpdateBean(){
        thesisList = new ArrayList();
    }
    
    public UpdateBean(String liveLinkKey){
        this.liveLinkKey = liveLinkKey; 
    }
    /**
     * @return the liveLinkKey
     */
    public String getLiveLinkKey() {
        return liveLinkKey;
    }

    /**
     * @param liveLinkKey the liveLinkKey to set
     */
    public void setLiveLinkKey(String liveLinkKey) {
        this.liveLinkKey = liveLinkKey;
    }

    /**
     * @return the thesisList
     */
    public ArrayList <Thesis> getThesisList() {
        return thesisList;
    }

    /**
     * @param thesisList the thesisList to set
     */
    public void setThesisList(ArrayList <Thesis> thesisList) {
        this.thesisList = thesisList;
    }
    
    

    
    
}
