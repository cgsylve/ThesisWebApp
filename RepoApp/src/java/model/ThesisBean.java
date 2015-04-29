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
     
     private String courseNumber; 
     private String liveLink;
     private String keywordOne; 
     private String committeeChair; 
     private String semesterCompleted; 
     private String studentName; 
     private String dateCompleted; 
     
     
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

    /**
     * @return the courseNumber
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * @param courseNumber the courseNumber to set
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * @return the liveLink
     */
    public String getLiveLink() {
        return liveLink;
    }

    /**
     * @param liveLink the liveLink to set
     */
    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    /**
     * @return the keywordOne
     */
    public String getKeywordOne() {
        return keywordOne;
    }

    /**
     * @param keywordOne the keywordOne to set
     */
    public void setKeywordOne(String keywordOne) {
        this.keywordOne = keywordOne;
    }

    /**
     * @return the committeeChair
     */
    public String getCommitteeChair() {
        return committeeChair;
    }

    /**
     * @param committeeChair the committeeChair to set
     */
    public void setCommitteeChair(String committeeChair) {
        this.committeeChair = committeeChair;
    }

    /**
     * @return the semesterCompleted
     */
    public String getSemesterCompleted() {
        return semesterCompleted;
    }

    /**
     * @param semesterCompleted the semesterCompleted to set
     */
    public void setSemesterCompleted(String semesterCompleted) {
        this.semesterCompleted = semesterCompleted;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the dateCompleted
     */
    public String getDateCompleted() {
        return dateCompleted;
    }

    /**
     * @param dateCompleted the dateCompleted to set
     */
    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
     
     
     
     
    
}
