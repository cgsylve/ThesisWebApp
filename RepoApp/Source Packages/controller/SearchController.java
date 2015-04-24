/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SearchDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.LoginBean;
import model.ProjectBean;
import model.SearchBean;
import model.Thesis;
import model.UpdateBean;

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
   
    UpdateBean updateBean; 
    ArrayList<Thesis> arry;
   
    
    
    public SearchController() {
     projectBean = new ProjectBean(); 
     searchBean = new SearchBean();
     arry = new ArrayList<>();
     searchDAO = new SearchDAOImpl();
     
     updateBean = new UpdateBean();
    }

    
    public ProjectBean getProjectBean() {
        return projectBean;
    }
    
    
    public SearchBean getSearchBean(){
        return searchBean; 
    }
    
    public UpdateBean getUpdateBean(){
        return updateBean; 
    }
    
    public void setProjectBean(ProjectBean projectBean) {
        this.projectBean = projectBean;
    }
    
    public void setSearchBean(SearchBean searchBean){
        this.searchBean = searchBean; 
    }
    
    public void setUpdateBean(UpdateBean updateBean){
        this.updateBean = updateBean;
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
    
    public String getMyProjects(){
        String username = "cgsylve";
        
        
        
        arry = searchDAO.searchMyProjects(username);
        searchBean.setThesisList(arry);
        
        return "mp2.xhtml";
    }
    
    public String updateMyProject(){
        int rowCount; 
         
        String courseNum = projectBean.getCourseNumber();
        String liveLink = projectBean.getLiveLink();
        String key = projectBean.getKeywordOne();
        String chair = projectBean.getCommitteeChair();
        String semCompleted = projectBean.getSemesterCompleted();
        String stuName = projectBean.getStudentName();
        String dateCompleted = projectBean.getDateCompleted();
        
        rowCount = searchDAO.updateDetails(courseNum, liveLink, key, chair, semCompleted, stuName, dateCompleted);
        
        if (rowCount == 1)
            return "mp2.xhtml";
        
        else
            return "badUpdate.xhtml";
        
            
        
        
    }

    
}
