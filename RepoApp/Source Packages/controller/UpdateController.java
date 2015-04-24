/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UpdateDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Thesis;
import model.ThesisBean;
import model.UpdateBean;

/**
 *
 * @author calebsylvester
 */

@ManagedBean
@SessionScoped
public class UpdateController {
    
    private UpdateBean updateBean; 
    private ArrayList<Thesis> arry; 
    private Thesis initThesis; 
    private ThesisBean thesisBean; 
    
    public UpdateController(){
        updateBean = new UpdateBean();
        arry = new ArrayList();
        initThesis = new Thesis();
        thesisBean = new ThesisBean();
    }
    
    /**
     * @return the updateBean
     */
    public UpdateBean getUpdateBean() {
        return updateBean;
    }

    /**
     * @param updateBean the updateBean to set
     */
    public void setUpdateBean(UpdateBean updateBean) {
        this.updateBean = updateBean;
    }
    
    /**
     * @return the arry
     */
    public ArrayList<Thesis> getArry() {
        return arry;
    }

    /**
     * @param arry the arry to set
     */
    public void setArry(ArrayList<Thesis> arry) {
        this.arry = arry;
    }
    
    /**
     * @return the initThesis
     */
    public Thesis getInitThesis() {
        return initThesis;
    }

    /**
     * @param initThesis the initThesis to set
     */
    public void setInitThesis(Thesis initThesis) {
        this.initThesis = initThesis;
    }

    /**
     * @return the thesisBean
     */
    public ThesisBean getThesisBean() {
        return thesisBean;
    }

    /**
     * @param thesisBean the thesisBean to set
     */
    public void setThesisBean(ThesisBean thesisBean) {
        this.thesisBean = thesisBean;
    }

    /**
     * @return the thesis
     */
    
    public String populateForm(){
        
        UpdateDAOImpl updateDAO = new UpdateDAOImpl();
        String key = updateBean.getLiveLinkKey();
        
        initThesis = updateDAO.prepopulateUpdateForm(key);
        thesisBean.setThesis(initThesis);
        
        return "update.xhtml";
    }

    
    
}
