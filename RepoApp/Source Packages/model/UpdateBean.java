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
 * @author calebsylvester
 */
@ManagedBean
@SessionScoped
public class UpdateBean {
    
    private String liveLinkKey; 

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
    
    
}
