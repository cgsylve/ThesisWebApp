/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ProjectBean;
import model.SearchBean;

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
    String query; 
    
    
    public SearchController() {
     projectBean = new ProjectBean(); 
     searchBean = new SearchBean();

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
    
    public void searchDatabase(){
        query = "SELECT COURSENUMBER FROM PROJECTTABLE " + 
                "WHERE " + searchBean.getSearchType() + "='" + searchBean.getSearchTerm() + "';";
//        searchDAO.searchProjects(query);
        System.out.println(query);
    }
    
}
