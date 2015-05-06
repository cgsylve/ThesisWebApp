/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.activation.MimetypesFileTypeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Huan_Nguyen
 */
@ManagedBean
@ViewScoped
public class fileBean implements Serializable {

    private StreamedContent theFile;
    private String path;
    private String contentType;

    public StreamedContent getTheFile() throws IOException{
        return new DefaultStreamedContent(new FileInputStream(getPath()), getContentType());
    }

    public void setTheFile(StreamedContent theFile) {
        this.theFile = theFile;
    }

    /**
     * This Method will be called when download link is clicked
     * @param liveLink
     */
    public void downloadAction(String liveLink)
    {
        setPath(liveLink);
        setContentType(FacesContext.getCurrentInstance().getExternalContext().getMimeType(getPath()));
//        File tempFile = new File(liveLink);
//        try {
//            dFile = new DefaultStreamedContent(new FileInputStream(tempFile), new MimetypesFileTypeMap().getContentType(tempFile));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}