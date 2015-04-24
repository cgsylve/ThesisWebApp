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
public class ThesisBean {
    
     private Thesis thesis; 
     
     
     public ThesisBean(){
         thesis = new Thesis();
     }

    /**
     * @return the thesis
     */
    public Thesis getThesis() {
        return thesis;
    }

    /**
     * @param thesis the thesis to set
     */
    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
     
     
     
     
    
}
