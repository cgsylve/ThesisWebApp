/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ProjectBean;
import model.SearchBean;
import model.Thesis;

/**
 *
 * @author calebsylvester
 */

@ManagedBean
@SessionScoped
public class SearchController {
    
    ProjectBean projectBean; 
    SearchDAOImpl searchDAO; 
    SearchBean searchBean; 
    Thesis thesis; 
    String query; 
    ArrayList<Thesis> arry;
   
    
    
    public SearchController() {
     projectBean = new ProjectBean(); 
     searchBean = new SearchBean();
     arry = new ArrayList<>();
     searchDAO = new SearchDAOImpl();
    }

    
    public ProjectBean getProjectBean() {
        return projectBean;
    }
    
    
    public SearchBean getSearchBean(){
        return searchBean; 
    }
    
    public void setProjectBean(ProjectBean projectBean) {
        this.projectBean = projectBean;
    }
    
    public void setSearchBean(SearchBean searchBean){
        this.searchBean = searchBean; 
    }
    
    public Thesis getThesis(){
        return thesis; 
    }
    
    public void setThesis(Thesis thesis){
        this.thesis = thesis; 
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
    
    public String searchDatabase(){
        
        String searchTerm = searchBean.getSearchTerm();
        String searchType = searchBean.getSearchType();
        
        arry = searchDAO.searchProjects(searchType, searchTerm);
        searchBean.setThesisList(arry);
       
        
        return "searchResults.xhtml";
    }

    
}
