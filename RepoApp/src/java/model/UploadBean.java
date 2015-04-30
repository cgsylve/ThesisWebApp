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
 * @author Huan_Nguyen
 */
@SessionScoped
@ManagedBean
public class UploadBean {
    private String courseNumber;
    private String liveLink;
    private String keyWordOne;
    private String committeeChair;
    private String semesterComplete;
    private String studentName;
    private String dateCompleted;
    private String userID;
    
    public UploadBean() {
        String courseNumber = "";
        String liveLink = "";
        String keyWordOne = "";
        String committeeChair = "";
        String semesterComplete = "";
        String studentName = "";
        String dateCompleted = "";
        String userID = "";
    }
    
    public UploadBean(String courseNumber, String liveLink, String keyWordOne, String committeeChair,  String semesterComplete, String studentName, String dateCompleted, String userID) {
        this.courseNumber = courseNumber;
        this.liveLink = liveLink;
        this.keyWordOne = keyWordOne;
        this.committeeChair = committeeChair;
        this.semesterComplete = semesterComplete;
        this.studentName = studentName;
        this.dateCompleted = dateCompleted;
        this.userID = userID;
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
     * @return the keyWordDone
     */
    public String getKeyWordOne() {
        return keyWordOne;
    }

    /**
     * @param keyWordDone the keyWordDone to set
     */
    public void setKeyWordOne(String keyWordDone) {
        this.keyWordOne = keyWordDone;
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
     * @return the semesterComplete
     */
    public String getSemesterComplete() {
        return semesterComplete;
    }

    /**
     * @param semesterComplete the semesterComplete to set
     */
    public void setSemesterComplete(String semesterComplete) {
        this.semesterComplete = semesterComplete;
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

    /**
     * @return the UserID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.userID = UserID;
    }
}
